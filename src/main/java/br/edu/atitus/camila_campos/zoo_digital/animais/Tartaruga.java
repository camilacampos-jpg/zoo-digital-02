package br.edu.atitus.camila_campos.zoo_digital.animais;

import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Nado;
import br.edu.atitus.camila_campos.zoo_digital.especies.Reptil;

public class Tartaruga extends Reptil implements Nado {

    public Tartaruga(String nome, Integer idade) {
        super(nome, idade, false);
    }

    @Override
    public void comer() {
        this.comer("plantas aquáticas e medusas");
    }

    @Override
    public void emitirSom() {
        IO.println(getNome() + " está assobiando levemente");
    }

    @Override
    public void nadar() {
        IO.println(getNome() + " está nadando lentamente no mar");
    }
}