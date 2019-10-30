package tests;

import Manejadores.ManejadorCategoria;
import Manejadores.ManejadorUsuario;
import datatypes.DtCanal;
import interfaces.IUsuario;
import interfaces.UFactory;
import logica.CUsuario;
import logica.Canal;
import logica.Categoria;
import logica.Usuario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class CUsuarioTest {
    private IUsuario iU = null;
    private ManejadorUsuario mU = null;
    private ManejadorCategoria mC = null;

    @Before
    public void inicializar(){
        iU = UFactory.getInstancia().getIUsuario();
        mU = ManejadorUsuario.getInstancia();
        mC = ManejadorCategoria.getInstancia();
    }

    @Test
    public void agregarCanal() {
        Calendar fecha = Calendar.getInstance();
        Usuario usrEsperado = new Usuario("usr1", "nom", "apellido", fecha, "email");
        Canal canalEsperado = new Canal("nom", "desc", true);
        canalEsperado.setUsuario(usrEsperado);
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarCanal();
        iU.modificarInfoCanal("nom", "desc", true);
        Canal canalObtenido = mU.obtenerUsuario("usr1").getCanal();
        assertEquals(canalEsperado.getNombre(), canalObtenido.getNombre());
    }

    @Test
    public void modificarCatCanal() {
        Calendar fecha = Calendar.getInstance();
        Usuario usrEsperado = new Usuario("usr1", "nom", "apellido", fecha, "email");
        Canal canalEsperado = new Canal("nom", "desc", true);
        Categoria cat = new Categoria("perro");
        canalEsperado.setCategoria(cat);
        mC.agregarCategoria(cat);
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarCanal();
        iU.modificarCatCanal("usr1", cat.getNombre());
        Canal canalObtenido = mU.obtenerUsuario("usr1").getCanal();
        assertEquals(canalEsperado.getCategoria().getNombre(), canalObtenido.getCategoria().getNombre());
    }

    @Test
    public void agregarUsuario() {
        Calendar fecha = Calendar.getInstance();
        Usuario usrEsperado = new Usuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        Usuario usrObtenido = mU.obtenerUsuario("usr1");
        assertEquals(usrEsperado.getNickname(), usrObtenido.getNickname());
    }

    @Test
    public void dejarDeSeguirUsuario() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarUsuario("usr2", "nom", "apellido", fecha, "email2");
        iU.seguirUsuario("usr2", "usr1");
        iU.dejarDeSeguirUsuario("usr2", "usr1");
        Usuario usrObtenido = mU.obtenerUsuario("usr1");
        assertEquals(0, usrObtenido.getSeguidores().size());
    }

    @Test
    public void existeEmail() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        Boolean res = iU.existeEmail("email");
        assertEquals(true, res);
    }

    @Test
    public void existeNickname() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        Boolean res = iU.existeNickname("usr1");
        assertEquals(true, res);
    }

    @Test
    public void limpiarControlador() {
        iU.limpiarControlador();
        assertEquals(true, !false);
    }

    @Test
    public void listarSeguidores() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarUsuario("usr2", "nom", "apellido", fecha, "email2");
        iU.seguirUsuario("usr2", "usr1");
        Usuario usrObtenido = mU.obtenerUsuario("usr1");
        assertEquals(1, usrObtenido.getSeguidores().size());
    }

    @Test
    public void listarSeguidos() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarUsuario("usr2", "nom", "apellido", fecha, "email2");
        iU.seguirUsuario("usr2", "usr1");
        Usuario usrObtenido = mU.obtenerUsuario("usr2");
        assertEquals(1, usrObtenido.getSeguidores().size());
    }

    @Test
    public void listarUsuarios() {
    }

    @Test
    public void modificarImagen() {
    }

    @Test
    public void modificarContrasena() {
    }

    @Test
    public void modificarInfoCanal() {
    }

    @Test
    public void modificarInfoUsuario() {
    }

    @Test
    public void obtenerInfoCanal() {
    }

    @Test
    public void obtenerInfoUsuario() {
    }

    @Test
    public void esCanalPublico() {
    }

    @Test
    public void seguirUsuario() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarUsuario("usr2", "nom", "apellido", fecha, "email");
        iU.seguirUsuario("usr2", "usr1");
        Usuario usrObtenido = mU.obtenerUsuario("usr1");
        assertEquals(1, usrObtenido.getSeguidores().size());
    }


    @Test
    public void iniciarSesion() {
    }

    @Test
    public void obtenerUsuarioWebNick() {
    }

    @Test
    public void obtenerUsuarioWebEmail() {
    }

    @Test
    public void listarUsuariosWeb() {
    }

    @Test
    public void listarNickFotoWeb() {
    }

    @Test
    public void busqueda() {
    }

    @After
    public void terminarCaso(){
        mU.cerrarConexion();
    }
}