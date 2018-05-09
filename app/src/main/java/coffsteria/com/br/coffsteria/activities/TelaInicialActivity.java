package coffsteria.com.br.coffsteria.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import coffsteria.com.br.coffsteria.R;
import coffsteria.com.br.coffsteria.dominio.Categoria;
import coffsteria.com.br.coffsteria.utilitarios.Configuracao;

public class TelaInicialActivity extends AppCompatActivity {

    private DatabaseReference referenciaCategoria = Configuracao.obterReferenciaFirebase().child("categorias");
    private String[] itens  = {"Bebidas", "Pratos", "Lojas", "Avaliação"};
    private ArrayList<String> categorias = new ArrayList<String>();
    private ListView opcoes;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Coffsteria");
        setSupportActionBar(toolbar);

        opcoes = (ListView) findViewById(R.id.listaOpcoes);

        referenciaCategoria.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("Categoria", dataSnapshot.getValue().toString());
                for (DataSnapshot ds : dataSnapshot.getChildren())
                {
                    String cat = ds.getValue(Categoria.class).getNome();
                    categorias.add(cat);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

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
                        return;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sair_id :
                //TODO CHAMAR METODO DE SAIDA
                return true;
            case R.id.config :
                return true;
            case R.id.item_pesquisa:
                //TODO CHAMAR METODO DE PESQUISA
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

}
