package constants;

public class Constant {
	public static final String ConfigFile = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";

	public static final String TestDataFile = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";

	public static final String ValidCredentialError = "User was unable to login with valid credentials";

	public static final String InValidCredentialError = "User was able to login with invalid credentials";

	public static final String InValidUsernameError = "User was able to login with invalid Username";

	public static final String InValidPasswordError = "User was able to login with invalid Password";

	public static final String LogOutError = "User was unable to logout";

	public static final String UserNotAddedError = "Error in adding User";

	public static final String UnabletoSearchError = "Error in Searching User";

	public static final String UnAbletoResetError = "Error in resetting page";

	public static final String UnabletoAddNewsError = "Error in Adding News";

	public static final String UnabletoSearchNewsError = "Error in Searching News";

}
