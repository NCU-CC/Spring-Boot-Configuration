package tw.edu.ncu.cc.springboot.config.hikaricp;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
@EnableConfigurationProperties( HikariCPConfig.class )
public class HikariCPConfiguration {

    private Logger logger = LoggerFactory.getLogger( HikariCPConfiguration.class );

    @Autowired
    public HikariCPConfig hikariCPConfig;

    @Bean
    public DataSource hikariDataSource() {

        logger.info( "configure hikariCP config" );

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDataSourceProperties( hikariCPConfig.getHikariProperties() );
        dataSource.setUsername( hikariCPConfig.getUsername() );
        dataSource.setPassword( hikariCPConfig.getPassword() );
        dataSource.setJdbcUrl( hikariCPConfig.getUrl() );

        return dataSource;
    }

}
