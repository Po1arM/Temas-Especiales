package pucmm.eitc.intents_and_permissions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch storageSwitch, locationSwitch, cameraSwitch, phoneSwitch, contacSwitch;
    private final String[] perms = {"android.permission.ACCESS_FINE_LOCATION",
                                "android.permission.CAMERA","android.permission.READ_EXTERNAL_STORAGE",
                                "android.permission.CALL_PHONE","android.permission.READ_CONTACTS"};

    private final int requestCode = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storageSwitch = (Switch) findViewById(R.id.storageSwitch);
        locationSwitch = (Switch) findViewById(R.id.locationSwitch);
        cameraSwitch = (Switch) findViewById(R.id.cameraSwitch);
        phoneSwitch = (Switch) findViewById(R.id.phoneSwitch);
        contacSwitch = (Switch) findViewById(R.id.contactsSwitch);

        checkGranted();
    }

    private void checkGranted(){
        Arrays.asList(perms)
                .forEach(perm -> {
                    if(checkSelfPermission(perm) == PackageManager.PERMISSION_GRANTED){
                        switch (perm) {
                            case "android.permission.ACCESS_FINE_LOCATION":
                                locationSwitch.setChecked(true);
                                break;
                            case "android.permission.CAMERA":
                                cameraSwitch.setChecked(true);
                                break;
                            case "android.permission.READ_EXTERNAL_STORAGE":
                                storageSwitch.setChecked(true);
                                break;
                            case "android.permission.CALL_PHONE":
                                phoneSwitch.setChecked(true);
                                break;
                            case "android.permission.READ_CONTACTS":
                                contacSwitch.setChecked(true);
                                break;
                        }
                    }
                });
    }

    public void alreadyGranted(View view){
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch aux = (Switch) view;
        String name = aux.getResources().getResourceName(aux.getId());
        switch (name) {
            case "pucmm.eitc.intents_and_permissions:id/storageSwitch":
                if(checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == PackageManager.PERMISSION_GRANTED){
                    aux.setChecked(true);
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                }
                break;
            case "pucmm.eitc.intents_and_permissions:id/locationSwitch":
                if(checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == PackageManager.PERMISSION_GRANTED){
                    aux.setChecked(true);
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                }
                break;
            case "pucmm.eitc.intents_and_permissions:id/cameraSwitch":
                if(checkSelfPermission("android.permission.CAMERA") == PackageManager.PERMISSION_GRANTED){
                    aux.setChecked(true);
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                }
                break;
            case "pucmm.eitc.intents_and_permissions:id/phoneSwitch":
                if(checkSelfPermission("android.permission.CALL_PHONE") == PackageManager.PERMISSION_GRANTED){
                    aux.setChecked(true);
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                }
                break;
            case "pucmm.eitc.intents_and_permissions:id/contactsSwitch":
                if(checkSelfPermission("android.permission.READ_CONTACTS") == PackageManager.PERMISSION_GRANTED){
                    aux.setChecked(true);
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    public void checkedSwitches(View view){
        ArrayList<String> permsToCheck = new ArrayList<String>();
        if(storageSwitch.isChecked()){
            permsToCheck.add("android.permission.READ_EXTERNAL_STORAGE");
        }
        if(locationSwitch.isChecked()){
            permsToCheck.add("android.permission.ACCESS_FINE_LOCATION");
        }
        if(cameraSwitch.isChecked()){
            permsToCheck.add("android.permission.CAMERA");
        }
        if(phoneSwitch.isChecked()){
            permsToCheck.add("android.permission.CALL_PHONE");
        }
        if(contacSwitch.isChecked()){
            permsToCheck.add("android.permission.READ_CONTACTS");
        }
        String[] aux = permsToCheck.toArray(new String[0]);

        Intent intent = new Intent(this, Permissions.class);
        intent.putExtra("Permissions", aux);
        startActivity(intent);

    }

    public void closeApp(View view){
        finish();
        System.exit(0);
    }
}