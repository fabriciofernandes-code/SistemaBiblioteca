package org.example;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {

    private static final String ARQUIVO_CONTATOS = "livros.dat";

    public void gravarLivros(Map<String, Livro> livros)
            throws IOException {

        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream(ARQUIVO_CONTATOS));

        out.writeObject(livros);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public Map<String, Livro> recuperarLivros()
            throws IOException {

        try {
            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(ARQUIVO_CONTATOS));

            Map<String, Livro> livros =
                    (HashMap<String, Livro>) in.readObject();

            in.close();
            return livros;

        } catch (FileNotFoundException e) {
            return new HashMap<>();
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }
}