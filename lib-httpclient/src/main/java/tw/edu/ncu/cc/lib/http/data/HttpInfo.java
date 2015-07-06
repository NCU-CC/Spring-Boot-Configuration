package tw.edu.ncu.cc.lib.http.data;

import java.util.HashMap;
import java.util.Map;

public class HttpInfo {

    private String url;
    private String content;
    private String[] variables;
    private Map< String, String > parameters;
    private Map< String, String > headers;

    public HttpInfo() {
        headers = new HashMap<>();
        parameters = new HashMap<>();
    }

    public void addParameter( String key, String value ) {
        parameters.put( key, value );
    }

    public void addHeader( String key, String value ) {
        headers.put( key, value );
    }

    public String getUrl() {
        return url;
    }

    public void setUrl( String url ) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent( String content ) {
        this.content = content;
    }

    public String[] getVariables() {
        return variables;
    }

    public void setVariables( String[] variables ) {
        this.variables = variables;
    }

    public Map< String, String > getParameters() {
        return parameters;
    }

    public void setParameters( Map< String, String > parameters ) {
        this.parameters = parameters;
    }

    public Map< String, String > getHeaders() {
        return headers;
    }

    public void setHeaders( Map< String, String > headers ) {
        this.headers = headers;
    }

}
