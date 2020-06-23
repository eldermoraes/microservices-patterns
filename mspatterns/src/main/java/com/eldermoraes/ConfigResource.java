package com.eldermoraes;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/config")
public class ConfigResource {
    
    @ConfigProperty(name = "config")
    private Optional<String> config;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConfig(){
        return Response.ok("Hello, " + config.orElse("Config")).build() ;
    }
}