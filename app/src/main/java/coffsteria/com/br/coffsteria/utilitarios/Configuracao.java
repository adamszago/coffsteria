package coffsteria.com.br.coffsteria.utilitarios;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by adams on 12/11/2017.
 */

public final class Configuracao {

    private static DatabaseReference firebaseReferencia;
    //private static FirebaseAuth autenticadorReferencia;

    public static DatabaseReference obterReferenciaFirebase(){
        if (firebaseReferencia == null) {
            firebaseReferencia = FirebaseDatabase.getInstance().getReference();
        }
        return firebaseReferencia;
    }

    /*public static FirebaseAuth obterAutenticadorFirebase(){
        if (autenticadorReferencia == null) {
            autenticadorReferencia = FirebaseAuth.getInstance();
        }
        return autenticadorReferencia;
    }*/
}
