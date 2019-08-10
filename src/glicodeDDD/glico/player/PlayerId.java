package glicodeDDD.glico.player;

import java.util.UUID;

public class PlayerId {

	private String id;

	public PlayerId() {
		this.id = UUID.randomUUID().toString();
	}
}
