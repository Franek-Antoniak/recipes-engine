package recipes.pattern.usecase.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Indicates class as a UseCase - such class is a made by same pattern.
 * UseCase connects Facade and Recipe per DTO.
 * <p>In the same time indicates that an annotated class is a "component".
 * Such classes are considered as candidates for auto-detection
 * when using annotation-based configuration and classpath scanning.
 *
 * @author Franek Antoniak
 * @see Component
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface UseCase {

	/**
	 * The value may indicate a suggestion for a logical component name,
	 * to be turned into a Spring bean in case of an autodetected component.
	 *
	 * @return the suggested component name, if any (or empty String otherwise)
	 */
	String value() default "";

}
