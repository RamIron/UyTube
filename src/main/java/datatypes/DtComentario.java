package datatypes;

import java.util.*;
import logica.*;

public class DtComentario {
	private Integer id;
	private String nickname;
	private Date fecha;
	private String texto;
	private List<DtComentario> respuestas;
	
	public DtComentario() {
	
	}

	public DtComentario(Integer id, String nickname, Date fecha, String texto, List<DtComentario> respuestas) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.fecha = fecha;
		this.texto = texto;
		this.respuestas = respuestas;
	}

	public Integer getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getTexto() {
		return texto;
	}

	public List<DtComentario> getRespuestas() {
		return respuestas;
	}
	
}

