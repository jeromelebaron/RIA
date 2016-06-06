/**
 * Créé le 1 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.ria.rest.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.afcepf.atod26.ria.rest.api.IDaoPetitChien;
import fr.afcepf.atod26.ria.rest.entity.PetitChien;

/**
 * L'implémentation du dao du {@link PetitChien}.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
@Remote(IDaoPetitChien.class)
@Stateless
public class DaoPetitChienImpl implements IDaoPetitChien {

    /**
     * L'entity manager JPA.
     */
    @PersistenceContext(unitName = "RIA-RestServer")
    private EntityManager em;

    /**
     * La requête HQL pour récupérer tous les {@link PetitChien}.
     */
    private static final String GET_ALL_CHIEN = "FROM PetitChien p";

    /**
     * {@inheritDoc}
     */
    @Override
    public PetitChien getChienById(Integer idChien) {
        return em.find(PetitChien.class, idChien);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PetitChien insertPetitChient(final PetitChien paramPetitChien) {
        em.persist(paramPetitChien);
        return paramPetitChien;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PetitChien> getAllChien() {
        TypedQuery<PetitChien> query = em.createQuery(GET_ALL_CHIEN, PetitChien.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PetitChien updateChien(PetitChien paramPetitChien) {
        em.merge(paramPetitChien);
        em.flush();
        return paramPetitChien;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteChien(PetitChien paramPetitChien) {
        PetitChien aSuppr = em.merge(paramPetitChien);
        em.remove(aSuppr);
    }

}
