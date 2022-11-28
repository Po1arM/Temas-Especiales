package pucmm.eitc.primerparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import pucmm.eitc.primerparcial.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FloatingActionButton addBtn;
    public static ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    RecyclerView recyclerView;
    public static LayoutAdapter layoutAdapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0; i < 5; i++){
            Articulo aux = new Articulo("Producto " + i, "Producto " + i, i * 10);
            articulos.add(aux);
        }
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.recycler;

        layoutAdapter = new LayoutAdapter(this, articulos);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(layoutAdapter);
    }

    public void callForm(View view){
        Intent intent = new Intent(this,Form.class);
        startActivity(intent);
    }
}