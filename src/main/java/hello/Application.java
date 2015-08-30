package hello;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * http://spring.io/guides/gs/spring-boot/#_create_an_application_class
 *
 * The @SpringBootApplication is a convenience annotation that adds the following:
 *  - @Configuration tags the class as a source of bean definitions for the application context.
 *  - @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans,
 *    and various property settings.
 *  - Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it
 *    sees spring-webmvc on the classpath. This flags the application as a web application and activates key
 *    behaviors such as setting up a DispatcherServlet.
 *  - @ComponentScan tells Spring to look for other components, configurations, and services in the hello package,
 *    allowing it to find the HelloController.
 *
 *  Run the application:
 *  1) ./gradlew build
 *  2) java -jar build/libs/gs-spring-boot-0.1.0.jar
 *
 *  Check out the service:
 *  localhost:8080
 */
@SpringBootApplication
public class Application {

    /**
     * Uses Spring Boot's SpringApplication.run() method to launch an application.
     * The run() method returns an ApplicationContext and this application then retrieves all the beans that
     * were created either by your app or were automatically added thanks to Spring Boot. It sorts them and
     * prints them out.
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

}