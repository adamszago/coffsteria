package coffsteria.com.br.coffsteria.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import coffsteria.com.br.coffsteria.R;

public class AvaliacaoActivity extends AppCompatActivity {


    private SeekBar nota;
    private TextView exibicaoNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);

        nota = (SeekBar) findViewById(R.id.seekAval);
        exibicaoNota = (TextView) findViewById(R.id.txtNota);

        nota.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresso, boolean b) {
                exibicaoNota.setText("Sua nota é: " + progresso);
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
