package com.eldermoraes.health;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("https://eldermoraes.com").request().get();

        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)){
            return HealthCheckResponse.up("I'm ready!");
        } else{ 
            return HealthCheckResponse.down("I'm not ready yet...");
        }
    }
    
}