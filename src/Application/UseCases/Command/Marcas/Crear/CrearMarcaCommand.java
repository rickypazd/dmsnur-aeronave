package Application.UseCases.Command.Marcas.Crear;

import Application.Dto.MarcaDto;
import SharedKernel.mediator.Request;

public class CrearMarcaCommand implements Request<MarcaDto> {

    public CrearMarcaCommand(MarcaDto ero) {
        this.nombre = ero.nombre;
    }

    public String nombre;

}
