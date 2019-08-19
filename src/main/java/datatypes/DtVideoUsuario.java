package datatypes;

public class DtVideoUsuario {
	private String nickname;
	private String nombreE;
	
	
	//Constructores
	public DtVideoUsuario() {
		super();
	}
	
	public DtVideoUsuario(String nickname, String nombreE) {
		super();
		this.nickname = nickname;
		this.nombreE = nombreE;
	}
	
	//Getters
	public String getNickname() {
		return nickname;
	}
	
	public String getNombreE() {
		return nombreE;
	}
}
