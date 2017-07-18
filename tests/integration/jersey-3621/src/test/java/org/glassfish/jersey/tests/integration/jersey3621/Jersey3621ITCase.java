package org.glassfish.jersey.tests.integration.jersey3621;

import java.io.IOException;
import java.util.Objects;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.external.ExternalTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerException;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;


public class Jersey3621ITCase extends JerseyTest {

    @Override
    protected Application configure() {
        return new TestApplication();
    }

    @Override
    protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
        return new ExternalTestContainerFactory();
    }

    @Test
    public void testCorrectInjection() throws IOException {
       final String get = target("ambiguous").request().get(String.class);
       assert Objects.equals("GET", get);
    }
}
