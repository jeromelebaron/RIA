/*
 * Créé le 1 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.ria.rest.service;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.afcepf.atod26.ria.rest.api.IDaoPetitChien;
import fr.afcepf.atod26.ria.rest.entity.PetitChien;

@Path("/chien")
@Produces(MediaType.APPLICATION_JSON)
public class DaoChienRest {

    @EJB
    private IDaoPetitChien daoPetitChien;

    @GET
    @Path("/{id}")
    public PetitChien getChienById(@PathParam(value = "id") Integer paramId) {
        return daoPetitChien.getChienById(paramId);
    }

}
