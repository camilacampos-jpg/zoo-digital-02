package br.edu.atitus.camila_campos.zoo_digital.animais;

import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Corrida;
import br.edu.atitus.camila_campos.zoo_digital.comportamentos.Nado;
import br.edu.atitus.camila_campos.zoo_digital.especies.Mamifero;

public final class Gato extends Mamifero implements Corrida, Nado {
    public Gato(String nome, Integer idade) {
        super(nome, idade, true);
    }

    @Override
    public void comer() {
        this.comer("carne");
    }

    @Override
    public void emitirSom() {
        IO.println(this.getNome() +  " está miando!");
    }

    @Override
    public void nadar() {
        IO.println(this.getNome() + " está nadando apavorado!");
    }
    
    @Override
    public void correr() {
        IO.println(this.getNome() + " está correndo pelo telhado!");
    }
}