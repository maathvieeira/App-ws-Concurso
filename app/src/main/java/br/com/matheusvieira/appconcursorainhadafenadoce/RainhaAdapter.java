package br.com.matheusvieira.appconcursorainhadafenadoce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by android on 30/10/2017.
 */

public class RainhaAdapter extends BaseAdapter {

    private Context ctx;
    private List<Rainha> rainhas;
    private String pathFotos;

    public RainhaAdapter(Context ctx, List<Rainha> rainhas, String pathFotos) {
        this.ctx = ctx;
        this.rainhas = rainhas;
        this.pathFotos = pathFotos;
    }

    @Override
    public int getCount() {
        return rainhas.size();
    }

    @Override
    public Object getItem(int i) {
        return rainhas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Rainha rainha = rainhas.get(i);

        View linha = LayoutInflater.from(ctx).inflate(R.layout.item_rainha, null);

        ImageView imgFoto = (ImageView) linha.findViewById(R.id.imgFoto);
        TextView txtNome = (TextView) linha.findViewById(R.id.txtNome);
        TextView txtClube = (TextView) linha.findViewById(R.id.txtClube);
        TextView txtIdade = (TextView) linha.findViewById(R.id.txtIdade);

        Picasso.with(ctx).load(pathFotos+rainha.getId()+".jpg").into(imgFoto);
        txtNome.setText("Nome: "+rainha.getNome());
        txtClube.setText("Clube: "+rainha.getClube());
        txtIdade.setText("Idade: "+rainha.getIdade());

        return linha;
    }
}
