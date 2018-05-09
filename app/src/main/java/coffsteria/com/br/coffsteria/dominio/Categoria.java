package coffsteria.com.br.coffsteria.dominio;

import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;
import java.util.Objects;

import coffsteria.com.br.coffsteria.utilitarios.Configuracao;

public class Categoria implements Serializable{

    private String id;
    private String nome;

    @Override
    public String toString() {
        return nome;
    }

    public Categoria(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Categoria() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria that = (Categoria) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public void salvarCategoria(){
        DatabaseReference banco = Configuracao.obterReferenciaFirebase().child("categorias");
        banco.child(getId()).setValue(this);
    }
}
