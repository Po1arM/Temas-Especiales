package pucmm.eitc.intents_and_permissions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Permissions extends AppCompatActivity {

    String[] permissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        Intent intent = getIntent();
        permissions = intent.getStringArrayExtra("Permissions");
        requestPermissions(permissions,200);
    }
    /*Una funcion que lea todos los permisos que se han otorgado y los asigne a un arreglo*/

    /*Una funcion que al presionar un boton indique si se cuenta con el permiso o no a traves de un toast
    * Si el permiso esta activo, tiene que mostrar un boton para abrir esa aplicacion
    * Al presionar abrir, se debe crear un intent a esa aplicacion*/
}