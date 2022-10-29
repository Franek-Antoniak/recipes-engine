package recipes.user.model.mapper;

import org.mapstruct.Mapper;
import recipes.user.User;
import recipes.user.model.UserRead;

@Mapper(componentModel = "spring")
public abstract class UserReadMapper {
	public abstract UserRead toUserRead(User user);
}