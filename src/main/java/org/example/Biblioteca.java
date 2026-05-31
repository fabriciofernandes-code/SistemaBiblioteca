package org.example;

import java.io.IOException;
import java.util.Collection;

/**
 * Interface que define as operações de uma biblioteca.
 */

public interface Biblioteca {

    /**
     * Cadastra um novo livro.
     *
     * @param titulo título do livro
     * @param autor autor do livro
     * @return true se o livro foi cadastrado
     */
    boolean cadastraLivro(String titulo, String autor);

    /**
     * Pesquisa livros por autor.
     *
     * @param autor nome do autor
     * @return coleção de livros encontrados
     */
    Collection<Livro> pesquisaPorAutor(String autor);

    /**
     * Remove um livro pelo título.
     *
     * @param titulo título do livro
     * @return true se removido
     * @throws LivroInexistenteException caso o livro não exista
     */
    boolean removeLivro(String titulo) throws LivroInexistenteException;

    /**
     * Salva os dados da biblioteca.
     *
     * @throws IOException caso ocorra erro de gravação
     */
    void salvarDados() throws IOException;

    /**
     * Recupera os dados da biblioteca.
     *
     * @throws IOException caso ocorra erro de leitura
     */
    void recuperarDados() throws IOException;
}
