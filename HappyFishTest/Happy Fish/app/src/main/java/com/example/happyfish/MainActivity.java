package com.example.happyfish;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etSenha;
    private EditText ptUsuario;
    private Button btEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSenha = findViewById(R.id.etSenha);
        ptUsuario = findViewById(R.id.ptUsuario);
        btEntrar = findViewById(R.id.btEntrar);

        btEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ptUsuario.getText().toString().isEmpty() || etSenha.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
                    intent.putExtra("nome", ptUsuario.getText().toString());
                    intent.putExtra("senha", etSenha.getText().toString());
                    startActivity(intent);
                    // Correção */
                    finish();
                }
            }
        });


    }
}

