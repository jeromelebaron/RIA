/*
 * Créé le 1 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.ria.rest.api;

import java.util.List;

import fr.afcepf.atod26.ria.rest.entity.PetitChien;

/**
 * Les méthodes concernant la persitence de {@link PetitChien}.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public interface IDaoPetitChien {

    /**
     * Pour récupérer un {@link PetitChien} par son id.
     * @param idChien l'id du {@link PetitChien}.
     * @return un {@link PetitChien}.
     */
    PetitChien getChienById(Integer idChien);

    /**
     * Pour insérer un {@link PetitChien}.
     * @param paramPetitChien le {@link PetitChien} à insérer.
     * @return un {@link PetitChien} avec son id.
     */
    PetitChien insertPetitChient(PetitChien paramPetitChien);

    /**
     * Pour récupérer tous les {@link PetitChien}.
     * @return une liste de {@link PetitChien}.
     */
    List<PetitChien> getAllChien();

    /**
     * Pour mettre à jour un {@link PetitChien}.
     * @param paramPetitChien le {@link PetitChien} à mettre à jour.
     * @return le {@link PetitChien} mise à jour.
     */
    PetitChien updateChien(PetitChien paramPetitChien);

    /**
     * Pour supprimer un {@link PetitChien}.
     * @param paramPetitChien le {@link PetitChien} à supprimer.
     */
    void deleteChien(PetitChien paramPetitChien);
}
