/*
 * Créé le 6 juin 2016 par Jérome LE BARON
 */
package fr.afcepf.atod26.ria.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.afcepf.atod26.ria.rest.api.IDaoPetitChien;
import fr.afcepf.atod26.ria.rest.entity.PetitChien;

/**
 * Pour afficher le tableau des chiens.
 * @author Jérome LE BARON
 * @author $LastChangedBy$
 * @version $Revision$ $Date$
 */
@ManagedBean
@SessionScoped
public class ManagedBeanChien {

    private IDaoPetitChien daoPetitChien;

    private List<PetitChien> lesPetitChiens;

    public ManagedBeanChien() {
        try {
            Context context = new InitialContext();
            daoPetitChien = (IDaoPetitChien) context
                    .lookup("java:global/RIA-RestServer/DaoPetitChienImpl");
            lesPetitChiens = daoPetitChien.getAllChien();
        } catch (NamingException e) {
        }
    }

    public List<PetitChien> getLesPetitChiens() {
        return lesPetitChiens;
    }

    public void setLesPetitChiens(List<PetitChien> paramLesPetitChiens) {
        lesPetitChiens = paramLesPetitChiens;
    }

}
