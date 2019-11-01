package datatypes;

import java.util.Calendar;

public class DtVisita {
    private String usrVideo;
    private String nomVideo;
    private Calendar ultimaVisita;
    private Integer cantVisitas;

    public DtVisita() {}

    public DtVisita(String usrVideo, String nomVideo, Calendar ultimaVisita, Integer cantVisitas) {
        this.usrVideo = usrVideo;
        this.nomVideo = nomVideo;
        this.ultimaVisita = ultimaVisita;
        this.cantVisitas = cantVisitas;
    }

    public String getUsrVideo() {
        return usrVideo;
    }

    public String getNomVideo() {
        return nomVideo;
    }

    public Calendar getUltimaVisita() {
        return ultimaVisita;
    }

    public Integer getCantVisitas() {
        return cantVisitas;
    }
}
