package com.freddiemac.dropbox.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;

//@Profile("vault")
@Configuration
public class ExternalPropertyConfig {

    @Value("${vault-secrets-file-path}")
    private String configPath;

    @Value("${vault-secrets-files}")
    ArrayList<String> fileNames;

    ArrayList<Path> configPaths;
    Properties allProperties = new Properties();

    @Bean
    public Properties externalProperties() {
        // ConfigurableEnvironment environment = new StandardEnvironment();
        // MutablePropertySources propertySources = environment.getPropertySources();
        // Map<String, Object> myMap = new HashMap<>();

        if (this.fileNames != null && configPath != null) {
            for (int i = 0; i < this.fileNames.size(); i++) {
                try {
                    String fileName = this.fileNames.get(i);
                    Path fullPath = Paths.get(this.configPath, fileName);
    
                    Properties prop = new Properties();

                    InputStream input = new FileInputStream(fullPath.toString());

                    prop.load(input);

                    for (Enumeration e = prop.propertyNames(); e.hasMoreElements();) {
                        String key = (String) e.nextElement();
                        String newKey = fileName + "." + key;
                        String value = prop.getProperty(key);
                        this.allProperties.put(newKey, value);
                        // myMap.put(newKey, value); }
                    }
                }

                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } 
        else {
            System.out.println(" 'vault-secrets-file-path' and vault-secrets-files must have a value in the application.propeties file.");

        }

        // propertySources.addFirst(new MapPropertySource("MYMAP", myMap));

        return this.allProperties;
    }

    public Properties getVaultProperties() {
        return this.allProperties;
    }

    @EventListener
    public void handleContextStart(ApplicationContextEvent cse) {
        System.out.println("Handling context event. " + cse.toString());
    }

}