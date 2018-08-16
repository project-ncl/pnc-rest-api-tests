package org.jboss.pnc.restapitests.orchestrator;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class PncRestTestConfig {

    private Map<Class<?>, Boolean> runnableTests = new HashMap<>();

    Map<String, String> configValues = new HashMap<>();

    @SuppressWarnings("unchecked")
    public PncRestTestConfig() {
        String config = System.getProperty("config");
        if (StringUtils.isEmpty(config)) {
            throw new IllegalArgumentException("The system property 'config' was not set.");
        }

        byte[] json;
        try {
            json = Files.readAllBytes(Paths.get(config));
        } catch (IOException ex) {
            throw new IllegalStateException("Unable to read config from " + config, ex);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            configValues = objectMapper.readValue(json, HashMap.class);
        } catch (IOException ex) {
            throw new IllegalStateException("Unable to parse config from " + config + ". The config contents were:\n"
                    + json, ex);
        }
    }


    private String getConfigValue(String key) {
        if (configValues.containsKey(key)) {
            return configValues.get(key);
        } else {
            throw new IllegalArgumentException("The test config does not contain value for key '" + key + "'");
        }
    }

    public String getPncRestAddress() {
        return getConfigValue("pncRestAddress");
    }

    public String getKeycloakAddress() {
        return getConfigValue("keycloakAddress");
    }

    public String getPncUser() {
        return getConfigValue("pncUser");
    }

    public String getPncPassword() {
        return getConfigValue("pncPassword");
    }

    public Boolean isRunnable(final Class<?> testClass) {
        return runnableTests.get(testClass);
    }

}
