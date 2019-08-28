package logica;

import javax.persistence.*;

@Entity
public class Valoracion {
	@Id
	@SequenceGenerator(name = "valoracionGenerator", sequenceName = "VALORACION_SEQUENCE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "valoracionGenerator")
	private Integer id;
	
	private boolean gusta;
	
	//@Id 
	@ManyToOne
	@JoinColumn(insertable=false, updatable=false)
	private Usuario usuario;
	
	//@Id 
	@ManyToOne
	@JoinColumn(insertable=false, updatable=false)
	private Video video;
	
	//Constructores
	public Valoracion() {
		super();
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
