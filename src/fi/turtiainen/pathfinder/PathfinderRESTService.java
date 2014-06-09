package fi.turtiainen.pathfinder;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/pathfinder")
public class PathfinderRESTService {

	private static PathfinderRESTServiceImplementation impl = new PathfinderRESTServiceImplementation();

	@GET
	@Produces("application/json")
	@Path("/character")
	public PathfinderCharacter getCharacterJSON(@QueryParam("name") String name) {
		return impl.getCharacter(name);
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
	public PathfinderCharacterListResponse getCharacterListJSON() {
		return new PathfinderCharacterListResponse(impl.getCharacterList());
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/character")
	public PathfinderCharacter getRateJSONPOST(PathfinderCharacter character) {
		return impl.postCharacter(character);
	}
}