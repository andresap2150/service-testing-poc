package service.testing.helpers;

import org.json.simple.JSONObject;

public class UsersHelper {
	public String generate_new_user(String firstname, String lastname, int subject) {
		JSONObject request = new JSONObject();
		request.put("firstName", firstname);
		request.put("lastName", lastname);
		request.put("subjectID", subject);
		return request.toJSONString();
	}

}
