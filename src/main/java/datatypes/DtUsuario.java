package datatypes;

import java.util.*;

public class DtUsuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private Date fNac;
	private String imagen;
	private String correoE;
	
	//Constructor
	public DtUsuario() {
		super();
	}

	public DtUsuario(String nickname, String nombre, String apellido, Date fNac, String imagen, String correoE) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fNac = fNac;
		this.imagen = imagen;
		this.correoE = correoE;
	}

	public String getNickname() {
		return nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Date getfNac() {
		return fNac;
	}

	public String getImagen() {
		return imagen;
	}

	public String getCorreoE() {
		return correoE;
	}
	
	@Override
	public String toString() {
		return "DtUsuario [nickname=" + nickname + ", nombre=" + nombre + ", apellido=" + apellido + ", fNac=" + fNac
				+ ", imagen=" + imagen + ", correoE=" + correoE + "]";
	}
	
	
		
}
