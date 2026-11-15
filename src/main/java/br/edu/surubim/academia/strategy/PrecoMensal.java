package br.edu.surubim.academia.strategy;
import java.math.BigDecimal;

public class PrecoMensal implements EstrategiaPreco {
    @Override public BigDecimal calcularMensalidade() {
        return new BigDecimal("100.00");
    }
}
