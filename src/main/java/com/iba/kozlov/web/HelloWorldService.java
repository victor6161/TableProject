package com.iba.kozlov.web;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//@ApplicationPath("/api")/* extends HttpServlet*/
@Path("demo")
public class HelloWorldService {

	// @Path("/test")
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMsg() {

		

		return "Jersey say : ";

	}

	/*
	 * public void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * response.setContentType("application/json");
	 * 
	 * 
	 * 
	 * PrintWriter out = response.getWriter(); out.println("velosiped"); }
	 */

}
