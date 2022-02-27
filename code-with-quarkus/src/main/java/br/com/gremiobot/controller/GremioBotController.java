package br.com.gremiobot.controller;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@ApplicationScoped
public class GremioBotController {
	
	@ConfigProperty(name = "twitter.api.key")
	String apiKey;
	
	@ConfigProperty(name = "twitter.api.secret")
	String apiSecret;
	
	@ConfigProperty(name = "twitter.api.token")
	String apiToken;

	public String helloWorld() {
		return "Hello World!";
	}

	public void helloWorldTwitter() throws TwitterException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(apiKey).setOAuthConsumerSecret(apiSecret)
				.setOAuthAccessToken(apiToken).setOAuthAccessTokenSecret(apiSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		Status tweet = twitter.updateStatus("Olá Grêmio");
		System.out.println(tweet.getText());
	}
}
