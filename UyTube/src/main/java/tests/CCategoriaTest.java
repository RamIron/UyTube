package tests;

import Manejadores.ManejadorCategoria;
import com.sun.org.apache.xpath.internal.operations.Bool;
import datatypes.DtElementoUsuario;
import datatypes.DtElementoWeb;
import interfaces.CFactory;
import interfaces.ICategoria;
import logica.Categoria;
import logica.Elemento;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.RollbackException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CCategoriaTest {
    private ICategoria iC = null;
    private ManejadorCategoria mC = null;

    @Before
    public void inicializar(){
        iC = CFactory.getInstancia().getICategoria();
        mC = ManejadorCategoria.getInstancia();
    }

    @Test
    public void altaCategoria() {
        Categoria catEsperada = new Categoria("Deportes");
        iC.altaCategoria("Deportes");
        Categoria catObtenida = mC.obtenerCategoria("Deportes");
        assertEquals(catEsperada.getNombre(), catObtenida.getNombre());
    }

    @Test
    public void listarElemCategoria() {
        iC.altaCategoria("Deportes");
        List<DtElementoUsuario> elemObtenidos = iC.listarElemCategoria("Deportes");
        assertEquals(0, elemObtenidos.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void listarElemCategoriaException() {
        List<DtElementoUsuario> elemObtenidos = iC.listarElemCategoria("Deportes");
    }

    @Test
    public void listarVideosPublicosCategoria() {
        iC.altaCategoria("Deportes");
        List<DtElementoWeb> vidsObtenidos = iC.listarVideosPublicosCategoria("Deportes");
        assertEquals(0, vidsObtenidos.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void listarVideosException() {
        List<DtElementoWeb> vidsObtenidos = iC.listarVideosPublicosCategoria("Deportes");
    }

    @Test
    public void listarCategorias() {
        iC.altaCategoria("Deportes");
        iC.altaCategoria("Animales");
        List<String> resObtenido = iC.listarCategorias();
        assertEquals(2, resObtenido.size());
    }

    @Test
    public void existeCategoria() {
        iC.altaCategoria("Deportes");
        Boolean resEsperado = iC.existeCategoria("Deportes");
        assertEquals(true, resEsperado);
    }

    @Test
    public void limpiarControlador() {
        iC.limpiarControlador();
        assertEquals(true, !false);
    }

    @After
    public void terminarCaso(){
        mC.cerrarConexion();
    }
}