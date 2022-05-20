package Test.Application.Dto;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import Application.Dto.AsientoDto;

public class AsientoDto_Test {

    @Test
    public void CheckPropertiesValid() {
        UUID key = UUID.randomUUID();
        UUID keyAeronave = UUID.randomUUID();
        int numero = 1;
        String clase = "Ejecutiva";

        AsientoDto asiento = new AsientoDto();

        Assert.assertEquals(null, asiento.key);
        Assert.assertEquals(null, asiento.keyAeronave);
        Assert.assertEquals(0, asiento.numero);
        Assert.assertEquals(null, asiento.clase);
        
        asiento.key = key;
        asiento.keyAeronave = keyAeronave;
        asiento.numero = numero;
        asiento.clase = clase;

        Assert.assertEquals(key, asiento.key);
        Assert.assertEquals(keyAeronave, asiento.keyAeronave);
        Assert.assertEquals(numero, asiento.numero);
        Assert.assertEquals(clase, asiento.clase);
        
        
    }

}
