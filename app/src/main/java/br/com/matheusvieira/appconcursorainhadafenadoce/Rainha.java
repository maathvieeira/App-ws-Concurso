package br.com.matheusvieira.appconcursorainhadafenadoce;

/**
 * Created by Matheus Vieira on 30/10/2017.
 */

public class Rainha {

    private int id;
    private String nome;
    private String clube;
    private int idade;

    public Rainha(int id, String nome, String clube, int idade) {
        this.id = id;
        this.nome = nome;
        this.clube = clube;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClube() {
        return clube;
    }

    public void setClube(String clube) {
        this.clube = clube;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


}
