package coffsteria.com.br.coffsteria.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import coffsteria.com.br.coffsteria.R;
import coffsteria.com.br.coffsteria.dominio.Categoria;
import coffsteria.com.br.coffsteria.utilitarios.Base64Util;

public class CadastroCategoriaActivity extends AppCompatActivity {

    private EditText nomeCategoria;
    private Button cadastrarCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_categoria);

        nomeCategoria = (EditText) findViewById(R.id.txtCategoria);
        cadastrarCategoria = (Button) findViewById(R.id.btnCadastrar);

        cadastrarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nomeCategoria.getText().equals(null)) {
                    Categoria categoria = new Categoria();
                    categoria.setNome(nomeCategoria.getText().toString());
                    categoria.setId(Base64Util.encode(categoria.getNome()));
                    categoria.salvarCategoria();
                    nomeCategoria.setText(null);
                    Toast.makeText(CadastroCategoriaActivity.this, "Categoria cadastrada com sucesso!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(CadastroCategoriaActivity.this, "Favor informar um nome para categoria!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
