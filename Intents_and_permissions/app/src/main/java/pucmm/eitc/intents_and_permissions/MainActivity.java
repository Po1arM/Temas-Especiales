package pucmm.eitc.intents_and_permissions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

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

    public void prueba(View view){
        Switch aux = (Switch) view;
        String name = aux.getResources().getResourceName(aux.getId());
        System.out.println("\n" + name);
        if(name.equalsIgnoreCase("pucmm.eitc.intents_and_permissions:id/storageSwitch")){
            aux.setChecked(true);
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