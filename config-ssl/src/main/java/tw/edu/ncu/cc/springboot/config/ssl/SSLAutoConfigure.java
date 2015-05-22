package tw.edu.ncu.cc.springboot.config.ssl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

@Configuration
public class SSLAutoConfigure {

    private Logger logger = LoggerFactory.getLogger( SSLAutoConfigure.class );

    @Bean
    @ConditionalOnProperty( prefix = "ssl.verification", name = "enabled", havingValue = "false" )
    public SSLConfig sslConfig() {
        logger.info( "auto configure net ssl" );
        logger.debug( "ssl.verification.enabled: false" );
        disableSSLVerification();
        return new SSLConfig( false );
    }

    private void disableSSLVerification() {
        try {
            SSLContext sc = SSLContext.getInstance( "TLS" );
            sc.init( null, new TrustManager[]{ new TrustAllX509TrustManager() }, new SecureRandom() );
            HttpsURLConnection.setDefaultSSLSocketFactory( sc.getSocketFactory() );
            HttpsURLConnection.setDefaultHostnameVerifier( new HostnameVerifier() {
                public boolean verify( String string, SSLSession sslSession ) {
                    return true;
                }
            } );
        } catch ( KeyManagementException | NoSuchAlgorithmException e ) {
            throw new RuntimeException( "disable ssl verification failed", e );
        }
    }

    private class TrustAllX509TrustManager implements X509TrustManager {

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[ 0 ];
        }

        public void checkClientTrusted( X509Certificate[] certs, String authType ) { }

        public void checkServerTrusted( X509Certificate[] certs, String authType ) { }

    }

}
