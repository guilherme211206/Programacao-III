package br.edu.surubim.academia.strategy;
import java.math.BigDecimal;

public class PrecoAnual implements EstrategiaPreco {
    @Override public BigDecimal calcularMensalidade() {
        return new BigDecimal("80.00");
    }
}
