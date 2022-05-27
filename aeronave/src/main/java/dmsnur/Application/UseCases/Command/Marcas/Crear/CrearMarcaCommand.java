package dmsnur.Application.UseCases.Command.Marcas.Crear;

import dmsnur.Application.Dto.MarcaDto;
import dmsnur.SharedKernel.mediator.Request;

public class CrearMarcaCommand implements Request<MarcaDto> {

    public CrearMarcaCommand(MarcaDto ero) {
        this.nombre = ero.nombre;
    }

    public String nombre;

}
