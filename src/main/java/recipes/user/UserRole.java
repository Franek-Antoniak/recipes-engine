package recipes.user;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserRole {
	USER, ADMIN;

	public String getExtendedName() {
		return "ROLE_" + this.name();
	}
}
