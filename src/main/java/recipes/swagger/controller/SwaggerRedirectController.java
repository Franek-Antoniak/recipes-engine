package recipes.swagger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@ApiIgnore
public class SwaggerRedirectController {

	@RequestMapping("/")
	@ResponseStatus(value = HttpStatus.PERMANENT_REDIRECT)
	public ModelAndView redirectToSwagger() {
		return new ModelAndView("redirect:/swagger-ui/");
	}
}
