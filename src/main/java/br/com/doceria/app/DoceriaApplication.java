package br.com.doceria.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.doceria.resource.ClienteResource;
import br.com.doceria.resource.ProdutoResource;
import br.com.doceria.resource.UsuarioResource;

@ApplicationPath("/ws")
public class DoceriaApplication extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();

        classes.add(UsuarioResource.class);
        classes.add(ClienteResource.class);
        classes.add(ProdutoResource.class);
        return classes;
    }

}
