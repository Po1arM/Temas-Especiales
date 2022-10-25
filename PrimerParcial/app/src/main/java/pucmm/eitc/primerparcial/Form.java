package pucmm.eitc.primerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import pucmm.eitc.primerparcial.databinding.ActivityMainBinding;

public class Form extends AppCompatActivity {

    private TextView articulo, descripcion, precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        articulo = (TextView) findViewById(R.id.articuloInput);
        descripcion = (TextView) findViewById(R.id.descriptionInput);
        precio = (TextView) findViewById(R.id.priceInput);
    }

    public void clearScreen(View view){
        articulo.setText("");
        descripcion.setText("");
        precio.setText("");
    }

    public void processInfo(View view){
        String articuloName = articulo.getText().toString();

        if(articuloName.equalsIgnoreCase("")){
            Toast.makeText(this, "Nombre de articulo vacio", Toast.LENGTH_SHORT).show();
            return;
        }
        String articuloDescripcion= descripcion.getText().toString();
        if(articuloDescripcion.equalsIgnoreCase("")){
            Toast.makeText(this, "Descripcion de articulo vacio", Toast.LENGTH_SHORT).show();
            return;
        }
        String articuloPrecio = precio.getText().toString();
        if(articuloPrecio.equalsIgnoreCase("")){
            Toast.makeText(this, "Precio de articulo vacio", Toast.LENGTH_SHORT).show();
            return;
        }
        MainActivity.layoutAdapter.notifyDataSetChanged();

        Articulo articulo = new Articulo(articuloName,articuloDescripcion,Integer.valueOf(articuloPrecio));
        MainActivity.articulos.add(articulo);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}