package com.example.appinventario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appinventario.MAIN_OPTIONS.Clientes;
import com.example.appinventario.MAIN_OPTIONS.usuarios;

public class menu extends AppCompatActivity {
    Button binventario;
    Button bvendedores;
    Button bventas;
    Button bclientes;
    Button buser;
    int grade ;
    @Override
    public void onBackPressed(){
        backf();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
        grade = Integer.parseInt(getIntent().getExtras().get("grade").toString());
        bclientes =  (Button) findViewById(R.id.clientes);
        bclientes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Clientes.class);
                intent.putExtra("grade",grade);
                startActivity(intent);
            }
        });
        bvendedores =  (Button) findViewById(R.id.vendedores);
        buser =  (Button) findViewById(R.id.user);
        buser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(grade<3) {
                    Intent intent = new Intent(getApplicationContext(), usuarios.class);
                    intent.putExtra("grade", grade);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Nivel de usuario insuficiente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void backf(){
        Intent intent = new Intent(getApplicationContext(), Main.class);
        startActivityForResult(intent,0);
        finish();
    }
}
