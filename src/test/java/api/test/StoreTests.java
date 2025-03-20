package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {

	Faker faker;
	Store storePayload;
	public Logger logger;

	@BeforeClass
	public void setUp() {

		faker = new Faker();
		storePayload = new Store();

		storePayload.setId(faker.number().numberBetween(1, 10));
		storePayload.setPetId(faker.number().numberBetween(1, 10));
		storePayload.setQuantity(faker.number().numberBetween(1, 5));
		
//		logs
		logger = LogManager.getLogger(this.getClass());
	}

	@Test(priority = 1, enabled = true)
	public void testPostOrder() throws Exception {
		logger.info("********** Creating Order **********");
		
		Response response = StoreEndPoints.createOrder(storePayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********** Order Created**********");
	}

	@Test(priority = 2, enabled = true)
	public void testGetOrderById() {
		logger.info("********** Fetching Order **********");
		
		Response response = StoreEndPoints.readOrder(this.storePayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********** Order Fetched **********");
	}
	
	@Test(priority = 3, enabled = true)
	public void testDeleteOrderById() {
		logger.info("********** Deleting Order **********");
		
		Response response = StoreEndPoints.deleteOrder(this.storePayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********** Order Deleted **********");
	}

}
