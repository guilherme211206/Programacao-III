package br.edu.surubim.academia.model;
import br.edu.surubim.academia.strategy.EstrategiaPreco;
import br.edu.surubim.academia.strategy.PrecoAnual;
import java.math.BigDecimal;

public class PlanoAnual implements Plano {
    private final EstrategiaPreco estrategia = new PrecoAnual();
    @Override public String getNome() { return "Anual"; }
    @Override public BigDecimal calcularMensalidade() { return estrategia.calcularMensalidade(); }
}
