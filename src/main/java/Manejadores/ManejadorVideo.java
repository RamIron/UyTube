package Manejadores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import logica.Conexion;
import logica.Usuario;

public class ManejadorVideo {
private static ManejadorVideo instancia = null;
	
	private ManejadorVideo(){}
	
	public static ManejadorVideo getInstancia() {
		if (instancia == null)
			instancia = new ManejadorVideo();
		return instancia;
	}
	
	
}
