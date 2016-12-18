package com.netcracker.entities;

import java.util.Objects;

/**
 * Entity represent's CONFIGURATION table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.ConfigurationRepositoryImpl
 */
public class Configuration {
    private String configKey;
    private String configValue;

    public Configuration() {
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(configKey, configValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Configuration)) {
            return false;
        }
        Configuration configuration = (Configuration) o;
        return Objects.equals(configKey, configuration.configKey) && Objects.equals(configValue, configuration.configValue);
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "configKey=" + configKey +
                ", configValue='" + configValue + '\'' +
                '}';
    }
}
