package coffsteria.com.br.coffsteria.utilitarios;

import android.util.Base64;

public class Base64Util {

    public static String encode(String valor) {
        return Base64.encodeToString(valor.getBytes(), Base64.DEFAULT)
                .replaceAll(("\\n|\\r"), "");
    }

    public static String decode(String valor) {
        return new String(Base64.decode(valor.getBytes(), Base64.DEFAULT));
    }
}
