package br.com.matheusvieira.appconcursorainhadafenadoce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvCandidatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCandidatas = (ListView) findViewById(R.id.lvCandidatas);

        lvCandidatas.setOnItemClickListener(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/fenadoce/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RainhaService service = retrofit.create(RainhaService.class);

        Call<List<Rainha>> rainhas = service.getRainhas();

        rainhas.enqueue(new Callback<List<Rainha>>() {
            @Override
            public void onResponse(Call<List<Rainha>> call, Response<List<Rainha>> response) {
                if(response.isSuccessful()){
                    List<Rainha> listaRainhas = response.body();

                    RainhaAdapter adapter = new RainhaAdapter(getApplicationContext(),
                            listaRainhas, "http://10.0.2.2/fenadoce/fotos/");

                    lvCandidatas.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Rainha>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Rainha rainha = (Rainha)adapterView.getItemAtPosition(i);

        Intent intent = new Intent(this, RainhaActivity.class);
        intent.putExtra("nome", rainha.getNome());
        intent.putExtra("clube", rainha.getClube());
        intent.putExtra("idade", rainha.getIdade());
        intent.putExtra("rainha_id", rainha.getId());
        startActivity(intent);

    }
}
