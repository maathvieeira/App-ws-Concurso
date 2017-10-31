package br.com.matheusvieira.appconcursorainhadafenadoce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RainhaActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgRainha;
    private TextView txtNomeC;
    private TextView txtClubeC;
    private TextView txtIdadeC;
    private int rainha_id;
    private Button btnVoltar;
    private Button btnVotar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rainha);

        imgRainha = (ImageView) findViewById(R.id.imgRainha);
        txtNomeC = (TextView) findViewById(R.id.txtNomeC);
        txtClubeC = (TextView) findViewById(R.id.txtClubeC);
        txtIdadeC = (TextView) findViewById(R.id.txtIdadeC);
        btnVotar = (Button) findViewById(R.id.btnVotar);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String clube = intent.getStringExtra("clube");
        int idade = intent.getIntExtra("idade", -1);
        rainha_id = intent.getIntExtra("rainha_id", -1);

        Picasso.with(this).load("http://10.0.2.2/fenadoce/fotos/"+rainha_id+".jpg").into(imgRainha);
        txtNomeC.setText(nome);
        txtClubeC.setText(clube);
        txtIdadeC.setText(idade + " anos");

        btnVoltar.setOnClickListener(this);
        btnVotar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.btnVoltar) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        if(view.getId() == R.id.btnVotar){
            Intent intent = new Intent(this, VotarActivity.class);
            intent.putExtra("rainha_id", rainha_id);
            startActivity(intent);
        }
    }
}
