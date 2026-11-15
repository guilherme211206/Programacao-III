package br.edu.surubim.academia.strategy;
import java.math.BigDecimal;

public class PrecoTrimestral implements EstrategiaPreco {
    @Override public BigDecimal calcularMensalidade() {
        return new BigDecimal("90.00");
    }
}
