package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * http://spring.io/guides/gs/spring-boot/#_create_a_simple_web_application
 *
 * The class is flagged as a @RestController, meaning it’s ready for use by Spring MVC to handle web requests.
 * The @RequestMapping annotation maps / to the index() method. When invoked from a browser or using curl on the
 * command line, the method returns pure text. That’s because @RestController combines @Controller and @ResponseBody,
 * two annotations that results in web requests returning data rather than a view.
 * 
 * http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-ann-requestmapping
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
