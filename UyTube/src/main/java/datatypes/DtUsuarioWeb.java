package datatypes;

import java.util.ArrayList;
import java.util.List;

public class DtUsuarioWeb {
    private String nickname;
    private String foto;
    private List<String> listaRep = new ArrayList<String>();

    public DtUsuarioWeb() {
    }

    public DtUsuarioWeb(String nickname, String foto, List<String> listaRep) {
        this.nickname = nickname;
        this.foto = foto;
        this.listaRep = listaRep;
    }

    public String getNickname() {
        return nickname;
    }

    public String getFoto() {
        return foto;
    }

    public List<String> getListaRep() {
        return listaRep;
    }
}


