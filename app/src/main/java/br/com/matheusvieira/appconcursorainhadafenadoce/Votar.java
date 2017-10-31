package br.com.matheusvieira.appconcursorainhadafenadoce;

/**
 * Created by android on 30/10/2017.
 */

public class Votar {

    private int id;
    private String nome;
    private String email;
    private int rainha_id;

    public Votar(int id, String nome, String email, int rainha_id) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.rainha_id = rainha_id;
    }

    public int getId() {
        return id;
    }
}
