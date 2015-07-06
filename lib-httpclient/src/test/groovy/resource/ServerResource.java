package resource;

import org.junit.rules.ExternalResource;
import org.mockserver.integration.ClientAndServer;

public class ServerResource extends ExternalResource {

    private int httpPort;
    private ClientAndServer mockServer;

    public ServerResource( int httpPort ) {
        this.httpPort = httpPort;
    }

    @Override
    protected void before() throws Throwable {
        mockServer = ClientAndServer.startClientAndServer( httpPort );
    }

    @Override
    protected void after() {
        mockServer.stop();
    }

    public ClientAndServer mockServer() {
        return mockServer;
    }

}
