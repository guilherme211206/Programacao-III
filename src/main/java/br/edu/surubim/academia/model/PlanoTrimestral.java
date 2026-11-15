package br.edu.surubim.academia.model;
import br.edu.surubim.academia.strategy.EstrategiaPreco;
import br.edu.surubim.academia.strategy.PrecoTrimestral;
import java.math.BigDecimal;

public class PlanoTrimestral implements Plano {
    private final EstrategiaPreco estrategia = new PrecoTrimestral();
    @Override public String getNome() { return "Trimestral"; }
    @Override public BigDecimal calcularMensalidade() { return estrategia.calcularMensalidade(); }
}
