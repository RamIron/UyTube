package logica;

import java.util.*;

import datatypes.DtComentario;
import javax.persistence.*;

@Entity
public class Comentario {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Date fecha;
	private String texto;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Comentario> respuestas;
	
	//Constructores
	public Comentario() {
		super();
	}
	public Comentario(Date fecha, String texto, Usuario usuario) {
		super();
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
	
	/*public Map<Integer, Comentario> getRespuestas() {
		return respuestas;
	}*/
	
	//Operaciones
	public void crearRespuesta(Usuario uC, Date fCom, String texto) {
		Comentario c = new Comentario(fCom,texto,uC);
		//respuestas.put(c.getId(), c);
	}
	
	public List<DtComentario> getRespuestas(){
		return null;
	} //TODO
	
}
