package br.com.matheusvieira.appconcursorainhadafenadoce;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class VotarActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgRainhaP;
    private EditText edtNome;
    private EditText edtEmail;
    private Button btnEnviar;
    private int rainha_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votar);

        imgRainhaP = (ImageView) findViewById(R.id.imgRainhaP);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);

        Intent intent = getIntent();
        rainha_id = intent.getIntExtra("rainha_id", -1);

        Picasso.with(this).load("http://10.0.2.2/fenadoce/fotos/"+rainha_id+".jpg").into(imgRainhaP);
    }

    @Override
    public void onClick(View view) {

    }
}
