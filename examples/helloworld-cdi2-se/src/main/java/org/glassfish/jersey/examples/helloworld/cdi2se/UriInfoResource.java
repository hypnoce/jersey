package org.glassfish.jersey.examples.helloworld.cdi2se;

import org.glassfish.jersey.server.ExtendedUriInfo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;

@Path("uri")
@Singleton
public class UriInfoResource {

    @Inject
    private Provider<ExtendedUriInfo> infosProviderCDI;

    @Context
    private Provider<ExtendedUriInfo> infosProviderJXRS;

    @Context
    private ExtendedUriInfo infosProxy;

    @GET
    @Path("providerCDI")
    @Produces("text/plain")
    public String providerCDI() {
        return infosProviderCDI.get().getPath();
    }

    @GET
    @Path("providerJXRS")
    @Produces("text/plain")
    public String providerJXRS() {
        return infosProviderJXRS.get().getPath();
    }

    @GET
    @Path("proxy")
    @Produces("text/plain")
    public String proxy() {
        return infosProxy.getPath();
    }
}
