package br.edu.atitus.camila_campos.zoo_digital.animais;

import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Predacao;
import br.edu.atitus.camila_campos.zoo_digital.especies.Mamifero;

public class Leao extends Mamifero implements Predacao {

    public Leao(String nome, Integer idade) {
        super(nome, idade, true);
    }

    @Override
    public void comer() {
        this.comer("carne de animais selvagens");
    }

    @Override
    public void emitirSom() {
        IO.println(getNome() + " está rugindo");
    }

    @Override
    public void cacar() {
        IO.println(getNome() + " está caçando na savana");
    }
}