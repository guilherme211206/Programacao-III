package br.edu.surubim.academia.service;
import br.edu.surubim.academia.model.Aluno;
import br.edu.surubim.academia.model.Plano;
import br.edu.surubim.academia.observer.ObservadorAcademia;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SistemaAcademia {
    private final Map<Integer, Aluno> alunos = new LinkedHashMap<>();
    private final List<ObservadorAcademia> observadores = new ArrayList<>();
    private int proximoId = 1;

    public void adicionarObservador(ObservadorAcademia observador) {
        if (observador != null && !observadores.contains(observador)) observadores.add(observador);
    }

    public Aluno cadastrar(String nome, String telefone, Plano plano) {
        Aluno aluno = new Aluno(proximoId++, nome, telefone, plano);
        alunos.put(aluno.getId(), aluno);
        notificar("Novo aluno cadastrado: " + aluno.getNome() + " (código " + aluno.getId() + ").");
        return aluno;
    }

    public List<Aluno> listar() {
        return new ArrayList<>(alunos.values());
    }

    public Aluno buscar(int id) {
        Aluno aluno = alunos.get(id);
        if (aluno == null) throw new IllegalArgumentException("Não existe aluno com esse código.");
        return aluno;
    }

    public void alterarPlano(int id, Plano plano) {
        Aluno aluno = buscar(id);
        String antigo = aluno.getPlano().getNome();
        aluno.setPlano(plano);
        notificar("Plano de " + aluno.getNome() + " alterado de " + antigo + " para " + plano.getNome() + ".");
    }

    public void remover(int id) {
        Aluno aluno = buscar(id);
        alunos.remove(id);
        notificar("Aluno removido: " + aluno.getNome() + ".");
    }

    private void notificar(String mensagem) {
        for (ObservadorAcademia observador : List.copyOf(observadores)) {
            observador.atualizar(mensagem);
        }
    }
}
