package recipes.recipe.exception;

public class RecipeNotFoundException extends RuntimeException {
	public RecipeNotFoundException(String message) {
		super(message);
	}

	public RecipeNotFoundException() {
		super();
	}

	public RecipeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecipeNotFoundException(Throwable cause) {
		super(cause);
	}
}
