package org.example;
import java.io.IOException;
import java.util.*;

public class BibliotecaMap implements Biblioteca {
    private Map<String, Livro> livros;
    private GravadorDeDados gravador;

    public BibliotecaMap() {
         this.livros = new HashMap<>();
         this.gravador = new GravadorDeDados();
    }

    @Override
    public boolean cadastraLivro(String titulo, String autor) {
        livros.put(titulo, new Livro(titulo, autor));
        return true;
    }

    @Override
    public Collection<Livro> pesquisaPorAutor(String autor) {

        List<Livro> resultado = new ArrayList<>();

        for (Livro l : livros.values()) {
            if (l.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    @Override
    public boolean removeLivro(String titulo) throws LivroInexistenteException {

        if (!livros.containsKey(titulo)) {
            throw new LivroInexistenteException("Livro não encontrado");
        }

        livros.remove(titulo);
        return true;
    }

    @Override
    public void salvarDados() throws IOException {
        gravador.gravarLivros(livros);
    }

    @Override
    public void recuperarDados() throws IOException {
        livros = gravador.recuperarLivros();
    }
}