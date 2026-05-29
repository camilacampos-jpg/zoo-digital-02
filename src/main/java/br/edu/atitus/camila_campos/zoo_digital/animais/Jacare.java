package br.edu.atitus.camila_campos.zoo_digital.animais;

import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Nado;
import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Predacao;
import br.edu.atitus.camila_campos.zoo_digital.especies.Reptil;

public class Jacare extends Reptil implements Predacao, Nado {

    public Jacare(String nome, Integer idade) {
        super(nome, idade, false);
    }

    @Override
    public void comer() {
        this.comer("peixes e mamíferos");
    }

    @Override
    public void emitirSom() {
        IO.println(getNome() + " está rosnando");
    }

    @Override
    public void cacar() {
        IO.println(getNome() + " está emboscando sua presa na margem do rio");
    }

    @Override
    public void nadar() {
        IO.println(getNome() + " está nadando silenciosamente pelo rio");
    }
}