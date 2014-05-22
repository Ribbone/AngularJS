import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;

@Path("/exalted")
public class ExaltedRESTService {

	@GET
	@Produces("application/json")
	@Path("/getchar")
	public ExaltedCharacterResponse getCharacterJSON(@QueryParam("name") String name){
		return new ExaltedCharacterResponse(ExaltedRESTServiceImplementation.getCharacter(name));
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/postchar")
	public ExaltedCharacterResponse getRateJSONPOST(ExaltedCharacterRequest characterPost) {
		return new ExaltedCharacterResponse(ExaltedRESTServiceImplementation.postCharacter(characterPost));
	}
	
	@GET
	@Produces("application/json")
	@Path("/postchardummy")
	public ExaltedCharacterResponse getRateJSONPOSTDummy(@QueryParam("name") String name) {
		return new ExaltedCharacterResponse(ExaltedRESTServiceImplementation.postCharacterDummy(name));
	}

	// Main method that publishes this class as a web service at the given URL
	private static String SERVICEURL = "http://localhost:8081/WebServices";

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		HttpServerFactory.create(SERVICEURL).start();
		System.out.println("Listening for requests at address " + SERVICEURL);
		System.out.println("Test with for example:");
		System.out.println(SERVICEURL + "/exalted/getchar?name=NAMEBEHERE");
		System.out.println(SERVICEURL + "/exalted/postchardummy?name=NAMEBEHERE");
		System.out.println(SERVICEURL + "/exalted/postchar");
	}
}