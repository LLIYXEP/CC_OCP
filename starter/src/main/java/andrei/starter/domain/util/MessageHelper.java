package andrei.starter.domain.util;

import andrei.starter.domain.User;

public abstract class MessageHelper {

	public static String getAuthorName(User author) {
		return author != null ? author.getUsername() : "nobody";
	}
	
}
