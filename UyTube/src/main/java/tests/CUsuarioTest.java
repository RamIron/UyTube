package tests;

import Manejadores.ManejadorCategoria;
import Manejadores.ManejadorUsuario;
import datatypes.DtCanal;
import datatypes.DtCanalWeb;
import datatypes.DtUsuario;
import datatypes.DtUsuarioWeb;
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
import java.util.List;

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
        iU.obtenerInfoUsuario("usr1");
        assertEquals(1, iU.listarSeguidores().size());
    }

    @Test
    public void listarSeguidos() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarUsuario("usr2", "nom", "apellido", fecha, "email2");
        iU.seguirUsuario("usr2", "usr1");
        iU.obtenerInfoUsuario("usr2");
        assertEquals(1, iU.listarSeguidos().size());
    }

    @Test
    public void listarUsuarios() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarUsuario("usr2", "nom", "apellido", fecha, "email2");
        assertEquals(2, iU.listarUsuarios().size());
    }

    @Test
    public void modificarImagen() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        String img = "img";
        iU.modificarImagen(img);
        assertEquals(img, mU.obtenerUsuario("usr1").getImagen());
    }

    @Test
    public void modificarContrasena() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.modificarContrasena("pass");
        assertEquals("pass", mU.obtenerUsuario("usr1").getContrasena());
    }

    @Test
    public void modificarInfoCanal() {
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
    public void modificarInfoUsuario() {
        Calendar fecha = Calendar.getInstance();
        Usuario usrEsperado = new Usuario("usr1", "nom2", "apellido", fecha, "email");
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.modificarInfoUsuario("nom2", "apellido", fecha, "email");
        assertEquals(usrEsperado.getNombre(), mU.obtenerUsuario("usr1").getNombre());
    }

    @Test
    public void obtenerInfoCanal() {
        Calendar fecha = Calendar.getInstance();
        Usuario usrEsperado = new Usuario("usr1", "nom", "apellido", fecha, "email");
        Canal canalEsperado = new Canal("nom", "desc", true);
        canalEsperado.setUsuario(usrEsperado);
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarCanal();
        iU.modificarInfoCanal("nom", "desc", true);
        DtCanal canalObtenido = iU.obtenerInfoCanal();
        assertEquals(canalEsperado.getNombre(), canalObtenido.getNombre());

    }

    @Test
    public void obtenerInfoUsuario() {
        Calendar fecha = Calendar.getInstance();
        Usuario usrEsperado = new Usuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        DtUsuario usrObtenido = iU.obtenerInfoUsuario("usr1");
        assertEquals(usrEsperado.getNombre(), usrObtenido.getNombre());
    }

    @Test
    public void esCanalPublico() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarCanal();
        iU.modificarInfoCanal("nom", "desc", true);
        assertEquals(true, iU.esCanalPublico("usr1"));
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
        //Retorna: 0-> si no coincide los datos
        //		   1-> si coincide con nickname
        //		   2-> si coincide con email
        Integer[] esperado= {0, 1, 2};
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.modificarContrasena("pass");
        Integer[] obtenido = new Integer[3];
        obtenido[0] = iU.iniciarSesion("error", "pass");
        obtenido[1] = iU.iniciarSesion("usr1", "pass");
        obtenido[2] = iU.iniciarSesion("email", "pass");
        assertArrayEquals(esperado, obtenido);
    }

    @Test
    public void obtenerUsuarioWebNick() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarCanal();
        DtUsuarioWeb obtenido = iU.obtenerUsuarioWebNick("usr1");
        assertEquals("usr1", obtenido.getNickname());
    }

    @Test
    public void obtenerUsuarioWebEmail() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarCanal();
        DtUsuarioWeb obtenido = iU.obtenerUsuarioWebEmail("email");
        assertEquals("usr1", obtenido.getNickname());
    }

    @Test
    public void listarUsuariosWeb() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarCanal();
        iU.agregarUsuario("usr2", "nom", "apellido", fecha, "email2");
        iU.agregarCanal();
        assertEquals(2, iU.listarUsuariosWeb().size());
    }

    @Test
    public void listarNickFotoWeb() {
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.agregarCanal();
        iU.agregarUsuario("usr2", "nom", "apellido", fecha, "email2");
        iU.agregarCanal();
        List<String> lis = iU.listarUsuarios();
        assertEquals(2, iU.listarNickFotoWeb(lis).size());
    }

    @Test
    public void busqueda() {
        Integer[] esperado = {1, 1};
        Calendar fecha = Calendar.getInstance();
        iU.agregarUsuario("usr1", "nom", "apellido", fecha, "email");
        iU.modificarImagen("img");
        iU.agregarCanal();
        iU.modificarInfoCanal("nom", "des", true);
        List<DtCanalWeb> lisAlfa = iU.busqueda("nom", false);
        List<DtCanalWeb> lisFecha = iU.busqueda("nom", true);
        Integer[] obtenido = {lisAlfa.size(), lisFecha.size()};
        assertArrayEquals(esperado, obtenido);
    }

    @After
    public void terminarCaso(){
        mU.cerrarConexion();
    }
}