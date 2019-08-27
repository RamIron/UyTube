package logica;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Socio {
	@Id
	private String ci;
	private String nombre;
	public Socio(String ci, String nombre) {
		super();
		this.ci = ci;
		this.nombre = nombre;
	}
	public Socio() {
		super();
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
