package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	public Logger logger;

	@BeforeClass
	public void setUp() {

		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
//		logs
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1, enabled = false)
	public void testPostUser() {
		logger.info("********** Creating User **********");
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********** User is Created **********");
	}
	
	@Test(priority = 2, enabled = false)
	public void testGetUserByName() {
		logger.info("********** Reading User Info **********");
		
		Response response = UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********** User Info is Displayed **********");
	}
	
	@Test(priority = 3, enabled = false)
	public void testUpdateUserByName() {
		logger.info("********** Updating User **********");
		
//		update data using payload 
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200); // Both assertion
		response.then().log().body().statusCode(200);       // are same
		
		logger.info("********** User is Updated **********");
		
//		Checking date after update
		Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}
	
	@Test(priority = 4, enabled = false)
	public void testDeleteUserByName() {
		logger.info("********** Deleting User **********");
		
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********** User Deleted **********");
	}
}
