package client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

public class RestClient {
	//1.Get mathord without header
			/*public CloseableHttpResponse  get(String url) throws ClientProtocolException, IOException {
				CloseableHttpClient httpClient=	HttpClients.createDefault();
				//createDefault() will do create one client connection
			HttpGet httpGet=new HttpGet(url); //http get request
			// HttpGet(): create one get connectio in this particuler url
			CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpGet); //hit the get url
			return closeableHttpResponse;
			}
			*/
			//a.Status code: 
			/*int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
			System.out.println("Status code--->"+statusCode);
			//b.Json String:
			String responseString= EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
			JSONObject responseJson=new JSONObject(responseString);
			System.out.println("response JSON from API-->"+responseJson);
		    //c.All Headers
			Header[] headersArray=closeableHttpResponse.getAllHeaders();
			HashMap<String,String> allHeaders=new HashMap<String,String>();
			for(Header header :headersArray) {
				allHeaders.put(header.getName(),header.getValue());
			}
			System.out.println("Headers Array--->"+allHeaders);
			}
		
			
			//2.Get mathord with header
					public CloseableHttpResponse  get(String url,HashMap<String,String>headerMap) throws ClientProtocolException, IOException {
						CloseableHttpClient httpClient=	HttpClients.createDefault();
						//createDefault() will do create one client connection
					HttpGet httpGet=new HttpGet(url); //http get request
					// HttpGet(): create one get connectio in this particuler url
					for(Map.Entry<String,String>entry:headerMap.entrySet()) {
						httpGet.addHeader(entry.getKey(),entry.getValue());
					}
					CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpGet); //hit the get url
					return closeableHttpResponse;
			}
				*/
			//3.POST Methord
					public CloseableHttpResponse post(String url,String entityString, HashMap<String,String> headerMap) throws ClientProtocolException, IOException {
						CloseableHttpClient httpClient=HttpClients.createDefault();
						HttpPost httppost=new HttpPost(url);
						httppost.setEntity(new StringEntity(entityString));
					
					//for headers:
						for(Map.Entry<String,String> entity :headerMap.entrySet()) {
							httppost.addHeader(entity.getKey(),entity.getValue());	
							
						}
						CloseableHttpResponse closeableHttpResponse=httpClient.execute(httppost); //hit the get url
						return closeableHttpResponse;
						
					}
					
	}
