package dev.joerideg.dadjokes;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@Component
@RestController
@RequiredArgsConstructor
public class DadJokeController {
	private final DadJokeService dadJokeService;

	@GetMapping("/")
	public String retrieveDadJoke() {
		DadJoke dadJoke = this.dadJokeService.getDadJoke();
		return dadJoke.getMessage();
	}
}
