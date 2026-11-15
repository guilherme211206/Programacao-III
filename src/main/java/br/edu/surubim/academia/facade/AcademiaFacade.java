package br.edu.surubim.academia.facade;
import br.edu.surubim.academia.model.Aluno;
import br.edu.surubim.academia.model.Plano;
import br.edu.surubim.academia.observer.NotificadorConsole;
import br.edu.surubim.academia.service.SistemaAcademia;
import java.util.List;

public class AcademiaFacade {
    private final SistemaAcademia sistema = new SistemaAcademia();

    public AcademiaFacade() {
        sistema.adicionarObservador(new NotificadorConsole());
    }

    public Aluno cadastrarAluno(String nome, String telefone, Plano plano) {
        return sistema.cadastrar(nome, telefone, plano);
    }
    public List<Aluno> listarAlunos() {
        return sistema.listar();
    }
    public Aluno buscarAluno(int id) {
        return sistema.buscar(id);
    }
    public void alterarPlano(int id, Plano plano) {
        sistema.alterarPlano(id, plano);
    }
    public void removerAluno(int id) {
        sistema.remover(id);
    }
}
