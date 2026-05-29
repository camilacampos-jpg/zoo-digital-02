package br.edu.atitus.camila_campos.zoo_digital.app;

import br.edu.atitus.camila_campos.zoo_digital.animais.*;
import br.edu.atitus.camila_campos.zoo_digital.comportamentos.*;
import br.edu.atitus.camila_campos.zoo_digital.especies.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooDigitalApp {

    // List<Animal> — armazena todos os animais como tipo Animal (supertipo)
    // Persiste durante toda a execução do programa (atributo static da classe)
    private static final List<Animal> animais = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;

        // Loop principal,permanece em execução até o usuário escolher 0 (sair)
        while (opcao != 0) {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                // Tratamento de entrada inválida,requisito da aplicação CLI
                IO.println("Entrada inválida! Digite um número.");
                continue;
            }

            switch (opcao) {
                case 1 -> cadastrarAnimal(); // Cadastrar Animal
                case 2 -> listarTodos();     // Listar Todos
                case 3 -> listarCorredores();// Corredores
                case 4 -> listarNadadores(); // Nadadores
                case 5 -> listarVoadores();  // Voadores
                case 6 -> listarPredadores();// Predadores
                case 7 -> exibirTotal();     // Total static
                case 0 -> IO.println("Saindo do Zoo Digital. Até logo!");
                default -> IO.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        IO.println("\n===== ZOO DIGITAL =====");
        IO.println("1 - Cadastrar Animal");
        IO.println("2 - Listar Todos os Animais");
        IO.println("3 - Listar Animais Corredores");
        IO.println("4 - Listar Animais Nadadores");
        IO.println("5 - Listar Animais Voadores");
        IO.println("6 - Listar Animais Predadores");
        IO.println("7 - Exibir Total de Animais");
        IO.println("0 - Sair");
        IO.print("Escolha uma opção: ");
    }

    // CADASTRO DOS ANIMAIS
    // Conceitos: Instanciação + Upcasting
    // O usuário informa o tipo, nome e idade do animal
    // Cada classe CONCRETA (Leao, Cobra, etc.) é instanciada e armazenada como Animal isso é UPCASTING:
    // Animal animal = new Leao(nome, idade);
    // O objeto é do tipo Leao, mas a referência é do tipo Animal

      private static void cadastrarAnimal() {
        IO.println("\n--- TIPOS DISPONÍVEIS ---");
        IO.println("1  - Aguia        | 2  - Betta");
        IO.println("3  - Cachorro     | 4  - Camaleao");
        IO.println("5  - Cobra        | 6  - Coruja");
        IO.println("7  - Gato         | 8  - Golfinho");
        IO.println("9  - Jacare       | 10 - Leao");
        IO.println("11 - LoboCinzento | 12 - Pato");
        IO.println("13 - PeixeMorcego | 14 - Pinguim");
        IO.println("15 - Tartaruga    | 16 - Traira");
        IO.println("17 - Tubarao");
        IO.print("Tipo: ");

        int tipo;
        try {
            tipo = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            IO.println("Tipo inválido!");
            return;
        }

        IO.print("Nome: ");
        String nome = scanner.nextLine().trim();

        IO.print("Idade: ");
        int idade;
        try {
            idade = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            IO.println("Idade inválida!");
            return;
        }

        // UPCASTING referência do tipo Animal recebe objeto de subclasse concreta
        // Ex: Animal animal = new Leao(nome, idade);

        Animal animal = switch (tipo) {
            case 1  -> new Aguia(nome, idade);
            case 2  -> new Betta(nome, idade);
            case 3  -> new Cachorro(nome, idade);
            case 4  -> new Camaleao(nome, idade);
            case 5  -> new Cobra(nome, idade);
            case 6  -> new Coruja(nome, idade);
            case 7  -> new Gato(nome, idade);
            case 8  -> new Golfinho(nome, idade);
            case 9  -> new Jacare(nome, idade);
            case 10 -> new Leao(nome, idade);
            case 11 -> new LoboCinzento(nome, idade);
            case 12 -> new Pato(nome, idade);
            case 13 -> new PeixeMorcego(nome, idade);
            case 14 -> new Pinguim(nome, idade);
            case 15 -> new Tartaruga(nome, idade);
            case 16 -> new Traira(nome, idade);
            case 17 -> new Tubarao(nome, idade);
            default -> null;
        };

        if (animal == null) {
            IO.println("Tipo inválido!");
            return;
        }

        // Adiciona à lista persistente List<Animal>
        animais.add(animal);
        IO.println("Animal cadastrado com sucesso!");
    }

    //LISTAR TODOS OS ANIMAIS
    // Polimorfismo
    // A lista chamando emitirSom() e comer() em cada animal
    // Mesmo sendo referências do tipo Animal, o Java executa o metodo
    // da subclasse correta em tempo de execução
    // POLIMORFISMO DINÂMICO
    // Ex: um Leao.emitirSom() imprime "rugindo", Cobra imprime "sibilando"
    // toString() também é polimórfico, sobrescrito na classe Animal

    private static void listarTodos() {
        if (animais.isEmpty()) {
            IO.println("Nenhum animal cadastrado.");
            return;
        }
        IO.println("\n--- TODOS OS ANIMAIS ---");
        for (Animal animal : animais) {
            // toString() sobrescrito em Animal, retorna Nome e Idade
            IO.println("\n" + animal.toString()
                    + " | Espécie: " + animal.getEspecie());
            animal.emitirSom(); // POLIMORFISMO, cada animal emite seu som
            animal.comer();     // POLIMORFISMO, cada animal come seu alimento
        }
    }

    // LISTADO OS CORREDORES
    // Conceito: instanceof + Downcasting Seguro
    // Verifica em tempo de execução se o animal implementa Corrida
    // Se sim, faz o downcasting seguro e chama correr()
    // Sintaxe moderna: if (animal instanceof Corrida corredor)
    // cria a variável "corredor" já com o tipo correto, sem risco de
    // ClassCastException

    private static void listarCorredores() {
        IO.println("\n--- ANIMAIS CORREDORES ---");
        boolean encontrou = false;
        for (Animal animal : animais) {
            // instanceof com pattern matching (downcasting seguro)
            if (animal instanceof Corrida corredor) {
                IO.println("Nome: " + animal.getNome() + " | Espécie: " + animal.getEspecie());
                corredor.correr(); // medodo da interface corrida
                encontrou = true;
            }
        }
        if (!encontrou) IO.println("Nenhum animal corredor cadastrado.");
    }


    // LISTADO ANIMAIS NADADORES
    // Conceito: instanceof + Downcasting Seguro
    // Mesmo padrão (Listado nos Corredores), mas filtrando pela interface NADO
    // e chamando nadar().

    private static void listarNadadores() {
        IO.println("\n--- ANIMAIS NADADORES ---");
        boolean encontrou = false;
        for (Animal animal : animais) {
            if (animal instanceof Nado nadador) { // instanceof + downcasting seguro
                IO.println("Nome: " + animal.getNome() + " | Espécie: " + animal.getEspecie());
                nadador.nadar(); //medodo da interface Nado
                encontrou = true;
            }
        }
        if (!encontrou) IO.println("Nenhum animal nadador cadastrado.");
    }


    // LISTADO ANIMAIS VOADORES
    // Conceito: instanceof + Downcasting Seguro
    // Mesmo padrão (Listado nos Corredores), mas filtrando pela interface VOO
    // e chamando voar().

    private static void listarVoadores() {
        IO.println("\n--- ANIMAIS VOADORES ---");
        boolean encontrou = false;
        for (Animal animal : animais) {
            if (animal instanceof Voo voador) { // instanceof + downcasting seguro
                IO.println("Nome: " + animal.getNome() + " | Espécie: " + animal.getEspecie());
                voador.voar(); // metodo da inteface Voo
                encontrou = true;
            }
        }
        if (!encontrou) IO.println("Nenhum animal voador cadastrado.");
    }

    // LISTADO PREDADORES
    // Conceito: Nova Interface (Predacao) + instanceof
    // Demonstra o uso da interface Predacao criada no projeto.
    // Filtra os animais que implementam Predacao e chama cacar().


    private static void listarPredadores() {
        IO.println("\n--- ANIMAIS PREDADORES ---");
        boolean encontrou = false;
        for (Animal animal : animais) {
            if (animal instanceof Predacao predador) { // nova interface Predacao
                IO.println("Nome: " + animal.getNome() + " | Espécie: " + animal.getEspecie());
                predador.cacar(); //metodo da interface Predacao
                encontrou = true;
            }
        }
        if (!encontrou) IO.println("Nenhum animal predador cadastrado.");
    }

    // EXIBIDO TOTAL DE ANIMAIS
    // Conceito: Atributo e Metodo static
    // Animal.getContador() acessa o atributo estático "contador"
    // da classe Animal, pertence à CLASSE, não a uma instância
    // É incrementado no construtor de Animal a cada new feito,
    // por isso reflete o total real de objetos criados.

    private static void exibirTotal() {
        // getContador() é static; chamado diretamente pela classe Animal
        IO.println("\nTotal de animais cadastrados: " + Animal.getContador());
    }
}