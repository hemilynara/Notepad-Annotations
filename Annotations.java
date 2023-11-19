import java.util.ArrayList;
import java.util.Scanner;

class Anotacao {
    private String titulo;
    private String conteudo;

    public Anotacao(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nConteúdo: " + conteudo + "\n";
    }
}

class BlocoDeNotas {
    private ArrayList<Anotacao> anotacoes;

    public BlocoDeNotas() {
        this.anotacoes = new ArrayList<>();
    }

    public void adicionarAnotacao(Anotacao anotacao) {
        anotacoes.add(anotacao);
    }

    public void visualizarAnotacoes() {
        if (anotacoes.isEmpty()) {
            System.out.println("Nenhuma anotação disponível.");
        } else {
            for (Anotacao anotacao : anotacoes) {
                System.out.println(anotacao);
            }
        }
    }

    public void removerAnotacao(String titulo) {
        for (Anotacao anotacao : anotacoes) {
            if (anotacao.getTitulo().equalsIgnoreCase(titulo)) {
                anotacoes.remove(anotacao);
                System.out.println("Anotação removida com sucesso.");
                return;
            }
        }
        System.out.println("Anotação não encontrada.");
    }
}

public class Main {
    public static void main(String[] args) {
        BlocoDeNotas blocoDeNotas = new BlocoDeNotas();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar anotação");
            System.out.println("2. Visualizar anotações");
            System.out.println("3. Remover anotação");
            System.out.println("4. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    System.out.print("Digite o título da anotação: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o conteúdo da anotação: ");
                    String conteudo = scanner.nextLine();
                    Anotacao novaAnotacao = new Anotacao(titulo, conteudo);
                    blocoDeNotas.adicionarAnotacao(novaAnotacao);
                    System.out.println("Anotação adicionada com sucesso.");
                    break;

                case 2:
                    blocoDeNotas.visualizarAnotacoes();
                    break;

                case 3:
                    System.out.print("Digite o título da anotação a ser removida: ");
                    String tituloRemover = scanner.nextLine();
                    blocoDeNotas.removerAnotacao(tituloRemover);
                    break;

                case 4:
                    System.out.println("Saindo do bloco de notas. Até mais!");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
