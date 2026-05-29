package br.edu.atitus.camila_campos.zoo_digital.animais;

import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Predacao;
import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Voo;
import br.edu.atitus.camila_campos.zoo_digital.especies.Ave;

public class Aguia extends Ave implements Voo, Predacao {

    public Aguia(String nome, Integer idade) {
        super(nome, idade, "Marrom");
    }

    @Override
    public void comer() {
        this.comer("pequenos mamíferos e peixes");
    }

    @Override
    public void emitirSom() {
        IO.println(getNome() + " está grasnando");
    }

    @Override
    public void voar() {
        IO.println(getNome() + " está voando em altas altitudes");
    }

    @Override
    public void cacar() {
        IO.println(getNome() + " está mergulhando em alta velocidade para capturar sua presa");
    }
}