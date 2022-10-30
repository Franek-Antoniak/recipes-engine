package recipes.user.exception;

import org.springframework.security.core.AuthenticationException;

public class UserAuthorizationException extends AuthenticationException {
	public UserAuthorizationException(String message) {
		super(message);
	}
}
