package UseCases.Queries.Aeronaves.GetAll;

import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.RequestHandler;
import java.util.List;

public class GetAllAeronaveHandler implements RequestHandler<GetAllAeronaveQuery, List<Aeronave>> {

  private IAeronaveRepository _aeronaveRepository;

  public GetAllAeronaveHandler(IAeronaveRepository aeronaveRepository) {
    this._aeronaveRepository = aeronaveRepository;
  }

  @Override
  public List<Aeronave> handle(GetAllAeronaveQuery request) throws Exception {
    return _aeronaveRepository.GetAll();
  }
}
