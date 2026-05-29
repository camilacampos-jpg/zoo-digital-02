package br.edu.atitus.camila_campos.zoo_digital.especies;

public abstract class Mamifero extends Animal {

    public Mamifero(String nome, Integer idade, Boolean temPelos) {
        super(nome, "Mamífero", idade);
        this.temPelos = temPelos;
    }

    private Boolean temPelos;

    public Boolean getTemPelos() {
        return temPelos;
    }

    public void setTemPelos(Boolean temPelos) {
        this.temPelos = temPelos;
    }

    public void amamentar() {
        IO.println(this.getNome() + " está amamentando seus filhotinhos.");
    }
    
    
}
