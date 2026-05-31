package org.example;

public class LivroInexistenteException extends Exception {
    public LivroInexistenteException(String mensagem) {
        super(mensagem);
    }
}
