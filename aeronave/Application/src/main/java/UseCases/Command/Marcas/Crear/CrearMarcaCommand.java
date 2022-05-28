package UseCases.Command.Marcas.Crear;

import Dto.MarcaDto;
import mediator.Request;

public class CrearMarcaCommand implements Request<MarcaDto> {

    public CrearMarcaCommand(MarcaDto ero) {
        this.nombre = ero.nombre;
    }

    public String nombre;

}
