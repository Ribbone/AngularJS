import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

	private static final String CONFIGURATIONFILELOCATION = System.getProperty("user.home") + "/exalted-configuration/exalted.conf";
	private static final String DATAFILEPATHLABEL = "data.file.path=";
	private static String datafilepath = "";
	private static ExaltedRESTServiceImplementation impl = null;

	@GET
	@Produces("application/json")
	@Path("/getchar")
	public ExaltedCharacterResponse getCharacterJSON(@QueryParam("name") String name){
		return new ExaltedCharacterResponse(impl.getCharacter(name));
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

	// Main method that publishes this class as a web service at the given URL
	private static String SERVICEURL = "http://localhost:8081/WebServices";

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		System.out.println("Reading configuration file from " + new File(CONFIGURATIONFILELOCATION).getAbsolutePath());
		readConfigurationFile();
		impl = new ExaltedRESTServiceImplementation(datafilepath);
		HttpServerFactory.create(SERVICEURL).start();
		System.out.println("Listening for requests at address " + SERVICEURL);
		System.out.println("Saving character information to path: " + new File(datafilepath).getAbsolutePath());
		System.out.println("Test with for example:");
		System.out.println(SERVICEURL + "/exalted/getchar?name=NAMEBEHERE");
		System.out.println(SERVICEURL + "/exalted/postchardummy?name=NAMEBEHERE");
		System.out.println(SERVICEURL + "/exalted/postchar");
	}

	private static void readConfigurationFile() {
		try {
		File f = new File(CONFIGURATIONFILELOCATION);
		BufferedReader br;
			br = new BufferedReader(new FileReader(f));
		String line;
		while ((line = br.readLine()) != null) {
		   if(line.contains(DATAFILEPATHLABEL)){
			   datafilepath=line.split("=")[1];
		   }
		}
		br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
	}
}