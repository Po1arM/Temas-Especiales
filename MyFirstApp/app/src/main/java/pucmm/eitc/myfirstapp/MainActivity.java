package pucmm.eitc.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView name, lastName, birthDay;
    private Spinner dropDown;
    private RadioGroup radioGroup;
    private RadioButton likesProgramming;
    private CheckBox java, python, js, goLand, c, cSharp;
    DatePickerDialog datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView) findViewById(R.id.inputName);
        lastName = (TextView) findViewById(R.id.inputLastName);
        birthDay = (TextView) findViewById(R.id.dateInput);

        radioGroup = (RadioGroup) findViewById(R.id.inputLikeDevelopment);
        likesProgramming = (RadioButton) findViewById(R.id.radioYes);
        likesProgramming.setChecked(true);

        java = (CheckBox) findViewById(R.id.checkJava);
        python = (CheckBox) findViewById(R.id.checkPy);
        js = (CheckBox) findViewById(R.id.checkJS);
        goLand = (CheckBox) findViewById(R.id.checkGo);
        c = (CheckBox) findViewById(R.id.checkC);
        cSharp = (CheckBox) findViewById(R.id.checkCSharp);

        //Agregando información al dropdow
        dropDown = findViewById(R.id.genreMenu);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.generos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        dropDown.setAdapter(adapter);
    }

    public void sendMessage(View view){
        //Agregar verificación nombre y apellido
        //Si están vacios poner un mensajito que diga que son necesario
        //Seria bueno verificar si tiene caracteres no alfabeticos
        String nameValue = name.getText().toString();
        if(nameValue.isEmpty()){
            Toast.makeText(getApplicationContext(),"Nombre vacio...",Toast.LENGTH_LONG).show();
            return;
        }

        String lastNameValue = lastName.getText().toString();
        if(lastNameValue.isEmpty()){
            Toast.makeText(getApplicationContext(),"Apellido vacio...",Toast.LENGTH_LONG).show();
            return;
        }

        String genre = dropDown.getSelectedItem().toString();

        //Verificar la fecha que sea mayor a una en especifico, tal vez 10 años
        String birth = birthDay.getText().toString();
        if(birth.equalsIgnoreCase("Seleccione una fecha...")){
            Toast.makeText(getApplicationContext(),"Fecha invalida...",Toast.LENGTH_LONG).show();
            return;
        }

        likesProgramming = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("PRESENTACION_1","Hola!, mi nombre es: " + nameValue + " " + lastNameValue);
        intent.putExtra("PRESENTACION_2","Soy " + genre + ", y naci en fecha " + birth);

        if(likesProgramming.getText().toString().equalsIgnoreCase("Si")) {
            String langs = checkLangs();
            if (langs.equalsIgnoreCase("")){
                return;
            }else {
                intent.putExtra("PRESENTACION_3","Me gusta programar. Mis lenguajes favoritos son: " + langs);
            }
        }else{
            intent.putExtra("PRESENTACION_3","No me gusta programar.");
        }

        startActivity(intent);
    }

    public void activateLangs(View view){
        //Poner todos los lenguajes en activo
        java.setClickable(true);
        python.setClickable(true);
        js.setClickable(true);
        goLand.setClickable(true);
        c.setClickable(true);
        cSharp.setClickable(true);
    }

    public void deactivateLangs(View view){
        //Poner todos los lenguajes en desactivados y si están en check desactivarlos
        java.setChecked(false);
        java.setClickable(false);

        python.setChecked(false);
        python.setClickable(false);

        js.setChecked(false);
        js.setClickable(false);

        goLand.setChecked(false);
        goLand.setClickable(false);

        c.setChecked(false);
        c.setClickable(false);

        cSharp.setChecked(false);
        cSharp.setClickable(false);

    }

    public void showCalendar(View view){
        final Calendar calendar = Calendar.getInstance();
        //Definir el día de hoy
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                birthDay.setText(day + " / " + month + " / " + year);
            }
        },year, month, day);
        datePicker.show();
    }

    public void cleanScreen(View view){
        name.setText("");
        lastName.setText("");
        birthDay.setText("Seleccione una fecha...");

        dropDown.setSelection(0);

        likesProgramming = (RadioButton) findViewById(R.id.radioYes);
        likesProgramming.setChecked(true);

        java.setChecked(false);
        python.setChecked(false);
        js.setChecked(false);
        goLand.setChecked(false);
        c.setChecked(false);
        cSharp.setChecked(false);
    }

    //Revisar cuales son los lenguajes seleccionados y agregarlos a un string para ser mostrados
    private String checkLangs(){
        String response = "";
        if(java.isChecked()) {
            response += "Java, ";
        }

        if(python.isChecked()){
            response += "Python, ";
        }

        if(js.isChecked()){
            response += "JavaScript, ";
        }

        if(goLand.isChecked()){
            response += "Go Land, ";
        }

        if(c.isChecked()){
            response += "C/C++, ";
        }

        if(cSharp.isChecked()){
            response += "C#, ";
        }
        int i = response.length() - 2;
        if(i + 2 == 0){
            Toast.makeText(getApplicationContext(),"Debe seleccionar al menos un lenguaje",Toast.LENGTH_LONG).show();
            return "";
        }
        return response.substring(0,i);
    }
}