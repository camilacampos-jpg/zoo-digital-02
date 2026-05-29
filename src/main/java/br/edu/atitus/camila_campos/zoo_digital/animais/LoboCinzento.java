package br.edu.atitus.camila_campos.zoo_digital.animais;

import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Predacao;
import br.edu.atitus.camila_campos.zoo_digital.especies.Mamifero;

public class LoboCinzento extends Mamifero implements Predacao {

    public LoboCinzento(String nome, Integer idade) {
        super(nome, idade, true);
    }

    @Override
    public void comer() {
        this.comer("carne de cervos e alces");
    }

    @Override
    public void emitirSom() {
        IO.println(getNome() + " está uivando");
    }

    @Override
    public void cacar() {
        IO.println(getNome() + " está caçando em alcateia");
    }
}