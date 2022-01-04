package dev.joerideg.dadjokes;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DadJokeService {
	private final RestTemplateBuilder restTemplateBuilder;
	private final RestTemplate restTemplate;

	public DadJokeService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplateBuilder = restTemplateBuilder;
		this.restTemplate = this.restTemplateBuilder.build();
	}

	DadJoke getJoke() {
		return new DadJoke("Hello world");
	}
}
