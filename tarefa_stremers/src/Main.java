import java.util.ArrayList;   // Importa a lista que vai guardar as pessoas
import java.util.List;        // Interface para listas
import java.util.Scanner;     // Para ler do console
import java.util.stream.Collectors; // Para usar expressões lambda de filtragem

// Criamos uma classe chamada Pessoa para guardar nome e sexo
class Pessoa {
    String nome;
    String sexo;

    // Construtor: toda vez que criamos uma Pessoa, precisamos dar nome e sexo
    Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    // Método para mostrar a pessoa como texto
    public String toString() {
        return nome + " (" + sexo + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Cria um leitor para o console
        List<Pessoa> pessoas = new ArrayList<>(); // Lista onde vamos guardar as pessoas

        System.out.println("Digite nomes e sexos separados por vírgula (ex: Maria,F).");
        System.out.println("Digite 'sair' quando terminar:");

        // Loop para ler várias pessoas até escrever "sair"
        while (true) {
            String entrada = sc.nextLine(); // Lê uma linha do console
            if (entrada.equalsIgnoreCase("sair")) { // Se o usuário digitar sair, paramos
                break;
            }

            // Divide o texto pelo separador vírgula
            String[] partes = entrada.split(",");
            if (partes.length == 2) { // Se tiver exatamente duas partes (nome,sexo)
                String nome = partes[0].trim(); // Pega o nome
                String sexo = partes[1].trim(); // Pega o sexo
                pessoas.add(new Pessoa(nome, sexo)); // Adiciona na lista
            } else {
                System.out.println("Formato inválido, use Nome,Sexo");
            }
        }

        // Aqui usamos expressão lambda para filtrar apenas as mulheres (sexo F)
        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> {
                    // Usamos if e else dentro da lambda
                    if (p.sexo.equalsIgnoreCase("F")) {
                        return true;  // Se for mulher, fica na lista
                    } else {
                        return false; // Se não for, não entra
                    }
                })
                .collect(Collectors.toList()); // Coleta o resultado numa nova lista

        // Imprime todas as mulheres
        System.out.println("Mulheres encontradas:");
        mulheres.forEach(System.out::println); // Expressão lambda para imprimir cada mulher
    }
}
