package recipes.security.authentication.facade;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
	Authentication getAuthentication();

	String getAuthenticationName();

	void throwIfUserIsNotAuthorised(String username);
}