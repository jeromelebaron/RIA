/**
 * Créé le 1 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.ria.rest.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.afcepf.atod26.ria.rest.api.IDaoPetitChien;
import fr.afcepf.atod26.ria.rest.entity.PetitChien;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public class DaoPetitChienImpl implements IDaoPetitChien {

    @PersistenceContext
    private EntityManager em;

    private static final String GET_BY_NOM_AND_RACE = "From PetitChien p WHERE p.nom = :nom and p.race = :race";

    /**
     * {@inheritDoc}
     */
    @Override
    public PetitChien getByNomAndRace(String paramNom, String paramRace) {
        TypedQuery<PetitChien> query = em.createQuery(GET_BY_NOM_AND_RACE, PetitChien.class);
        query.setParameter("nom", paramNom);
        query.setParameter("race", paramRace);
        return query.getSingleResult();
    }

    @Override
    public PetitChien insertPetitChient(PetitChien paramPetitChien) {
        em.persist(paramPetitChien);
        return paramPetitChien;
    }

}
