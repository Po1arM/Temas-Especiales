package pucmm.eitc.room_livedata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pucmm.eitc.room_livedata.databinding.ActivityFormBinding;
import pucmm.eitc.room_livedata.databinding.ActivityMainBinding;

public class FormActivity extends AppCompatActivity {

    private TextView articulo, descripcion, precio;
    private ActivityFormBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        articulo = binding.nameInput;
        descripcion = binding.descriptionInput;
        precio = binding.priceInput;
    }

    public void clearScreen(View view){
        articulo.setText("");
        descripcion.setText("");
        precio.setText("");
    }

    @SuppressLint("NotifyDataSetChanged")
    public void processInfo(View view){
        String articuloName = articulo.getText().toString();

        if(articuloName.equalsIgnoreCase("")){
            Toast.makeText(this, "Nombre de articulo vacio", Toast.LENGTH_SHORT).show();
            return;
        }
        String articuloDescripcion = descripcion.getText().toString();
        if(articuloDescripcion.equalsIgnoreCase("")){
            Toast.makeText(this, "Descripcion de articulo vacio", Toast.LENGTH_SHORT).show();
            return;
        }
        String articuloPrecio = precio.getText().toString();
        if(articuloPrecio.equalsIgnoreCase("")){
            Toast.makeText(this, "Precio de articulo vacio", Toast.LENGTH_SHORT).show();
            return;
        }

        Product articulo = new Product(articuloDescripcion, articuloName, Integer.parseInt(articuloPrecio));
        MainActivity.products.add(articulo);
        MainActivity.layoutAdapter.notifyDataSetChanged();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}