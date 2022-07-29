package UseCases.Queries.Marcas.GetAll;

import Model.Marcas.Marca;
import Repositories.IMarcaRepository;
import fourteam.mediator.RequestHandler;
import java.util.List;

public class GetAllMarcaHandler
  implements RequestHandler<GetAllMarcaQuery, List<Marca>> {

  private IMarcaRepository _marcaRepository;

  public GetAllMarcaHandler(IMarcaRepository marcaRepository) {
    this._marcaRepository = marcaRepository;
  }

  @Override
  public List<Marca> handle(GetAllMarcaQuery request) {
    return _marcaRepository.GetAll();
  }
}
