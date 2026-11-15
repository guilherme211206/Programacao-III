package br.edu.surubim.academia.factory;
import br.edu.surubim.academia.model.Plano;
import br.edu.surubim.academia.model.PlanoTrimestral;

public class PlanoTrimestralFactory extends PlanoFactory {
    @Override public Plano criar() { return new PlanoTrimestral(); }
}
