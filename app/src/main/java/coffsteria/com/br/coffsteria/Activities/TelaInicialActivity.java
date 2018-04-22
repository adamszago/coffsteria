package coffsteria.com.br.coffsteria.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import coffsteria.com.br.coffsteria.R;

public class TelaInicialActivity extends AppCompatActivity {

    private String[] itens  = {"Bebidas", "Pratos", "Lojas", "Avaliação"};
    private ListView opcoes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        opcoes = (ListView) findViewById(R.id.listaOpcoes);

        //TRABALHA COMO UM ADAPTADOR PARA O TIPO ARRAY, JÁ QUE NÃO PODEMOS USA-LO DIRETAMENTE COM LISTVIEW
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this
                , android.R.layout.simple_list_item_1
                , android.R.id.text1
                , itens);

        opcoes.setAdapter(arrayAdapter);

        opcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {
                String opcaoEscolhida = opcoes.getItemAtPosition(posicao).toString();
                switch (opcaoEscolhida) {
                    case "Bebidas" :
                        startActivity(new Intent(TelaInicialActivity.this, CategoriaBebidasActivity.class));
                        break;
                    case "Pratos" :
                        startActivity(new Intent());
                        break;
                    case "Lojas" :
                        startActivity(new Intent());
                        break;
                    case "Avaliação" :
                        startActivity(new Intent(TelaInicialActivity.this, AvaliacaoActivity.class));
                        break;
                    default:
                        Toast.makeText(TelaInicialActivity.this, "Opção inválida", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
