package recipes.security;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
	Authentication getAuthentication();

	void throwIfUserIsNotAuthorised(String username);
}