package glicodeDDD.glico.player;

public class PlayerName {
	private String name;

	public PlayerName(String name) {
		this.name = name;
	}

	public String value() {
		return name + "さん";
	}

}
