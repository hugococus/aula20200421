/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/**
 *
 * @author hugoc
 */
public class Pessoa {
    int id;
    String nome;
    String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void relatorio() {
        System.out.println("id:" + this.id + " Nome: " + this.nome + " Cpf: " + this.cpf);
    }
}
