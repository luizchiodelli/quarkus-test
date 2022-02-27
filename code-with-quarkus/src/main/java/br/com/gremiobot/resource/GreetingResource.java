package br.com.gremiobot.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.gremiobot.controller.GremioBotController;
import twitter4j.TwitterException;

@Path("/hello")
public class GreetingResource {
	
	@Inject
	GremioBotController gremioBotController;

    @GET
    @Path("/helloworld")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return gremioBotController.helloWorld();
    }
    
    @POST
    @Path("/hellotwitter")
    public void helloTwitter() throws TwitterException {
    	gremioBotController.helloWorldTwitter();
    }
}