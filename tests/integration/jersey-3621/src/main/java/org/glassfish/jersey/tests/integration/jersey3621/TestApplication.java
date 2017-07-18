package org.glassfish.jersey.tests.integration.jersey3621;

import javax.enterprise.inject.Vetoed;

import org.glassfish.jersey.server.ResourceConfig;

@Vetoed
public class TestApplication extends ResourceConfig {

    public TestApplication() {
        register(TestResource.class);
    }
}
