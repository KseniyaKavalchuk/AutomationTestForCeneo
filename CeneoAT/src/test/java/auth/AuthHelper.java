package auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.Cookie;




public class AuthHelper {	

	
	public Cookie codingbatGetAuthCookie() throws ClientProtocolException, IOException {
		
		Cookie result = null;

		
		HttpClient client = HttpClientBuilder.create().build();
		
		HttpPost postRequest = new HttpPost("http://codingbat.com/login");

		postRequest.setHeader("Host", "codingbat.com");
		postRequest.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.6.2526.80 Safari/537.36");
		postRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");
		postRequest.setHeader("Referer", "http://codingbat.com/");
			
		List <NameValuePair> bodyParams = new ArrayList <NameValuePair>();
		bodyParams.add(new BasicNameValuePair("uname", "ksuha0706@mail.ru"));
		bodyParams.add(new BasicNameValuePair("pw", "testtest1"));
		bodyParams.add(new BasicNameValuePair("dologin", "log in"));
		bodyParams.add(new BasicNameValuePair("fromurl", "/"));

		 
		postRequest.setEntity(new UrlEncodedFormEntity(bodyParams));
		
		HttpResponse response = client.execute(postRequest);
		

		for(Header header: response.getAllHeaders()){
			System.out.println(header);
			if(header.getName().equals("Set-Cookie")){
				String stringCookie = header.getValue();
				String[] sp1 = stringCookie.split(";");
				
				String[] sp2 = sp1[0].split("=");
				String[] sp3 = sp1[1].split("=");
				
				result = new Cookie(sp2[0], sp2[1], sp3[1]);
			}
		}
		return result;
	}
	
 
}
