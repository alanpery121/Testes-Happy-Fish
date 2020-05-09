package com.example.happyfish;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CadastrarICMS extends AppCompatActivity {

    private EditText etICMS;
    private EditText etEstado;
    private Button btSalvarICMS;
    private AlertDialog dialogICMS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_i_c_m_s);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Cadastrar ICMS");
        }

        etICMS = findViewById(R.id.etICMS);
        etEstado = findViewById(R.id.etEstado);
        btSalvarICMS = findViewById(R.id.btSalvarICMS);

        btSalvarICMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etICMS.getText().toString().isEmpty() || etEstado.getText().toString().isEmpty()){
                    Toast.makeText(CadastrarICMS.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }else {
                    //Cria o gerador do AlertDialog
                    AlertDialog.Builder dialogICMS = new AlertDialog.Builder(CadastrarICMS.this);
                    //define o titulo
                    dialogICMS.setTitle("Salvar");
                    //define a mensagem
                    dialogICMS.setMessage("Deseja realmente salvar?");
                    //define um botão como positivo
                    dialogICMS.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(CadastrarICMS.this, "Salvo com sucesso " + "\n" + "O estado " + etEstado.getText().toString() + " tem uma aliquota de  " + etICMS.getText().toString() + "%", Toast.LENGTH_SHORT).show();
                        }
                    });
                    //define um botão como negativo.
                    dialogICMS.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(CadastrarICMS.this, "Operação cancelada", Toast.LENGTH_SHORT).show();
                        }
                    });
                    //cria o AlertDialog
                    dialogICMS.create();
                    //Exibe
                    dialogICMS.show();
                    //Desabilitar o clique fora
                    dialogICMS.setCancelable(false);



                }


            }
        });






    }
}
