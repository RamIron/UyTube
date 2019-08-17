package logica;

public class Valoracion {
	private boolean gusta;
	private Usuario usuario;
	private Video video;
	
	//Constructores
	public Valoracion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Valoracion(boolean gusta, Usuario usuario, Video video) {
		super();
		this.gusta = gusta;
		this.usuario = usuario;
		this.video = video;
	}
	
	//Getters & Setters
	public boolean isGusta() {
		return gusta;
	}
	public void setGusta(boolean gusta) {
		this.gusta = gusta;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Video getVideo() {
		return video;
	}
	
	public void setVideo(Video video) {
		this.video = video;
	}
	
	
}
