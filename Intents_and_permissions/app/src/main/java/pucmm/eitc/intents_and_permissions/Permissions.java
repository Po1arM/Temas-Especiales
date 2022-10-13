package pucmm.eitc.intents_and_permissions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Permissions extends AppCompatActivity {

    String[] permissions;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        Intent intent = getIntent();
        permissions = intent.getStringArrayExtra("Permissions");
        requestPermissions(permissions,200);


    }

    public void openApp(View view){
        TextView aux = (TextView) view;
        String name = aux.getText().toString();
        Snackbar snack = Snackbar.make(view,"Permission granted",Snackbar.LENGTH_LONG);
        Toast toast = Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT);
        switch (name) {
            case "STORAGE":
                if(checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == PackageManager.PERMISSION_GRANTED){
                    snack.setAction("Open", listener -> {
                        Intent storageIntent = new Intent(Intent.ACTION_GET_CONTENT);
                        storageIntent.setType("file/*");
                        startActivity(storageIntent);
                    });
                    snack.show();
                }else{
                    toast.show();
                }
                break;
            case "LOCATION":
                if(checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == PackageManager.PERMISSION_GRANTED){
                    snack.setAction("Open", listener -> {
                                Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                            startActivity(mapIntent);
                    });
                    snack.show();
                }else{
                    toast.show();
                }
                break;
            case "CAMERA":
                if(checkSelfPermission("android.permission.CAMERA") == PackageManager.PERMISSION_GRANTED){
                    snack.setAction("Open", listener ->{
                        Intent cameraIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                        startActivity(cameraIntent);
                    });
                    snack.show();
                }else{
                    toast.show();
                }
                break;
            case "PHONE":
                if(checkSelfPermission("android.permission.CALL_PHONE") == PackageManager.PERMISSION_GRANTED){
                    snack.setAction("Open", listener ->{
                        Uri number = Uri.parse("tel:5551234");
                        Intent callIntent = new Intent(Intent.ACTION_CALL, number);
                        startActivity(callIntent);
                    });
                    snack.show();
                }else{
                    toast.show();
                }
                break;
            case "CONTACTS":
                if(checkSelfPermission("android.permission.READ_CONTACTS") == PackageManager.PERMISSION_GRANTED){
                    snack.setAction("Open", listener ->{
                        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                        startActivity(intent);
                    });
                    snack.show();
                }else{
                    toast.show();
                }
                break;
        }
    }

    /*Una funcion que lea todos los permisos que se han otorgado y los asigne a un arreglo*/

    /*Una funcion que al presionar un boton indique si se cuenta con el permiso o no a traves de un toast
    * Si el permiso esta activo, tiene que mostrar un boton para abrir esa aplicacion
    * Al presionar abrir, se debe crear un intent a esa aplicacion*/
}