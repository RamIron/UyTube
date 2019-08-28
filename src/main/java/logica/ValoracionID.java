//package logica;
//
//import java.io.Serializable;
//
//public class ValoracionID implements Serializable{
//	private static final long serialVersionUID = 1L;
//	
//	private String usuario;
//	private int video;
//		
//	
//	public ValoracionID() {
//		super();
//	}
//	public String getUsuario() {
//		return usuario;
//	}
//	public void setUsuario(String usuario) {
//		this.usuario = usuario;
//	}
//	public int getVideo() {
//		return video;
//	}
//	public void setVideo(int video) {
//		this.video = video;
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
//		result = prime * result + video;
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ValoracionID other = (ValoracionID) obj;
//		if (usuario == null) {
//			if (other.usuario != null)
//				return false;
//		} else if (!usuario.equals(other.usuario))
//			return false;
//		if (video != other.video)
//			return false;
//		return true;
//	}
//}
