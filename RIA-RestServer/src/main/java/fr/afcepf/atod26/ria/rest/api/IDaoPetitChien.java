/*
 * Créé le 1 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.ria.rest.api;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.atod26.ria.rest.entity.PetitChien;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
@Local
public interface IDaoPetitChien {

    PetitChien getChienById(Integer idChien);

    PetitChien insertPetitChient(PetitChien paramPetitChien);

    List<PetitChien> getAllChien();

    PetitChien updateChien(PetitChien paramPetitChien);

    void deleteChien(PetitChien paramPetitChien);
}
