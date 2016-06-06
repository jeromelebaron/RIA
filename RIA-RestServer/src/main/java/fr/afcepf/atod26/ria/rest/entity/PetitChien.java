/*
 * Créé le 1 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.ria.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * L'entité pour le tp.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
@Entity
@Table(name = "petit_chien")
public class PetitChien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_petit_chien")
    private Integer id;

    @Size(min = 2)
    @Column(name = "nom", nullable = false, length = 45)
    private String nom;

    @Size(min = 2)
    @Column(name = "race", nullable = false, length = 45)
    private String race;

    @Min(0)
    @Column(name = "age", nullable = false)
    private Integer age;

    @NotNull
    @Column(name = "est_lof", nullable = false)
    private boolean isLof;

    public PetitChien() {
        // EMPTY
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer paramId) {
        id = paramId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String paramNom) {
        nom = paramNom;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String paramRace) {
        race = paramRace;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer paramAge) {
        age = paramAge;
    }

    public boolean isLof() {
        return isLof;
    }

    public void setLof(boolean paramIsLof) {
        isLof = paramIsLof;
    }

}
