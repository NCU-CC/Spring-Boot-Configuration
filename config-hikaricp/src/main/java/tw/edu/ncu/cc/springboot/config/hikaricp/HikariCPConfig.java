package tw.edu.ncu.cc.springboot.config.hikaricp;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Properties;


@ConfigurationProperties( "spring" )
public class HikariCPConfig {

    private Properties hikariDatasource;

    public Properties getHikariDatasource() {
        return hikariDatasource;
    }

    public void setHikariDatasource( Properties hikariDatasource ) {
        this.hikariDatasource = hikariDatasource;
    }

}
