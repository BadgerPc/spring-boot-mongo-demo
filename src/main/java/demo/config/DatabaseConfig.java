package demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by msanaulla on 12/22/2014.
 */
@Component
//@ConfigurationProperties(prefix = "database")
public class DatabaseConfig {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
