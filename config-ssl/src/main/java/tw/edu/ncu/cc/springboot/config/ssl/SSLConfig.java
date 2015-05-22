package tw.edu.ncu.cc.springboot.config.ssl;

public class SSLConfig {

    private Boolean verificationEnabled;

    public SSLConfig( Boolean verificationEnabled ) {
        this.verificationEnabled = verificationEnabled;
    }

    public Boolean getVerificationEnabled() {
        return verificationEnabled;
    }

    public void setVerificationEnabled( Boolean verificationEnabled ) {
        this.verificationEnabled = verificationEnabled;
    }

}
