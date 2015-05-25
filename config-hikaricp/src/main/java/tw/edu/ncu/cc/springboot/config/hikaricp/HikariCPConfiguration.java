package tw.edu.ncu.cc.springboot.config.hikaricp;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;


@Profile( "production" )
@Configuration
@EnableConfigurationProperties( HikariCPConfig.class )
public class HikariCPConfiguration {

    private Logger logger = LoggerFactory.getLogger( HikariCPConfiguration.class );

    @Autowired
    public HikariCPConfig hikariCPConfig;

    @Value( "${spring.datasource.url}" )
    public String url;

    @Value( "${spring.datasource.username}" )
    public String username;

    @Value( "${spring.datasource.password}" )
    public String password;

    @Value( "${spring.datasource.driver-class-name}" )
    public String driverClassName;

    @Bean
    public DataSource hikariDataSource() {

        logger.info( "configure hikariCP config" );

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName( driverClassName );
        dataSource.setDataSourceProperties( hikariCPConfig.getHikariDatasource() );
        dataSource.setUsername( username );
        dataSource.setPassword( password );
        dataSource.setJdbcUrl( url );

        return dataSource;
    }

}
