package com.eldermoraes;

import java.time.temporal.ChronoUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

@Path("/circuit")
public class CircuitResource {
    
    @Timeout(unit = ChronoUnit.MILLIS, value = 500)
    //@Retry(maxRetries = 3, delayUnit = ChronoUnit.MILLIS, delay = 500)
    @Fallback(fallbackMethod = "fallback")
    @GET
    public String getCircuit() throws InterruptedException {
        Thread.sleep(400);
        return "Circuit";
    }

    public String fallback(){
        return "I'm a fallback";
    }
}