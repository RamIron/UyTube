package logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Valoracion {
	@Id
	@SequenceGenerator(name = "valoracionGenerator", sequenceName = "VALORACION_SEQUENCE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "valoracionGenerator")
	private int id;
	
	private boolean gusta;
	
	@ManyToOne
//	@JoinColumn(insertable=false, updatable=false)
	private Usuario usuario;
	
	@ManyToOne
//	@JoinColumn(insertable=false, updatable=false)
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
