package logica;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tokenUsuarios")
@NamedNativeQueries({
        @NamedNativeQuery(name = "buscarToken", query = "SELECT c FROM TokenUsuario c WHERE c.selector = :selector")
})
public class TokenUsuario implements Serializable {
    @Id
    private String selector;
    private String validador;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public TokenUsuario() {
    }

    public TokenUsuario(String selector, String validador, Usuario usuario) {
        this.selector = selector;
        this.validador = validador;
        this.usuario = usuario;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public String getValidador() {
        return validador;
    }

    public void setValidador(String validador) {
        this.validador = validador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}