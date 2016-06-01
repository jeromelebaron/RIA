package fr.afcepf.atod26.ria.rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import fr.afcepf.atod26.ria.rest.service.DaoChienRest;
import fr.afcepf.atod26.ria.rest.service.TestRest;

@ApplicationPath("/ria-rest")
public class RIARestApplication extends Application {

    /**
     * Pour ajouter les différentes classe aux ressources disponibles et exposées au WS.
     * {@inheritDoc}
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> ressources = new HashSet<Class<?>>();
        ressources.add(TestRest.class);
        ressources.add(DaoChienRest.class);
        return ressources;
    }
}
