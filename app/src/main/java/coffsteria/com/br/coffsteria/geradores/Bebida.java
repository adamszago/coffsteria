package coffsteria.com.br.coffsteria.geradores;

import coffsteria.com.br.coffsteria.R;

public class Bebida {

    private String nome;
    private String descricao;
    private String preco;
    private String tamanho;
    private int imagemId;

    public static final Bebida[] bebidas = {
        new Bebida("Latte"
                , "café expresso com leite vaporizado com uma quantidade generosa de espuma de leite no topo"
                , "R$12,50", "50ml", R.drawable.latte),
        new Bebida("Cappucino"
                           , "é uma bebida italiana preparada com café expresso e leite, com pó de canela e chocolate"
                           , "R$9,80", "50ml", R.drawable.cappucino),
        new Bebida("Lungo"
                           , "é um estilo de café preparado por adição de água quente no café, dando uma força semelhante, mas sabor diferente."
                           , "R$7,50", "50ml", R.drawable.lungo),
        new Bebida("Tea"
                           , "infusões de diversos saberes em água quente na temperatura ideal"
                           , "R$7,10", "70ml", R.drawable.tea),
        new Bebida("Colombian Coffee"
                    , "Café 100% arábica forte e características do puro café colombiano"
                    , "R$8,30", "70ml", R.drawable.colombian),
    };

    public Bebida(String nome, String descricao, String preco, String tamanho, int imagemId) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.tamanho = tamanho;
        this.imagemId = imagemId;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPreco() {
        return preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public int getImagemId() {
        return imagemId;
    }

    @Override
    public String toString() {
        return nome;
    }
}
