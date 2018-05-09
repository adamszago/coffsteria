package coffsteria.com.br.coffsteria.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import coffsteria.com.br.coffsteria.R;
import coffsteria.com.br.coffsteria.dominio.Avaliacao;
import coffsteria.com.br.coffsteria.dominio.Categoria;
import coffsteria.com.br.coffsteria.utilitarios.Base64Util;

public class AvaliacaoActivity extends AppCompatActivity {


    private SeekBar nota;
    //private TextView exibicaoNota;
    private ImageView imagemNota;
    private Button avaliar;
    private int notaAvaliada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);

        nota = (SeekBar) findViewById(R.id.seekAval);
        //exibicaoNota = (TextView) findViewById(R.id.txtNota);
        imagemNota = (ImageView) findViewById(R.id.img_nota);
        avaliar = (Button) findViewById(R.id.btn_avaliar);

        avaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (notaAvaliada != 0) {
                    Avaliacao avaliacao= new Avaliacao();
                    avaliacao.setNota(notaAvaliada);
                    avaliacao.setId(Base64Util.encode(String.valueOf(avaliacao.getNota())));
                    avaliacao.salvarAvaliacao();
                    Toast.makeText(AvaliacaoActivity.this, "Avaliação cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(AvaliacaoActivity.this, "Favor avaliar!", Toast.LENGTH_SHORT).show();
            }
        });


        nota.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresso, boolean b) {
                //exibicaoNota.setText("Sua nota é: " + progresso);
                switch (progresso) {
                    case 1:
                        imagemNota.setImageResource(R.drawable.pouco);
                        break;
                    case 2:
                        imagemNota.setImageResource(R.drawable.medio);
                        break;
                    case 3:
                        imagemNota.setImageResource(R.drawable.muito);
                        break;
                    default:
                        break;
                }
                notaAvaliada = progresso;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(AvaliacaoActivity.this, "Clicou SeekBar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(AvaliacaoActivity.this, "Soltou SeekBar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
