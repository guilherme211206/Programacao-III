package br.edu.surubim.academia.factory;
import br.edu.surubim.academia.model.Plano;
import br.edu.surubim.academia.model.PlanoAnual;

public class PlanoAnualFactory extends PlanoFactory {
    @Override public Plano criar() { return new PlanoAnual(); }
}
