# syntax=docker/dockerfile:1

FROM rust:1.71 as builder

# Update Rust
# Update your stable version by running "rustup update stable"
# If you want to use nightly version, use this:
RUN rustup default nightly && rustup update


WORKDIR /home/explorer436/Downloads/GitRepositories/programming-playground/rust-playground/hello-world-rest-service


COPY . .
RUN cargo install --path .

FROM debian:stable-slim
WORKDIR /app
COPY --from=builder /usr/local/cargo/bin/hello-world-rest-service /usr/local/bin/hello-world-rest-service
COPY --from=builder /home/explorer436/Downloads/GitRepositories/programming-playground/rust-playground/hello-world-rest-service/web ./web
EXPOSE 8080
CMD ["hello-world-rest-service"]