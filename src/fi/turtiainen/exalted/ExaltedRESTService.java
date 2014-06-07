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
	public ExaltedCharacterDto getCharacterJSON(@QueryParam("name") String name) {
		return new ExaltedCharacterDto(impl.getCharacter(name));
	}

	@GET
	@Produces("application/json")
	@Path("/getcharlist")
	public ExaltedCharacterListResponse getCharacterListJSON() {
		return new ExaltedCharacterListResponse(impl.getCharacterList());
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/postchar")
	public ExaltedCharacterDto getRateJSONPOST(ExaltedCharacterDto character) {
		return new ExaltedCharacterDto(impl.postCharacter(character));
	}

	@GET
	@Produces("application/json")
	@Path("/postchardummy")
	public ExaltedCharacterDto getRateJSONPOSTDummy(@QueryParam("name") String name) {
		return new ExaltedCharacterDto(impl.postCharacterDummy(name));
	}
}