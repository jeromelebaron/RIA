/*
 * Créé le 1 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.ria.rest.api;

import fr.afcepf.atod26.ria.rest.entity.PetitChien;

/**
 * Description de la classe
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
public interface IDaoPetitChien {

    PetitChien getByNomAndRace(String paramNom, String paramRace);

    PetitChien insertPetitChient(PetitChien paramPetitChien);
}
