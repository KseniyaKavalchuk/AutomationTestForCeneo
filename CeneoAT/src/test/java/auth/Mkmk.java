package auth;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.Cookie;

public class Mkmk {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		
		HttpGet get = new HttpGet("http://codingbat.com/");
		
		
		AuthHelper helper = new AuthHelper();
		Cookie cookie = helper.codingbatGetAuthCookie();
		
		get.setHeader("Cookie", cookie.toString());
		
		HttpResponse response = client.execute(get);
		
		HttpEntity entity = response.getEntity();
		String entityContents = EntityUtils.toString(entity);
		
		System.out.println(entityContents);

	}

}
