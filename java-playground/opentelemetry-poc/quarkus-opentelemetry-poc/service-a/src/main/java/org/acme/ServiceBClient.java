package org.acme;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
@RegisterRestClient(configKey = "service-b")
public interface ServiceBClient {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String getHello();
}
