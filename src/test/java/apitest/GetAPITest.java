package apitest;

public class GetAPITest {

	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	RestClient restClient;
	String url;
	CloseableHttpResponse  closeableHttpResponse;
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		testBase=new TestBase();
		serviceUrl=prop.getProperty("URL");
	     apiUrl=prop.getProperty("serviceURL");
	     url=serviceUrl+apiUrl;
	}
	 	@Test(priority=1)
		public void getAPITestWithHeaders() throws ClientProtocolException, IOException { 
        RestClient restClient=new RestClient();
        
        HashMap<String,String>headerMap=new HashMap<String,String>();
       
        closeableHttpResponse = restClient.get(url);
        
        int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code--->"+statusCode);
		Assert.assertEquals(statusCode,RESPONSE_STATUS_CODE_200=200 ,"Status code is 200");
		//b.Json String:
		String responseString= EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONObject responseJson=new JSONObject(responseString);
		System.out.println("response JSON from API-->"+responseJson);
	   String perPageValue= TestUtil.getValueByJPath(responseJson,"/per_page");
	   System.out.println("value of per page is-->"+perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue),6);
		  String totleValue= TestUtil.getValueByJPath(responseJson,"/total");
        System.out.println("value of totle is-->"+totleValue);
			Assert.assertEquals(Integer.parseInt(totleValue), 12);
		//get the value from json
			 String first_name = TestUtil.getValueByJPath(responseJson,"/data[0]/first_name");
			 System.out.println(first_name);
			 String last_name = TestUtil.getValueByJPath(responseJson,"/data[0]/last_name");
			 System.out.println(last_name);
			 String id = TestUtil.getValueByJPath(responseJson,"/data[0]/id");
			 System.out.println(id);
			 String email = TestUtil.getValueByJPath(responseJson,"/data[0]/email");
			 System.out.println(email);
			 String avatar = TestUtil.getValueByJPath(responseJson,"/data[0]/avatar");
			 System.out.println( avatar);
	   //c.All Headers
		Header[] headersArray=closeableHttpResponse.getAllHeaders();
		HashMap<String,String> allHeaders=new HashMap<String,String>();
		for(Header header :headersArray) {
			allHeaders.put(header.getName(),header.getValue());
		}
		System.out.println("Headers Array--->"+allHeaders);
	}
	 	@Test(priority=2)
	 	public void getAPITestWithoutHeaders() throws ClientProtocolException, IOException { 
	        RestClient restClient=new RestClient();
	        
	        HashMap<String,String>headerMap=new HashMap<String,String>();
	        headerMap.put("Content-Type","application/json");
	        headerMap.put("username","sahadat146@gmail.com");
	        headerMap.put("password","575627Sm");
	        headerMap.put("Auth Token","12345");
	        closeableHttpResponse = restClient.get(url);
	        
	        int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
			System.out.println("Status code--->"+statusCode);
			Assert.assertEquals(statusCode,RESPONSE_STATUS_CODE_200=200 ,"Status code is 200");
			//b.Json String:
			String responseString= EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
			JSONObject responseJson=new JSONObject(responseString);
			System.out.println("response JSON from API-->"+responseJson);
		   String perPageValue= TestUtil.getValueByJPath(responseJson,"/per_page");
		   System.out.println("value of per page is-->"+perPageValue);
			Assert.assertEquals(Integer.parseInt(perPageValue),6);
			  String totleValue= TestUtil.getValueByJPath(responseJson,"/total");
	        System.out.println("value of totle is-->"+totleValue);
				Assert.assertEquals(Integer.parseInt(totleValue), 12);
			//get the value from json
				 String first_name = TestUtil.getValueByJPath(responseJson,"/data[0]/first_name");
				 System.out.println(first_name);
				 String last_name = TestUtil.getValueByJPath(responseJson,"/data[0]/last_name");
				 System.out.println(last_name);
				 String id = TestUtil.getValueByJPath(responseJson,"/data[0]/id");
				 System.out.println(id);
				 String email = TestUtil.getValueByJPath(responseJson,"/data[0]/email");
				 System.out.println(email);
				 String avatar = TestUtil.getValueByJPath(responseJson,"/data[0]/avatar");
				 System.out.println( avatar);
		   //c.All Headers
			Header[] headersArray=closeableHttpResponse.getAllHeaders();
			HashMap<String,String> allHeaders=new HashMap<String,String>();
			for(Header header :headersArray) {
				allHeaders.put(header.getName(),header.getValue());
			}
			System.out.println("Headers Array--->"+allHeaders);
		}
}
