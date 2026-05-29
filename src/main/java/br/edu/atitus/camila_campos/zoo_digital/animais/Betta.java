package br.edu.atitus.camila_campos.zoo_digital.animais;

import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Nado;
import br.edu.atitus.camila_campos.zoo_digital.especies.Peixe;

public class Betta extends Peixe implements Nado {

    public Betta(String nome, Integer idade) {
        super(nome, idade, "Doce");
    }

    @Override
    public void comer() {
        this.comer("pequenos insetos e larvas");
    }

    @Override
    public void emitirSom() {
        IO.println(getNome() + " está borbulhando");
    }

    @Override
    public void nadar() {
        IO.println(getNome() + " está nadando graciosamente");
    }
}