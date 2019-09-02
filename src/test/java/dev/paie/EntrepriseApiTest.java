/**
 * 
 */
package dev.paie;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import dev.paie.entites.EntrepriseDto;

/**
 * @author Guillaume
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseApiTest {

	RestTemplate rt = new RestTemplate();

	@Test
	public void testGet() {

		EntrepriseDto[] tableauEntreprises = rt.getForObject("https://guillaume-paie-api.herokuapp.com/entreprises",
				EntrepriseDto[].class);

		List<EntrepriseDto> listeEntreprises = Arrays.asList(tableauEntreprises);

		assertThat(listeEntreprises.isEmpty()).isFalse();

		assertThat(listeEntreprises.get(0).getCode().length()).isGreaterThan(0);
		assertThat(listeEntreprises.get(0).getDenomination().length()).isGreaterThan(0);

		ResponseEntity<EntrepriseDto[]> responseEntity = rt.exchange(
				"https://guillaume-paie-api.herokuapp.com/entreprises", HttpMethod.GET, null, EntrepriseDto[].class);

		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

	}

	@Test
	public void testGetKevin() {

		EntrepriseDto[] tableauEntreprises = rt.getForObject("https://kseguineau-paie-api.herokuapp.com/entreprises",
				EntrepriseDto[].class);

		List<EntrepriseDto> listeEntreprises = Arrays.asList(tableauEntreprises);

		assertThat(listeEntreprises.isEmpty()).isFalse();

		assertThat(listeEntreprises.get(0).getCode().length()).isGreaterThan(0);
		assertThat(listeEntreprises.get(0).getDenomination().length()).isGreaterThan(0);

		ResponseEntity<EntrepriseDto[]> responseEntity = rt.exchange(
				"https://guillaume-paie-api.herokuapp.com/entreprises", HttpMethod.GET, null, EntrepriseDto[].class);

		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

	}

}
