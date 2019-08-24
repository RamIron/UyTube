package logica;

import java.io.Serializable;

public class ValoracionID implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nickname;
	private int idV;
	
	
	public ValoracionID() {
		super();
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getIdV() {
		return idV;
	}


	public void setIdV(int idV) {
		this.idV = idV;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idV;
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValoracionID other = (ValoracionID) obj;
		if (idV != other.idV)
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		return true;
	}
	
}
