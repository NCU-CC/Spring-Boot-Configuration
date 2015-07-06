package tw.edu.ncu.cc.lib.http.client

import org.junit.ClassRule
import org.mockserver.model.Header
import org.mockserver.model.HttpRequest
import org.mockserver.model.HttpResponse
import resource.ServerResource
import spock.lang.Shared
import spock.lang.Specification
import tw.edu.ncu.cc.lib.http.data.HttpInfo


class HttpClientSpringTest extends Specification {

    @Shared @ClassRule
    ServerResource serverResource = new ServerResource( 8898 )

    def setupSpec() {
        serverResource.mockServer().when(
                HttpRequest.request()
                        .withMethod( "GET" )
                        .withPath( "/person/1" )
        ).respond(
                HttpResponse.response()
                        .withStatusCode( 200 )
                        .withHeaders( new Header( "Content-Type", "application/json" ) )
                        .withBody(
                        '''
                        {
                            "url" : "123"
                        }
                        '''
                )
        )
    }

    def "it can get data from remote service"() {
        when:
            def person = HttpClientSpring
                    .connect( "http://localhost:8898/person/{id}" )
                    .variables( "1" )
                    .get( HttpInfo )
        then:
            person.url == "123"
    }

}
