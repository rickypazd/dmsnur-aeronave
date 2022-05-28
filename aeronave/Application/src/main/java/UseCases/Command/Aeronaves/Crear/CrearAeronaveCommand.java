package UseCases.Command.Aeronaves.Crear;

import java.util.List;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import fourteam.mediator.Request;

public class CrearAeronaveCommand implements Request<AeronaveDto> {


    public CrearAeronaveCommand(AeronaveDto ero) {
        this.matricula = ero.matricula;
    }

    public String matricula;
   
}
