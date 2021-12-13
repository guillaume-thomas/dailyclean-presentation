package com.axa.devsummit.spring.helloworld.config;

import com.axa.devsummit.spring.helloworld.resource.HelloworldResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloworldResource.class);
    }
}
