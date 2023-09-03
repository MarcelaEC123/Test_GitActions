import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.example.proyecto.MainActivity2;

public class MainActivityTest {

    @Test
    public void testValidarEmpresa() {
        MainActivity2 mainActivity = new MainActivity2();
        mainActivity.empresa.setChecked(true);

        String expectedMessage = "Ha seleccionado  \nEmpresa \n";
        String actualMessage = mainActivity.validar();

        assertEquals(expectedMessage, actualMessage);
    }

    // Agrega más métodos de prueba para los otros casos (discapacitado, estudiante) si es necesario
}
