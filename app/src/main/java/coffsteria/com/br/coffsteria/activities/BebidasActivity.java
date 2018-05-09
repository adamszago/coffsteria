package coffsteria.com.br.coffsteria.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import coffsteria.com.br.coffsteria.R;
import coffsteria.com.br.coffsteria.geradores.Bebida;

public class BebidasActivity extends AppCompatActivity {


    public static final String EXTRA_BEBIDA = "bebidaNro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        int numeroBebida = (Integer) getIntent().getExtras().get(EXTRA_BEBIDA);
        Bebida bebida = Bebida.bebidas[numeroBebida];

        ImageView imagem = (ImageView) findViewById(R.id.imgBebida);
        imagem.setImageResource(bebida.getImagemId());
        imagem.setContentDescription(bebida.getNome());

        TextView nomeBebida = (TextView) findViewById(R.id.nomeBebida);
        nomeBebida.setText(bebida.getNome());

        TextView descBebida = (TextView) findViewById(R.id.descBebida);
        descBebida.setText(bebida.getDescricao());

        TextView precoBebida = (TextView) findViewById(R.id.precoBebida);
        precoBebida.setText(bebida.getPreco());

        TextView tamanhoBebida = (TextView) findViewById(R.id.tamBebida);
        tamanhoBebida.setText(bebida.getTamanho());
    }
}
