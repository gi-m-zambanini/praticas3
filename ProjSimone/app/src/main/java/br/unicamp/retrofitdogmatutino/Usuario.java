package br.unicamp.retrofitdogmatutino;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Usuario implements Serializable{
/*
        public int id {get;set;}
        public string nome {get;set;}
        public string email {get;set;}
        public string senha {get;set;}
        public string foto {get;set;}
*/
    @SerializedName("id")
    private Integer id;
    @SerializedName("nome")
    private String nome;
    @SerializedName("senha")
    private String senha;
    @SerializedName("foto")
    private String foto;


    public Usuario(Integer id, String nome,String senha,String foto){

        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.foto = foto;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
