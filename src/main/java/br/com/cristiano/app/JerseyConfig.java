package br.com.cristiano.app;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.com.cristiano.resource.HealthCheckResource;
import br.com.cristiano.resource.MalhaResource;
import br.com.cristiano.resource.RotaResource;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(MalhaResource.class);
		register(HealthCheckResource.class);
		register(RotaResource.class);
	}
}
