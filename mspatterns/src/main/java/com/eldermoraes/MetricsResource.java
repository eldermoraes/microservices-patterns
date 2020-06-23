package com.eldermoraes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

@Path("/mymetrics")
public class MetricsResource {
    
    @GET
    @Path("counted")
    @Counted
    public String getCounted(){
        return "Counted";
    }

    @GET
    @Path("timed")    
    @Timed
    public String getTimed(){
        return "Timed";
    }
}