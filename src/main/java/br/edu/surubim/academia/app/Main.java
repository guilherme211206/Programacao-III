package br.edu.surubim.academia.app;
import br.edu.surubim.academia.facade.AcademiaFacade;
import br.edu.surubim.academia.factory.PlanoFactory;
import br.edu.surubim.academia.model.Aluno;
import br.edu.surubim.academia.model.Plano;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AcademiaFacade academia = new AcademiaFacade();

    public static void main(String[] args) {
        System.out.println("=== Sistema de Acompanhamento de Academia ===");
        boolean executando = true;
        while (executando) {
            exibirMenu();
            int opcao = lerInteiro("Escolha: ");
            try {
                switch (opcao) {
                    case 1 -> cadastrarAluno();
                    case 2 -> listarAlunos();
                    case 3 -> consultarAluno();
                    case 4 -> alterarPlano();
                    case 5 -> removerAluno();
                    case 0 -> executando = false;
                    default -> System.out.println("Opção inválida.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Não foi possível concluir: " + e.getMessage());
            }
            System.out.println();
        }
        System.out.println("Sistema encerrado. Até mais!");
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Listar alunos");
        System.out.println("3 - Consultar aluno");
        System.out.println("4 - Alterar plano");
        System.out.println("5 - Remover aluno");
        System.out.println("0 - Sair");
    }

    private static void cadastrarAluno() {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Telefone (opcional): ");
        String telefone = scanner.nextLine().trim();
        Plano plano = escolherPlano();
        Aluno aluno = academia.cadastrarAluno(nome, telefone, plano);
        System.out.println("Aluno cadastrado! Código: " + aluno.getId());
    }

    private static void listarAlunos() {
        List<Aluno> alunos = academia.listarAlunos();
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("--- Alunos cadastrados ---");
        for (Aluno aluno : alunos) {
            System.out.printf("%d | %s | %s | %s%n",
                    aluno.getId(), aluno.getNome(), aluno.getPlano().getNome(),
                    dinheiro(aluno.getPlano().calcularMensalidade()));
        }
    }

    private static void consultarAluno() {
        int id = lerInteiro("Código do aluno: ");
        Aluno aluno = academia.buscarAluno(id);
        System.out.println("Código: " + aluno.getId());
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Telefone: " + (aluno.getTelefone().isBlank() ? "Não informado" : aluno.getTelefone()));
        System.out.println("Plano: " + aluno.getPlano().getNome());
        System.out.println("Mensalidade: " + dinheiro(aluno.getPlano().calcularMensalidade()));
    }

    private static void alterarPlano() {
        int id = lerInteiro("Código do aluno: ");
        Plano plano = escolherPlano();
        academia.alterarPlano(id, plano);
        System.out.println("Plano atualizado.");
    }

    private static void removerAluno() {
        int id = lerInteiro("Código do aluno: ");
        academia.removerAluno(id);
        System.out.println("Aluno removido.");
    }

    private static Plano escolherPlano() {
        System.out.println("Plano: 1 - Mensal (R$ 100,00), 2 - Trimestral (R$ 270,00 total), 3 - Anual (R$ 960,00 total)");
        int escolha = lerInteiro("Escolha o plano: ");
        return switch (escolha) {
            case 1 -> PlanoFactory.criarPlano("mensal");
            case 2 -> PlanoFactory.criarPlano("trimestral");
            case 3 -> PlanoFactory.criarPlano("anual");
            default -> throw new IllegalArgumentException("Plano inválido.");
        };
    }

    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        String valor = scanner.nextLine().trim();
        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Digite um número inteiro válido.");
        }
    }

    private static String dinheiro(BigDecimal valor) {
        return "R$ " + valor.setScale(2, java.math.RoundingMode.HALF_UP).toPlainString().replace('.', ',');
    }
}
