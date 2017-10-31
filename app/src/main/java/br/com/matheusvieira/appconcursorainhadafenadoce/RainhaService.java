package br.com.matheusvieira.appconcursorainhadafenadoce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by android on 30/10/2017.
 */

public interface RainhaService {

    @GET("lista_rainhas.php")
    Call<List<Rainha>> getRainhas();

}
