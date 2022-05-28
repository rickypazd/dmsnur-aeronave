package Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;


public class AeronaveDto_Test {

    @Test
    public void CheckPropertiesValid() {
        UUID key = UUID.randomUUID();
        String matricula = "A12345";
        List<AsientoDto> asientos = getAsientos();
        AeronaveDto aeronave = new AeronaveDto();

        Assert.assertEquals(null, aeronave.key);
        Assert.assertNull(aeronave.matricula);
        Assert.assertNotNull(aeronave.asientos);
        Assert.assertEquals(0, aeronave.asientos.size());
        aeronave.key = key;
        aeronave.matricula = matricula;
        aeronave.asientos = asientos;
        Assert.assertEquals(key, aeronave.key);
        Assert.assertEquals(matricula, aeronave.matricula);
        Assert.assertEquals(asientos, aeronave.asientos);
    }

    private List<AsientoDto> getAsientos() {
        return new ArrayList();
    }
}
