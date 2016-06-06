/*
 * Créé le 6 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.ria.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Managed bean pour faire de l'ajax.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
@ManagedBean(name = "mbSalut")
@SessionScoped
public class ManagedBeanSalut {

    private List<String> liste = new ArrayList<>();

    private String aAjouter;

    public ManagedBeanSalut() {
        liste.add("premier élément");
        liste.add("deuxieme élément");
    }
    
    public String ajouterALaListe() {
        liste.add(aAjouter);
        return "";
    }
    
    public List<String> getListe() {
        return liste;
    }

    public void setListe(List<String> paramListe) {
        liste = paramListe;
    }

    public String getaAjouter() {
        return aAjouter;
    }

    public void setaAjouter(String paramAAjouter) {
        aAjouter = paramAAjouter;
    }

}
