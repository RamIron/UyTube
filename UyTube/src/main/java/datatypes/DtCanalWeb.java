package datatypes;

public class DtCanalWeb {
    private String nickname;
    private String nomCanal;
    private String imgUsr;

    public DtCanalWeb() {
    }

    public DtCanalWeb(String nickname, String nomCanal, String imgUsr) {
        this.nickname = nickname;
        this.nomCanal = nomCanal;
        this.imgUsr = imgUsr;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNomCanal() {
        return nomCanal;
    }

    public String getImgUsr() {
        return imgUsr;
    }
}
