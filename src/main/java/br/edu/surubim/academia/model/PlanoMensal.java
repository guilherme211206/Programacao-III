package br.edu.surubim.academia.model;
import br.edu.surubim.academia.strategy.EstrategiaPreco;
import br.edu.surubim.academia.strategy.PrecoMensal;
import java.math.BigDecimal;

public class PlanoMensal implements Plano {
    private final EstrategiaPreco estrategia = new PrecoMensal();
    @Override public String getNome() { return "Mensal"; }
    @Override public BigDecimal calcularMensalidade() { return estrategia.calcularMensalidade(); }
}
