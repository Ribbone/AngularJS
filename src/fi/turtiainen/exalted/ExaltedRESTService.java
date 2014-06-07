package fi.turtiainen.exalted;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/")
public class ExaltedRESTService {

	private static ExaltedRESTServiceImplementation impl = new ExaltedRESTServiceImplementation();

	@GET
	@Produces("application/json")
	@Path("/character")
	public ExaltedCharacterDto getCharacterJSON(@QueryParam("name") String name) {
		return new ExaltedCharacterDto(impl.getCharacter(name));
	}
	
	@DELETE
	@Path("/character")
	public Response deleteCharacterJSON(@QueryParam("name") String name) {
		impl.deleteCharacter(name);
		return Response.noContent().build();
	}

	@GET
	@Produces("application/json")
	@Path("/characterlist")
	public ExaltedCharacterListResponse getCharacterListJSON() {
		return new ExaltedCharacterListResponse(impl.getCharacterList());
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/character")
	public ExaltedCharacterDto getRateJSONPOST(ExaltedCharacterDto character) {
		return new ExaltedCharacterDto(impl.postCharacter(character));
	}
}