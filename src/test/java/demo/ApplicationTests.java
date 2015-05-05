package demo;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import eu.teamtool.Application;
import eu.teamtool.domain.User;
import eu.teamtool.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ApplicationTests {
	
	@Autowired
	private UserRepository userRepo;

	@Value("${local.server.port}")
	private int port;

	private RestTemplate template = new TestRestTemplate();
	
	@Test
	public void testUserRepo() {
		assertEquals(1, userRepo.count());
		User userOzgur = userRepo.findOneByUsername("ozgur");
		assertEquals("password", userOzgur.getPassword());
		
		Collection<SimpleGrantedAuthority> authorities = userOzgur.getAuthorities();
		assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
		assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_USER")));
		assertEquals(2, authorities.size());
	}

	@Test
	public void homePageLoads() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:"
				+ port + "/", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void userEndpointProtected() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:"
				+ port + "/user", String.class);
		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
	}

	@Test
	public void resourceEndpointProtected() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:"
				+ port + "/resource", String.class);
		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
	}

	@Test
	public void loginSucceeds() {
		RestTemplate template = new TestRestTemplate("user", "111");
		ResponseEntity<String> response = template.getForEntity("http://localhost:" + port
				+ "/user", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
