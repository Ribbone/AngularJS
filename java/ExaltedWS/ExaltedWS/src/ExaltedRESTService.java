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
	@Path("/getchar/json")
	public ExaltedCharacterResponse getCharacterJSON(@QueryParam("char") String name){
		return new ExaltedCharacterResponse(ExaltedRESTServiceImplementation.getCharacter(name));
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/getchar/jsonpost")
	public ExaltedCharacterResponse getRateJSONPOST(ExaltedCharacterRequest characterPost) {
		return new ExaltedCharacterResponse(ExaltedRESTServiceImplementation.postCharacter(characterPost));
	}

	// Main method that publishes this class as a web service at the given URL
	private static String SERVICEURL = "http://localhost:8081/WebServices";

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		HttpServerFactory.create(SERVICEURL).start();
		System.out.println("Listening for requests at address " + SERVICEURL);
		System.out.println("WADL can be found at " + SERVICEURL + "/application.wadl");
		System.out.println("Test with for example:");
		System.out.println(SERVICEURL + "/exalted/getchar/json?name=USD");
	}
}
