package Application.UseCases.Queries.Marcas.GetAll;

import java.util.List;

import Domain.Model.Marcas.Marca;
import Domain.Repositories.IMarcaRepository;
import SharedKernel.mediator.RequestHandler;

public class GetAllMarcaHandler implements RequestHandler<GetAllMarcaQuery, List<Marca>> {

    private IMarcaRepository _marcaRepository;

    public GetAllMarcaHandler(IMarcaRepository marcaRepository) {
        this._marcaRepository = marcaRepository;
    }

    @Override
    public List<Marca> handle(GetAllMarcaQuery request) {
        return _marcaRepository.GetAll();
    }
}
