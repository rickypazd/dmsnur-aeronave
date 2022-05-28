package UseCases.Command.Aeronaves.Crear;

import java.util.List;

import Dto.AeronaveDto;
import Dto.AsientoDto;
import mediator.Request;

public class CrearAeronaveCommand implements Request<AeronaveDto> {


    public CrearAeronaveCommand(AeronaveDto ero) {
        this.matricula = ero.matricula;
    }

    public String matricula;
    public List<AsientoDto> asientos;

    public List<AsientoDto> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<AsientoDto> asientos) {
        this.asientos = asientos;
    }
}
