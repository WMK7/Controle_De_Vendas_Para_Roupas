package com.example.controle_de_vendas_para_roupas;

public class Pedido {

    private String codigo;
    private String nome;
    private String cor;
    private String tamanho;
    private String quantidade;
    private String nomeCliente;
    private String telefone;
    private String situacao;

    public Pedido() {
        // Construtor vazio necessário para o Firebase
    }

    public Pedido(String codigo, String nome, String cor, String tamanho, String quantidade,
                  String nomeCliente, String telefone, String situacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.situacao = situacao;
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
