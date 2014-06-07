package fi.turtiainen.exalted;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/")
public class ExaltedRESTService {

	private static ExaltedRESTServiceImplementation impl = new ExaltedRESTServiceImplementation();

	@GET
	@Produces("application/json")
	@Path("/getchar")
	public ExaltedCharacterResponse getCharacterJSON(@QueryParam("name") String name) {
		return new ExaltedCharacterResponse(impl.getCharacter(name));
	}

	@GET
	@Produces("application/json")
	@Path("/getcharlist")
	public ExaltedCharacterListResponse getCharacterListJSON() {

		ExaltedCharacterListResponse response = new ExaltedCharacterListResponse(impl.getCharacterList());

		return response;
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/postchar")
	public ExaltedCharacterResponse getRateJSONPOST(ExaltedCharacterRequest characterPost) {
		return new ExaltedCharacterResponse(impl.postCharacter(characterPost));
	}

	@GET
	@Produces("application/json")
	@Path("/postchardummy")
	public ExaltedCharacterResponse getRateJSONPOSTDummy(@QueryParam("name") String name) {
		return new ExaltedCharacterResponse(impl.postCharacterDummy(name));
	}
}