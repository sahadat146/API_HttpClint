package apitest;

public class PostAPITest {

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
	@Test
	public void PostAPITest() throws JsonGenerationException, JsonMappingException, IOException {
		HashMap<String,String> headerMap=new HashMap<String,String>();
		headerMap.put("Content-Type","application/json");
		
		//jackson API:
		ObjectMapper mapper=new ObjectMapper();
	Users users=new Users("morpheus","leader");
	
	//object to json file
	mapper.writeValue(new File("C:\\Users\\blr-frontdesk-ptt\\java\\New folder\\bddsd\\RestApiProgram\\src\\main\\java\\com\\data\\users.json"), users);
	
	//object to json in String
	String usersJsonString=mapper.writeValueAsString(users);
	System.out.println(usersJsonString);
	closeableHttpResponse = restClient.post(url,usersJsonString,headerMap);

	//Status Code
	int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
	Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_201);
	//2. jsonString:
	String responseString=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
	JSONObject responseJson=new JSONObject(responseString);
	System.out.println("the response from API is:"+responseJson);
	}

}
