package datatypes;

public class DtElementoUsuario {
	private String nickname;
	private String nombreE;
	private tipoElemento tipo;
	
	//Constructores
	public DtElementoUsuario() {
		super();
	}

	public DtElementoUsuario(String nickname, String nombreE, tipoElemento tipo) {
		super();
		this.nickname = nickname;
		this.nombreE = nombreE;
		this.tipo = tipo;
	}

	//Getters
	public String getNickname() {
		return nickname;
	}

	public String getNombreE() {
		return nombreE;
	}

	public tipoElemento getTipo() {
		return tipo;
	}
	
	
	
}
