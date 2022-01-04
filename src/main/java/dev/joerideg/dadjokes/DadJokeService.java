package dev.joerideg.dadjokes;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class DadJokeService {
	private final RestTemplate restTemplate;

	DadJoke getDadJoke() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<DadJokeResponse> entity = new HttpEntity<>(headers);

		log.info("Sending dad joke request");

		ResponseEntity<DadJokeResponse> apiResponseEntity = this.restTemplate.exchange(
				"https://icanhazdadjoke.com/",
				HttpMethod.GET,
				entity,
				DadJokeResponse.class);

		log.info("got dad joke response", apiResponseEntity.toString());

		DadJokeResponse jokeResponse = apiResponseEntity.getBody();
		return new DadJoke(jokeResponse.joke);
	}
}
