package Application.UseCases.Queries.Marcas.GetByKey;

import Application.Dto.MarcaDto;
import Domain.Model.Marcas.Marca;
import Domain.Repositories.IMarcaRepository;
import SharedKernel.http.HttpStatus;
import SharedKernel.http.Exception.HttpException;
import SharedKernel.mediator.RequestHandler;

public class GetMarcaByKeyHandler implements RequestHandler<GetMarcaByKeyQuery, MarcaDto> {

    private IMarcaRepository _marcaRepository;

    public GetMarcaByKeyHandler(IMarcaRepository marcaRepository) {
        this._marcaRepository = marcaRepository;
    }

    @Override
    public MarcaDto handle(GetMarcaByKeyQuery request) throws HttpException {
        Marca marca = _marcaRepository.FindByKey(request.key);
        if (marca == null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "marca no encontrada");
        }
        MarcaDto marcaDto = new MarcaDto();
        marcaDto.nombre = marca.nombre;
        return marcaDto;
    }
}
