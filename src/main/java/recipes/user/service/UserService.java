package recipes.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import recipes.user.User;
import recipes.user.exception.UserAlreadyExistAuthenticationException;
import recipes.user.mapper.UserCreateMapper;
import recipes.user.model.UserCreate;
import recipes.user.repository.UserRepository;
import recipes.user.details.role.UserRole;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final UserCreateMapper userCreateMapper;

	public void createNewUser(UserCreate userCreate) {
		User user = userCreateMapper.toUser(userCreate);
		user.getRoles()
		    .add(UserRole.USER);
		boolean isExists = userRepository.existsUserByUsername(user.getUsername());
		if (isExists) {
			throw new UserAlreadyExistAuthenticationException("User already exists");
		}
		userRepository.save(user);
	}

	public User findUserByName(String username) {
		return userRepository.findByUsername(username)
		                     .orElseThrow(
				                     () -> new UsernameNotFoundException("User with given username doesn't exist"));
	}
}
