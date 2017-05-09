package hello;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * As well as mocking the HTTP request cycle we can also use Spring Boot to write a very simple
 * full-stack integration test. For example, instead of (or as well as) the mock test in HelloControllerTest
 * we could do the following.
 *
 * The @RunWith(SpringRunner.class) tells JUnit to run using Spring’s testing support.
 * The @SpringBootTest is saying “bootstrap with Spring Boot’s support”
 * (e.g. load application.properties and give me all the Spring Boot goodness).
 * The webEnvironment attribute allows specific “web environments” to be configured for the test.
 * You can start tests with a MOCK servlet environment or with a real HTTP server running on either
 * a RANDOM_PORT or a DEFINED_PORT.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    @LocalServerPort //discovers actual port at runtime
    private int port;

	private URL base;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}

	@Test
	public void getHello() throws Exception {
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
	}
}