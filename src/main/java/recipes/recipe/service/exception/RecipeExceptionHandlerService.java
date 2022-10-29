package recipes.recipe.service.exception;

import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class RecipeExceptionHandlerService {
	public String getMethodArgumentsFailMessage(MethodArgumentNotValidException e) {
		StringBuilder stringBuilder = new StringBuilder();
		for (ObjectError error : e.getBindingResult()
		                          .getAllErrors()) {
			stringBuilder.append(error.getDefaultMessage())
			             .append("\n");
		}
		return stringBuilder.toString();
	}
}
