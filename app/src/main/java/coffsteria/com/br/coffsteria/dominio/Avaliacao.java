package coffsteria.com.br.coffsteria.dominio;

import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;
import java.util.Objects;

import coffsteria.com.br.coffsteria.utilitarios.Configuracao;

public class Avaliacao implements Serializable {

    private String id;
    private int nota;

    public Avaliacao(String id, int nota) {
        this.id = id;
        this.nota = nota;
    }

    public Avaliacao() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return Objects.equals(id, avaliacao.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }


    public void salvarAvaliacao(){
        DatabaseReference banco = Configuracao.obterReferenciaFirebase().child("avaliacoes");
        banco.child(getId()).setValue(this);
    }
}
