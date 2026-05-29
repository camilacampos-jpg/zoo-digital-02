package br.edu.atitus.camila_campos.zoo_digital.animais;

import br.edu.atitus.camila_campos.zoo_digital.especies.Reptil;

public class Camaleao extends Reptil {

    public Camaleao(String nome, Integer idade) {
        super(nome, idade, false);
    }

    @Override
    public void comer() {
        this.comer("insetos e pequenos invertebrados");
    }

    @Override
    public void emitirSom() {
        IO.println(getNome() + " está fazendo um leve sibilo");
    }

    public void mudarCor() {
        IO.println(getNome() + " está mudando de cor para se camuflar");
    }
}