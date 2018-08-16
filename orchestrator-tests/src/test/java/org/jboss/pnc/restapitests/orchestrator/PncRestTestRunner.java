package org.jboss.pnc.restapitests.orchestrator;

import org.jboss.pnc.rest.endpoint.AbstractEndpoint;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import java.util.Map;

public class PncRestTestRunner {

    private static PncRestTestRunner runner;

    private ResteasyClient client;
    private ResteasyWebTarget target;

    private PncRestTestConfig testConfig;

    @SuppressWarnings("rawtypes")
    private Map<Class<?>, AbstractEndpoint> services;


    public static PncRestTestRunner getInstance(final PncRestTestConfig testConfig) {
        if (runner == null) {
            runner = new PncRestTestRunner(testConfig);
        }
        return runner;
    }

    private PncRestTestRunner(PncRestTestConfig testConfig) {
        // TODO Auto-generated constructor stub
    }

    public Boolean canRunThis(final Class<?> cls) {
        return testConfig.isRunnable(cls);
    }

    public static void dropInstance() {
        if (runner != null) {
            if (runner.client != null) {
                runner.client.close();
            }
        }
    }

    @SuppressWarnings({ "unchecked" })
    public <T extends AbstractEndpoint<?, ?>> T getEndpoint(Class<T> endpointClass) {
        if (!services.containsKey(endpointClass)) {
            if (target == null) {
                if (client == null) {
                    client = new ResteasyClientBuilder().build();
                }
                target = client.target(testConfig.getPncRestAddress());
            }

            T service = target.proxy(endpointClass);
            services.put(endpointClass, service);
        }
        return (T) services.get(endpointClass);
    }

}
