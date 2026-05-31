package org.example;
import java.io.*;
import java.util.Map;

public class GravadorDeDados {
    private String arquivo = "livros.dat";

    public void gravarLivros(Map<String, Livro> livros) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));

        out.writeObject(livros);
        out.close();
    }

    @SuppressWarnings("unchecked")
    public Map<String, Livro> recuperarLivros()
            throws IOException {

        try {
            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(arquivo));

            Map<String, Livro> livros =
                    (Map<String, Livro>) in.readObject();

            in.close();
            return livros;

        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }
}
