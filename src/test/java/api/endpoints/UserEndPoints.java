package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/*
 * Created to perform Create, Read. Update, Delete (CRUD) requests for the user API
 */

public class UserEndPoints {

	public static Response createUser(User payload) {
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			
		.when()
			.post(Routes.post_userUrl);
		
		return response;
	}
	
	public static Response readUser(String userName) {
		
		Response response = given()
			.pathParam("username", userName)
			
		.when()
			.get(Routes.get_userUrl);
		
		return response;
	}
	
	public static Response updateUser(String userName, User payload) {
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
			
		.when()
			.put(Routes.update_userUrl);
		
		return response;
	}
	
	public static Response deleteUser(String userName) {
		
		Response response = given()
			.pathParam("username", userName)
			
		.when()
			.delete(Routes.delete_userUrl);
		
		return response;
	}
}
