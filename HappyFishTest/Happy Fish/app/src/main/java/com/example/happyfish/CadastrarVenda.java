package com.example.happyfish;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ResourceBundle;

public class CadastrarVenda extends AppCompatActivity {

    private EditText etVenda;
    private Button btVenda;
    private String valores;
    private String nomeCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_venda);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setTitle("Cadastrar Venda");
        }

        final Bundle bundle = getIntent().getExtras();
        // Verifica a nulabilidade do bundle */
        if (bundle != null){
            valores = bundle.getString("valores");
            // Verifica se tem um nome do cliente */
            if (bundle.getString("NomeCliente") != null){
                // Recuperando nome do cliente */
                nomeCliente = bundle.getString("NomeCliente");
            }
        }

        etVenda = findViewById(R.id.etVenda);
        btVenda = findViewById(R.id.btVenda);








        btVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etVenda.getText().toString().isEmpty()){
                    Toast.makeText(CadastrarVenda.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }else {
                    //Cria o gerador do AlertDialog
                    AlertDialog.Builder dialogICMS = new AlertDialog.Builder(CadastrarVenda.this);
                    //define o titulo
                    dialogICMS.setTitle("Salvar");
                    //define a mensagem
                    dialogICMS.setMessage("Deseja realmente salvar?");
                    //define um botão como positivo
                    dialogICMS.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            // Verifica se tem algum cliente com pedido */
                            if (nomeCliente != null){
                                Toast.makeText(CadastrarVenda.this, "Salvo com sucesso "+"\nFuncionário: " + etVenda.getText().toString()+"\nCliente: "+ nomeCliente , Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Cadastre primeiro um pedido", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    //define um botão como negativo.
                    dialogICMS.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(CadastrarVenda.this, "Operação cancelada", Toast.LENGTH_SHORT).show();
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
