package tw.edu.ncu.cc.springboot.config.hikaricp;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Inherited
@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )
@Import( HikariCPConfiguration.class )
public @interface EnableHikariConfiguration {

}
