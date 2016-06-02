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

/**
 * Les différentes méthodes exposées du WS.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
@Path("/chien")
@Produces(MediaType.APPLICATION_JSON)
public class DaoChienRest {

    /**
     * L'instance pour le dao du {@link PetitChien}.
     */
    @EJB
    private IDaoPetitChien daoPetitChien;

    /**
     * Pour récupérer un {@link PetitChien} via son id.
     * @param paramId l'id du {@link PetitChien} à chercher.
     * @return un {@link PetitChien}.
     */
    @GET
    @Path("/{id}")
    public PetitChien getChienById(@PathParam(value = "id") Integer paramId) {
        return daoPetitChien.getChienById(paramId);
    }

}
