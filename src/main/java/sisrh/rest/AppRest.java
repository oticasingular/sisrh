package sisrh.rest;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class AppRest extends Application {

    public AppRest() {
        BeanConfig conf = new BeanConfig();
        conf.setTitle("SISRH Servicos REST");
        conf.setDescription("Sistema de Recursos Humanos - SISRH");
        conf.setVersion("1.0.0");
        conf.setHost("localhost:8090");
        conf.setBasePath("/sisrh/rest");
        conf.setSchemes(new String[] { "http" });
        conf.setResourcePackage("sisrh.rest");
        conf.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(SistemaRest.class);
        resources.add(EmpregadoRest.class);
        resources.add(SolicitacaoRest.class);
        resources.add(LoginUnicoRest.class);

        resources.add(ApiListingResource.class);
        resources.add(SwaggerSerializers.class);
        return resources;
    }

}