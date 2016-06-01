package fr.afcepf.atod26.ria.rest.config;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class TestRest {

    @GET()
    @Produces("text/plain")
    @Path("/salut")
    public String sayHello() {
        return "Hello World!";
    }
}
