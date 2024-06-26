use std::io;

use actix_files::Files;
use actix_web::{App, get, HttpResponse, HttpServer, Responder, web::Data};
use handlebars::Handlebars;
use serde::Serialize;

#[derive(Serialize)]
struct Compliment {
    adjective: &'static str,
    verb: &'static str
}

#[get("/")]
async fn hello() -> impl Responder {
    HttpResponse::Ok().body("Hello, world!")
}

#[get("/compliment")]
async fn compliment(hb: Data<Handlebars<'_>>) -> impl Responder {
    let compliment = Compliment {
        adjective: "most stellar",
        verb: "known and/or dreamed of",
    };
    let html = hb.render("compliment", &compliment).unwrap();

    HttpResponse::Ok()
        .content_type("text/html")
        .body(html)
}

#[actix_web::main]
async fn main() -> io::Result<()> {

    // let address = env::var("BIND_ADDRESS").unwrap_or_else(|_err| "localhost:8080".to_string());
    let address = "0.0.0.0:8080";

    let template_service = {
        let mut handlebars = Handlebars::new();

        handlebars
            .register_templates_directory(".html","web/templates")
            .unwrap();

        Data::new(handlebars)
    };

    let server = move || App::new()
        .app_data(template_service.clone())
        .service(Files::new("/public", "web/public").show_files_listing())
        .service(compliment)
        .service(hello);

    HttpServer::new(server)
        .bind(address)?
        .run()
        .await
}