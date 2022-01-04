package dev.joerideg.dadjokes;

import lombok.Data;

@Data
public class DadJokeResponse {
	public String id;
	public String joke;
	public String status;
}
