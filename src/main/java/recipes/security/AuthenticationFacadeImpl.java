package recipes.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import recipes.user.exception.UserAuthorizationException;

@Component
public class AuthenticationFacadeImpl implements AuthenticationFacade {
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public void throwIfUserIsNotAuthorised(String username) {
        if(!username.equals(getAuthentication().getName()))
            // FIXME: 02.07.2021 Ask Jakub if exception from User can be there
            throw new UserAuthorizationException();
    }
}