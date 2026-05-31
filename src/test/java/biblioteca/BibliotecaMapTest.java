package biblioteca;

import org.example.BibliotecaMap;

import org.junit.Test;
import static org.junit.Assert.*;

public class BibliotecaMapTest {
    @Test
    public void testaCadastroPesquisaERemocao() throws Exception {

        BibliotecaMap biblioteca = new BibliotecaMap();

        biblioteca.cadastraLivro("Dom Casmurro", "Machado de Assis");

        assertEquals(1, biblioteca.pesquisaPorAutor("Machado de Assis").size());

        assertTrue(biblioteca.removeLivro("Dom Casmurro"));
    }
}
