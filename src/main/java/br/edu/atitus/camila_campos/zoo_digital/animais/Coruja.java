package br.edu.atitus.camila_campos.zoo_digital.animais;

import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Predacao;
import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Voo;
import br.edu.atitus.camila_campos.zoo_digital.especies.Ave;

public class Coruja extends Ave implements Voo, Predacao {

    public Coruja(String nome, Integer idade) {
        super(nome, idade, "Marrom e Branco");
    }

    @Override
    public void comer() {
        this.comer("roedores e insetos");
    }

    @Override
    public void emitirSom() {
        IO.println(getNome() + " está piando");
    }

    @Override
    public void voar() {
        IO.println(getNome() + " está voando silenciosamente à noite");
    }

    @Override
    public void cacar() {
        IO.println(getNome() + " está caçando à noite com sua visão aguçada");
    }
}