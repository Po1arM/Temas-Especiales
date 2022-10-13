package pucmm.eitc.practicasclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String[] perms = {"android.permission.CAMERA","android.permission.ACCESS_FINE_LOCATION"};
    int requestCode = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void _checkPermission(View view){
        Arrays.asList(perms).forEach(perm -> {
            if(checkSelfPermission(perm) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{perm},requestCode);
            }

        });
    }
}