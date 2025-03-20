package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {

	public static Response createOrder(Store payload) {

		Response response = given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)

				.when()
					.post(Routes.post_storeUrl);

		return response;
	}

	public static Response readOrder(int orderid) {

		Response response = given()
					.pathParam("orderId", orderid)

				.when()
					.get(Routes.get_storeUrl);

		return response;
	}
	
	public static Response deleteOrder(int orderid) {
		
		Response response = given()
					.pathParam("orderId", orderid)
			
				.when()
					.delete(Routes.delete_storeUrl);
		
		return response;
	}
}
