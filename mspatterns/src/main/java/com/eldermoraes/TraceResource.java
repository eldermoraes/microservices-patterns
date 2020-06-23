package com.eldermoraes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.opentracing.Traced;

@Path("/trace")
public class TraceResource {
    
    @GET
    @Traced
    public String getTrace(){
        return "Trace";
    }
}