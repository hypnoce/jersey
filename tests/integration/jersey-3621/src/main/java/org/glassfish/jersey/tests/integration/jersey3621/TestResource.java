package org.glassfish.jersey.tests.integration.jersey3621;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.glassfish.jersey.internal.inject.InjectionManager;

@Path("ambiguous")
@Singleton
public class TestResource {

    @Inject
    HttpServletRequest request;

    @GET
    @Produces("text/plain")
    public String test() throws Exception {
        return request.getMethod();
    }
}
