package fr.afcepf.atod26.ria.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.afcepf.atod26.ria.rest.entity.PetitChien;

@Path("/test")
public class TestRest {

    @GET()
    @Produces("text/plain")
    @Path("/salut")
    public String sayHello() {
        return "Hello World!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/methode/{nom}/{race}")
    public PetitChien getByNomAndRace(@PathParam(value = "nom") String paramNom,
            @PathParam(value = "race") String paramRace) {
        /*IDaoPetitChien daoPetitChien = new DaoPetitChienImpl();
        return daoPetitChien.getByNomAndRace(paramNom, paramRace);*/
        PetitChien petitChien = new PetitChien();
        petitChien.setId(5);
        petitChien.setNom(paramNom);
        petitChien.setRace(paramRace);
        petitChien.setAge(10);
        petitChien.setLof(true);
        return petitChien;
    }
}
