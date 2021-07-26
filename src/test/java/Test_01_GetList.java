import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test_01_GetList {
	
	@Test
	void GetUserList() {
		
	Response GetRes =	get("https://reqres.in/api/users?page=2");
	
	System.out.println(GetRes.getStatusCode());
	System.out.println(GetRes.getBody().asString());
	System.out.println(GetRes.getHeader("content-type"));
	System.out.println(GetRes.getStatusLine());
	int stacode = GetRes.getStatusCode();
	Assert.assertEquals(stacode, 200);
	
		
	}
	
	@Test
	void GetUserList2() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(7));
		
		
	}
	
	

}
