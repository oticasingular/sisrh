package sisrh.soap;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ServicoBasicoTest {

    @Test
    void deveRetornarPongComUUID() {
        ServicoBasico servico = new ServicoBasico();
        String resposta = servico.ping();

        assertNotNull(resposta);
        assertTrue(resposta.startsWith("pong: "));
        assertDoesNotThrow(() -> UUID.fromString(resposta.substring(6).trim()));
    }

    @Test
    void deveRetornarDaaHoraNoFormatoCorreto() {
        ServicoBasico servico = new ServicoBasico();
        String dataHora = servico.dataHoraServidor();

        assertNotNull(dataHora);
        assertTrue(dataHora.matches("\\d{2}/\\d{2}/\\d{4} - \\d{2}:\\d{2}:\\d{2}"),
                "Formato esperado: dd/MM/yyyy - HH:mm:ss");
    }
}