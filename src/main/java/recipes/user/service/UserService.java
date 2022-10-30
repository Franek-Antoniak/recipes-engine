package recipes.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import recipes.user.User;
import recipes.user.details.role.UserRole;
import recipes.user.exception.UserAlreadyExistsException;
import recipes.user.model.UserCreate;
import recipes.user.model.mapper.UserCreateMapper;
import recipes.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final UserCreateMapper userCreateMapper;

	public void createNewUser(UserCreate userCreate) {
		boolean isExists = userRepository.existsUserByUsername(userCreate.getEmail());
		if (isExists) {
			throw new UserAlreadyExistsException("User already exists");
		}
		User user = userCreateMapper.toUser(userCreate);
		user.getRoles()
		    .add(UserRole.USER);
		userRepository.save(user);
	}

	public User getUserByName(String username) {
		return userRepository.findByUsername(username)
		                     .orElseThrow(
				                     () -> new UsernameNotFoundException("User with given username doesn't exist"));
	}
}
