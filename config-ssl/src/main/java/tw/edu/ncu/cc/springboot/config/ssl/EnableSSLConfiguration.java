package tw.edu.ncu.cc.springboot.config.ssl;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Documented
@Inherited
@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )
@Import( SSLConfiguration.class )
public @interface EnableSSLConfiguration {

}


