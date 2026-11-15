package br.edu.surubim.academia.factory;
import br.edu.surubim.academia.model.Plano;

public abstract class PlanoFactory {
    public abstract Plano criar();

    public static Plano criarPlano(String tipo) {
        if (tipo == null) throw new IllegalArgumentException("Tipo de plano inválido.");
        return switch (tipo.trim().toLowerCase()) {
            case "mensal" -> new PlanoMensalFactory().criar();
            case "trimestral" -> new PlanoTrimestralFactory().criar();
            case "anual" -> new PlanoAnualFactory().criar();
            default -> throw new IllegalArgumentException("Tipo de plano desconhecido.");
        };
    }
}
