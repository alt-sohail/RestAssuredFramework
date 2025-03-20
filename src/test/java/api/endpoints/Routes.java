package api.endpoints;

/*
 * Swagger URI --> https://petstore.swagger.io/
 *
 * Create user (post) --> https://petstore.swagger.io/v2/user
 * Get user (get) --> https://petstore.swagger.io/v2/user/{username}
 * Update user (put) --> https://petstore.swagger.io/v2/user/{username}
 * Delete user (delete) --> https://petstore.swagger.io/v2/user/{username}
 */

/*
 * Swagger URI --> https://petstore.swagger.io/v2
 *
 * Create order (post) --> https://petstore.swagger.io/v2/store/order
 * Get order (get) --> https://petstore.swagger.io/v2/store/order/{orderId}
 * Delete order (delete) --> https://petstore.swagger.io/v2/store/order/{orderId}
 */

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";
	
//	User module
	
	public static String post_userUrl = base_url + "/user";
	public static String get_userUrl = base_url + "/user/{username}";
	public static String update_userUrl = base_url + "/user/{username}";
	public static String delete_userUrl = base_url + "/user/{username}";
	
	
	/*
	 * Store module ---> Here you will create store module url's
	 */
	
	public static String post_storeUrl = base_url + "/store/order";
	public static String get_storeUrl = base_url + "/store/order/{orderId}";
	public static String delete_storeUrl = base_url + "/store/order/{orderId}";

	/*
	 * Pet module ---> Here you will create pet module url's
	 */
	
}
