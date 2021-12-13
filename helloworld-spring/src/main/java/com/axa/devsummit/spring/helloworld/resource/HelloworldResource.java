package com.axa.devsummit.spring.helloworld.resource;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/hello")
public class HelloworldResource {

    @GET
    public String message() {
        return "Hello";
    }

}
