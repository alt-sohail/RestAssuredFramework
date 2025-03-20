package api.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDStoreTests {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String OrderID, String petID, String quantity, String sDate, String status, String complete) throws Exception {

		Store storePayload = new Store();
		Date dt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(sDate);
		
		storePayload.setId(Integer.parseInt(OrderID));
		storePayload.setPetId(Integer.parseInt(petID));
		storePayload.setQuantity(Integer.parseInt(quantity));
		storePayload.setShipDate(dt);
		storePayload.setStatus(status);
		storePayload.setComplete(Boolean.parseBoolean(complete));
		
		Response response = StoreEndPoints.createOrder(storePayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "DeleteData", dataProviderClass = DataProviders.class)
	public void testDeleteOrderByOrderId(String orderID) {
		
		Response response = StoreEndPoints.deleteOrder(Integer.parseInt(orderID));
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
