package tw.edu.ncu.cc.springboot.config.hikaricp;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;


@ConfigurationProperties( "spring.datasource" )
public class HikariCPConfig {

    private String url;
    private String username;
    private String password;
    private Properties hikariProperties;

    public String getUrl() {
        return url;
    }

    public void setUrl( String url ) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public Properties getHikariProperties() {
        return hikariProperties;
    }

    public void setHikariProperties( Properties hikariProperties ) {
        this.hikariProperties = hikariProperties;
    }

}
