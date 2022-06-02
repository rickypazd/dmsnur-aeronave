package UseCases.Command.Aeronaves.Editar;

import org.junit.Assert;
import org.junit.Test;

import Dto.AeronaveDto;

public class EditarAeronaveCommand_Test {

    @Test
    public void dataValid() {
        String matricula = "XYC";
        AeronaveDto aeronave = new AeronaveDto();
        aeronave.setMatricula(matricula);
        EditarAeronaveCommand command = new EditarAeronaveCommand(aeronave);
        Assert.assertEquals(matricula, command.aeronave.getMatricula());
    }

    @Test
    public void constructorIsPrivate() {
        Assert.assertTrue(EditarAeronaveCommand.class.getConstructors()[0].canAccess(null));
    }
}
