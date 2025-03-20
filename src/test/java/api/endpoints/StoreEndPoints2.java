package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.util.Properties;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints2 {

	public static Properties prop;
	public static FileInputStream fis;
	
	public static Response createOrder(Store payload) throws Exception {

		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\routes.properties");
		prop.load(fis);
		
		Response response = given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)

				.when()
					.post(prop.getProperty("post_storeUrl"));

		return response;
	}

	public static Response readOrder(int orderid) {

		Response response = given()
					.pathParam("orderId", orderid)

				.when()
					.get(prop.getProperty("get_storeUrl"));

		return response;
	}
	
	public static Response deleteOrder(int orderid) {
		
		Response response = given()
					.pathParam("orderId", orderid)
			
				.when()
					.delete(prop.getProperty("delete_storeUrl"));
		
		return response;
	}
}
