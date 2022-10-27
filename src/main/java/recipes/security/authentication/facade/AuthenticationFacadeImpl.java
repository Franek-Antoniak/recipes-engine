package recipes.security.authentication.facade;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import recipes.user.exception.UserAuthorizationException;

@Component
public class AuthenticationFacadeImpl implements AuthenticationFacade {
	@Override
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext()
		                            .getAuthentication();
	}

	@Override
	public String getAuthenticationName() {
		return getAuthentication()
			.getName();
	}

	@Override
	public void throwIfUserIsNotAuthorised(String username) {
        if (!username.equals(getAuthentication().getName())) {
            throw new UserAuthorizationException();
        }
	}
}