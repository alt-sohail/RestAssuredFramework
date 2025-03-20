package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDUserTests {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userID, String userName, String fName, String lName, String email, String pwd,
			String phone) {

		User userPayload = new User();

		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstname(lName);
		userPayload.setLastname(lName);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "DeleteData", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) {
		
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
