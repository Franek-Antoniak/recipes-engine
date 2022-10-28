package recipes.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import recipes.user.User;
import recipes.user.annotations.PasswordToBcryptedPasswordMapper;
import recipes.user.model.UserCreate;

@Mapper(componentModel = "spring")
@Component
public abstract class UserCreateMapper {

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserCreateMapper() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
	}

	@Mappings({@Mapping(target = "id", ignore = true), @Mapping(target = "enabled", ignore = true), @Mapping(target = "recipes", ignore = true), @Mapping(target = "roles", ignore = true), @Mapping(target = "username", source = "email"), @Mapping(target = "password", source = "password", qualifiedBy = PasswordToBcryptedPasswordMapper.class)})
	public abstract User toUser(UserCreate userCreate);

	@PasswordToBcryptedPasswordMapper
	public String passwordToBcryptedPassword(String password) {
		return bCryptPasswordEncoder.encode(password);
	}
}