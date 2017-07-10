package org.glassfish.jersey.examples.helloworld.cdi2se;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UriInfoTest extends JerseyTest {

    @Override
    protected ResourceConfig configure() {
        return new ResourceConfig(UriInfoResource.class);
    }

    @Test
    public void testInfosProxy() {
        String response = target().path(App.ROOT_URI_PATH).path("proxy").request().get(String.class);
        assertEquals("uri/proxy", response);
    }

    @Test
    public void testInfosProviderJXRS() {
        String response = target().path(App.ROOT_URI_PATH).path("providerJXRS").request().get(String.class);
        assertEquals("uri/providerJXRS", response);
    }

    @Test
    public void testInfosProviderCDI() {
        String response = target().path(App.ROOT_URI_PATH).path("providerCDI").request().get(String.class);
        assertEquals("uri/providerCDI", response);
    }
}
