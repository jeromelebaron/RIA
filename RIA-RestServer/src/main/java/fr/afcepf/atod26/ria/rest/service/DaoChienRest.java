/*
 * Créé le 1 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.ria.rest.service;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

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
     * Pour faire du log.
     */
    private static final Logger LOGGER = Logger.getLogger(DaoChienRest.class);

    /**
     * L'instance pour le dao du {@link PetitChien}.
     */
    private IDaoPetitChien daoPetitChien;

    /**
     * Constructeur.
     */
    public DaoChienRest() {
        try {
            Context context = new InitialContext();
            daoPetitChien = (IDaoPetitChien) context
                    .lookup("java:global/RIA-RestServer/DaoPetitChienImpl");
        } catch (NamingException e) {
            LOGGER.error(e);
        }
    }

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

    /**
     * Pour récupérer tous les {@link PetitChien}.
     * @return une liste de {@link PetitChien}.
     */
    @GET
    @Path("/chiens")
    public List<PetitChien> getAllChien() {
        return daoPetitChien.getAllChien();
    }

}
