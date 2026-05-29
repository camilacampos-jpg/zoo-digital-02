package br.edu.atitus.camila_campos.zoo_digital.especies;

public abstract class Animal {
    //Atributo Estático
    // Pertence à classe
    // Exite UMA vez só, e é compartilhado entre as instâncias
    private static int contador = 0;

    public static int getContador() {
        return contador;
    }

    public final String VERSAO_APP = "2.5";
    
    // Atributos
    private String nome;
    private String especie;
    private Integer idade;

    // Método Construtor
    public Animal(String nome, String especie, Integer idade){
        this.nome = nome; // Inicializa o atributo "nome" com o valor do parâmetro "nome"
        this.especie = especie;
        this.idade = idade;
        //this.contador++; Não é uma boa prática
        Animal.contador++;
    }

    // Métodos Gets e Sets
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void comer() {
        this.comer("alguma coisa");
    }
    // Sobrecarga de método - Polimorfismo estático
    // Dois ou mais métodos com o mesmo identificador, mas assinatura diferentes
    public final void comer(String alimento) {
        IO.println(this.getNome() + " está comendo " + alimento);
    }

    // Sobrescrevendo o método herdado da classe Object
    // Polimorfismo Dinâmico
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "; Idade: " + this.getIdade() + " anos.";
    }


    public abstract void emitirSom();

    
}
