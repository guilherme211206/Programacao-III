package br.edu.surubim.academia.observer;


public class NotificadorConsole implements ObservadorAcademia {
    @Override public void atualizar(String mensagem) {
        System.out.println("[Aviso da academia] " + mensagem);
    }
}
