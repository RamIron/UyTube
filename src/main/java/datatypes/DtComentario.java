package datatypes;

import java.util.*;
import logica.*;

public class DtComentario {
	private Integer id;
	private String nickname;
	private Calendar fecha;
	private String texto;
	private List<DtComentario> respuestas;
	
	public DtComentario() {
	
	}

	public DtComentario(Integer id, String nickname, Calendar fecha, String texto, List<DtComentario> respuestas) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.fecha = fecha;
		this.texto = texto;
		this.respuestas = respuestas;
	}
	
	public DtComentario(Integer id, String nickname, Calendar fecha, String texto) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.fecha = fecha;
		this.texto = texto;
	}				
	
	public DtComentario(String texto) { //temporal
		super();
		this.texto = texto;
	}

	public Integer getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public String getTexto() {
		return texto;
	}

	public List<DtComentario> getRespuestas() {
		return respuestas;
	}
	
}

