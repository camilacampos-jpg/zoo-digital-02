package br.edu.atitus.camila_campos.zoo_digital.animais;

import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Nado;
import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Predacao;
import br.edu.atitus.camila_campos.zoo_digital.especies.Peixe;

public class Tubarao extends Peixe implements Nado, Predacao {

    public Tubarao(String nome, Integer idade) {
        super(nome, idade, "Salgada");
    }

    @Override
    public void comer() {
        this.comer("peixes e mamíferos marinhos");
    }

    @Override
    public void emitirSom() {
        IO.println(getNome() + " está emitindo ondas sonoras pelo oceano");
    }

    @Override
    public void nadar() {
        IO.println(getNome() + " está nadando velozmente pelo oceano");
    }

    @Override
    public void cacar() {
        IO.println(getNome() + " está farejando sua presa pelo olfato apurado");
    }
}