package tests;

import datatypes.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class DataTypesTest {

    @Test
    public void DtElementoUsuario() {
        DtElementoUsuario usr1 = new DtElementoUsuario();
        usr1.setNickname("mateo");
        usr1.setNombreE("videito");
        usr1.setTipo(tipoElemento.VIDEO);
        DtElementoUsuario usr2 = new DtElementoUsuario(usr1.getNickname(), usr1.getNombreE(), usr1.getTipo());
        assertEquals(usr1.getNombreE(), usr2.getNombreE());
    }

    @Test
    public void DtCanal() {
        DtCanal can1 = new DtCanal();
        can1.setNombre("mateo");
        can1.setDescripcion("asdasd");
        can1.setCategoria("Deportes");
        can1.setPublico(true);
        DtCanal can2 = new DtCanal(can1.getNombre(), can1.getDescripcion(), can1.getPublico(), can1.getCategoria());
        assertEquals(can1.getNombre(), can2.getNombre());
    }

    @Test
    public void DtCanalWeb() {
        DtCanalWeb can1 = new DtCanalWeb();
        can1.setNickname("mateo");
        can1.setNomCanal("asdasdasdad");
        can1.setImgUsr("asdasdad");
        DtCanalWeb can2 = new DtCanalWeb(can1.getNickname(), can1.getNomCanal(), can1.getImgUsr());
        assertEquals(can1.getNickname(), can1.getNickname());
    }



}
