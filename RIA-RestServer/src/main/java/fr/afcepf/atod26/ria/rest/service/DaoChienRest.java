/**
 * Créé le 1 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.ria.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
     * La liste des erreurs au moment de l'insert du {@link PetitChien}.
     */
    private List<String> erreurs = new ArrayList<>();

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
    @Path("/id/{id}")
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

    /**
     * Pour persister un {@link PetitChien} dans la bdd.
     * @param paramPetitChien le {@link PetitChien} à ajouter.
     * @return le {@link PetitChien} avec son id.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/ajout")
    public Response ajouterChien(PetitChien paramPetitChien) {
        validateChien(paramPetitChien);
        if (erreurs.isEmpty()) {
            daoPetitChien.insertPetitChient(paramPetitChien);
            return Response.ok(paramPetitChien).build();
        } else {
            return Response.serverError().entity(erreurs).build();
        }
    }

    /**
     * Pour faire les vérifications sur le {@link PetitChien} avant la persistance.
     */
    private void validateChien(PetitChien paramPetitChien) {
        Validator localValidator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<PetitChien>> localConstraintViolations = localValidator
                .validate(paramPetitChien);
        for (ConstraintViolation<PetitChien> localConstraintViolation : localConstraintViolations) {
            erreurs.add("La propriété " + localConstraintViolation.getPropertyPath()
                    + " est invalide : " + localConstraintViolation.getMessage()
                    + ". Donnée entrée : " + localConstraintViolation.getInvalidValue());
        }
    }

    public List<String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(List<String> paramErreurs) {
        erreurs = paramErreurs;
    }

}
