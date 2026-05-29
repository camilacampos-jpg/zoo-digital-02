package br.edu.atitus.camila_campos.zoo_digital.animais;

import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Predacao;
import br.edu.atitus.camila_campos.zoo_digital.especies.Reptil;

public class Cobra extends Reptil implements Predacao {

    public Cobra(String nome, Integer idade) {
        super(nome, idade, true);
    }

    @Override
    public void comer() {
        this.comer("roedores e pequenos animais");
    }

    @Override
    public void emitirSom() {
        IO.println(getNome() + " está sibilando");
    }

    @Override
    public void cacar() {
        IO.println(getNome() + " está caçando com sua língua bifurcada");
    }
}