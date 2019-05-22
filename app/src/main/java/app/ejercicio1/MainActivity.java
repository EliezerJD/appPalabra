package app.ejercicio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void analizar(View view) {
        final TextView palabra = findViewById(R.id.txt_palabra);

        final TextView res_inversa = findViewById(R.id.res_inversa);
        final TextView res_coincidentes = findViewById(R.id.res_coincidentes);

        String palabra_analizar = palabra.getText().toString();

        calcularPalindromo(palabra_analizar);
        calcularLongitud(palabra_analizar);
        calcularDuplicadas(palabra_analizar);

    }

    public void calcularPalindromo(String palabra){
        final TextView res_palindromo = findViewById(R.id.res_palindromo);
        final TextView res_inversa = findViewById(R.id.res_inversa);
        String inversa = calcularInversa(palabra);
        if(inversa.equals(palabra)){
            res_palindromo.setText("True");
        }else{
            res_palindromo.setText("False");
        }
        res_inversa.setText(inversa);
    }

    public void calcularLongitud(String palabra){
        final TextView res_longitud = findViewById(R.id.res_longitud);
        int longitud = palabra.length();
        res_longitud.setText(longitud+"");
    }

    public String calcularInversa(String palabra){
        String palabra_inversa = "";
        for (int x=palabra.length()-1;x>=0;x--) {
            palabra_inversa = palabra_inversa + palabra.charAt(x);
        }
        return palabra_inversa;
    }

    public void calcularDuplicadas (String palabra){
        final TextView res_coincidentes = findViewById(R.id.res_coincidentes);

        char [] array = palabra.toCharArray();
        char indice = 0;
        char repetida = 0;
        int contadores[]= new int[array.length];
        for(int d =0; d< contadores.length; d++){
            contadores[d]= 0;
        }

        for(int i=0;i< array.length;i++) {
            indice = array[i];

            int contador = 0;
            for (int x=0;x< array.length;x++){
                if(x!=i){
                    if(indice==array[x]){

                        contador ++;
                        contadores[i] = contador;
                    }
                }
            }
        }
        int mayor = 0;
        int pos = 0;
        for(int z = 0; z<contadores.length; z++){

            if(contadores[z]>mayor){
                mayor = contadores[z];
                pos = z;

            }
        }

        char respuesta = palabra.charAt(pos);

        res_coincidentes.setText(respuesta+"");




    }
    
    

}
