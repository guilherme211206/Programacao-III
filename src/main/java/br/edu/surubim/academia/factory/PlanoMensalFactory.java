package br.edu.surubim.academia.factory;
import br.edu.surubim.academia.model.Plano;
import br.edu.surubim.academia.model.PlanoMensal;

public class PlanoMensalFactory extends PlanoFactory {
    @Override public Plano criar() { return new PlanoMensal(); }
}
