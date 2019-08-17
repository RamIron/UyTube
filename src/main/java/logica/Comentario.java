package logica;

import java.util.Date;
import java.util.Map;

import datatypes.DtComentario;

public class Comentario {
	private Integer id;
	private Date fecha;
	private String texto;
	private Usuario usuario;
	private Map<Integer, Comentario> respuestas;
	
	//Constructores
	public Comentario() {
		super();
	}
	public Comentario(Integer id, Date fecha, String texto, Usuario usuario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.texto = texto;
		this.usuario = usuario;
	}
	
	//Getters & Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Map<Integer, Comentario> getRespuestas() {
		return respuestas;
	}
	
	//Operaciones
	/*public void crearRespuesta(Usuario uC, Date fCom, String texto) {}
	
	public Map<Integer, DtComentario> getRespuestas2(){}*/
	
}
