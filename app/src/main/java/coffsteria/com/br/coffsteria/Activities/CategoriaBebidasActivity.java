package coffsteria.com.br.coffsteria.Activities;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import coffsteria.com.br.coffsteria.geradores.Bebida;

public class CategoriaBebidasActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listaBebidas = getListView();

        ArrayAdapter adaptadorLista = new ArrayAdapter(this
                , android.R.layout.simple_list_item_1
                , Bebida.bebidas);

        listaBebidas.setAdapter(adaptadorLista);
        listaBebidas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CategoriaBebidasActivity.this
                        , BebidasActivity.class);
                intent.putExtra(BebidasActivity.EXTRA_BEBIDA, (int) l);
                startActivity(intent);
            }
        });
    }


}
