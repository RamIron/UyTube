package datatypes;

public class DtValoracion {
	private String nickname;
	private Boolean gusta;
	
	public DtValoracion() {
		super();
	}
	
	public DtValoracion(String nickname, Boolean gusta) {
		super();
		this.nickname = nickname;
		this.gusta = gusta;
	}

	public String getNickname() {
		return nickname;
	}

	public Boolean getGusta() {
		return gusta;
	}
		
}
