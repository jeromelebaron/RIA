/**
 * Créé le 1 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.ria.rest.impl;

import java.util.List;

import javax.ejb.Stateless;
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
@Stateless
public class DaoPetitChienImpl implements IDaoPetitChien {

    @PersistenceContext(unitName = "RIA-RestServer")
    private EntityManager em;

    private static final String GET_ALL_CHIEN = "FROM PetitChien";

    /**
     * {@inheritDoc}
     */
    @Override
    public PetitChien getChienById(Integer idChien) {
        return em.find(PetitChien.class, idChien);
    }

    @Override
    public PetitChien insertPetitChient(final PetitChien paramPetitChien) {
        em.persist(paramPetitChien);
        return paramPetitChien;
    }

    @Override
    public List<PetitChien> getAllChien() {
        TypedQuery<PetitChien> query = em.createNamedQuery(GET_ALL_CHIEN, PetitChien.class);
        return query.getResultList();
    }

    @Override
    public PetitChien updateChien(PetitChien paramPetitChien) {
        em.merge(paramPetitChien);
        em.flush();
        return paramPetitChien;
    }

    @Override
    public void deleteChien(PetitChien paramPetitChien) {
        PetitChien aSuppr = em.merge(paramPetitChien);
        em.remove(aSuppr);
    }

}
