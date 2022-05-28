package UseCases.Command.Aeronaves.Crear;

import org.junit.Assert;
import org.junit.Test;

import Dto.AeronaveDto;

public class CrearAeronaveCommand_Test {

    @Test
    public void dataValid() {
        String matricula = "XYC";
        AeronaveDto aeronave = new AeronaveDto();
        aeronave.matricula = matricula;
        CrearAeronaveCommand command = new CrearAeronaveCommand(aeronave);
        Assert.assertEquals(matricula, command.matricula);
    }

    @Test
    public void constructorIsPrivate() {
        Assert.assertTrue(CrearAeronaveCommand.class.getConstructors()[0].canAccess(null));
    }
}
