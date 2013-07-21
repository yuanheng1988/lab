package cn.iscas.nfs.platform.coreservice.storage.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorld {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/1")
	public String sayHello() {
		return "hello jersey5555";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{name}")
	public String sayHello2(@PathParam("name") String name) {
		return "hello jersey" + name;
	}
}