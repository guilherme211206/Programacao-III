package br.edu.surubim.academia.model;
import java.math.BigDecimal;

public interface Plano {
    String getNome();
    BigDecimal calcularMensalidade();
}
