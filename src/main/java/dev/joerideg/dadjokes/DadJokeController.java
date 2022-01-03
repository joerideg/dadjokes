package dev.joerideg.dadjokes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DadJokeController {

	@GetMapping("/")
	public String joke() {
		DadJoke joke = new DadJoke("Hello world");
		return joke.getMessage();
	}
}
