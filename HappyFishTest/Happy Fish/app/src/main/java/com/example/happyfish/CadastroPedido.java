package com.example.happyfish;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroPedido extends AppCompatActivity {

    private EditText etNomeCliente;
    private TextView tvPeixe;
    private ListView lvPeixe;
    private EditText etKgPeixe;
    private Button btSalvarPedido;
    private String[] listaPeixe = {"TRAÍRA", "BAIACU ARARA", "PINTADO", "CORVINA", "LAMBARÍ",
            "TAMBAQUI", "TILÁPIA", "CARPA", "PEIXE-CACHORRO", "BAGRE AMARELO", "PIAU",
            "CASCUDO", "DOURADO", "CURIMATÃ", "TUVIRA"};
    String peixeClicado;
    // Nome do Cliente */
    String nomeCliente;
    String nomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pedido);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Cadastrar Pedido");
        }

        etNomeCliente = findViewById(R.id.etNomeCliente);
        tvPeixe = findViewById(R.id.tvPeixe);
        lvPeixe = findViewById(R.id.lvPeixe);
        etKgPeixe = findViewById(R.id.etKgPeixe);
        btSalvarPedido = findViewById(R.id.btSalvarPedido);

        final Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            if (bundle.getString("nome") != null) {
                nomeUsuario = bundle.getString("nome");
            }
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listaPeixe

        );


        lvPeixe.setAdapter(adaptador);

        lvPeixe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item selecionado: " + listaPeixe[position], Toast.LENGTH_SHORT).show();

                peixeClicado = lvPeixe.getItemAtPosition(position).toString();
            }
        });


        btSalvarPedido.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (etKgPeixe.getText().toString().isEmpty() || etNomeCliente.getText().toString().isEmpty()) {
                    Toast.makeText(CadastroPedido.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else {
                    if (peixeClicado != null) {

                        //Cria o gerador do AlertDialog
                        AlertDialog.Builder dialogICMS = new AlertDialog.Builder(CadastroPedido.this);
                        //define o titulo
                        dialogICMS.setTitle("Salvar");
                        //define a mensagem
                        dialogICMS.setMessage("Deseja realmente salvar?");
                        //define um botão como positivo
                        dialogICMS.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(CadastroPedido.this, "Salvo com sucesso " + "\n" + "Nome do cliente " + etNomeCliente.getText().toString()
                                        + "\n" + etKgPeixe.getText().toString() + "kg" + "\nde peixe " + peixeClicado, Toast.LENGTH_SHORT).show();
                                // Salvando o nome do cliente */
                                nomeCliente = etNomeCliente.getText().toString();
                            }
                        });
                        //define um botão como negativo.
                        dialogICMS.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(CadastroPedido.this, "Operação cancelada", Toast.LENGTH_SHORT).show();
                            }
                        });
                        //cria o AlertDialog
                        dialogICMS.create();
                        //Exibe
                        dialogICMS.show();
                        //Desabilitar o clique fora
                        dialogICMS.setCancelable(false);


                    } else {
                        Toast.makeText(getApplicationContext(), "Insira o Peixe Desejado!", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });


    }

    // Metodo executado quando o usuário preciona o botão de voltar */
    @Override
    public void onBackPressed() {
            Intent intent = new Intent(this, MenuPrincipal.class);
            if (nomeCliente != null){
                // putExtra do nome do cliente */
                intent.putExtra("NomeCliente", nomeCliente);
            }
            // putExtra do nome de usuario */
            if (nomeUsuario != null){
                intent.putExtra("nome", nomeUsuario);
            }
            // Inicia a activity */
            startActivity(intent);
            // Destroi a activity */
            finish();

    }
}
