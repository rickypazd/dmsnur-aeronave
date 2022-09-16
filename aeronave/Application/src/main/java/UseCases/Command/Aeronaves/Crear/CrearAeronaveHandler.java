package UseCases.Command.Aeronaves.Crear;

import Factories.IAeronaveFactory;
import Model.Aeronaves.Aeronave;
import Repositories.IAeronaveRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;
import java.util.UUID;

public class CrearAeronaveHandler implements RequestHandler<CrearAeronaveCommand, UUID> {

  private IAeronaveFactory _aeronaveFactory;
  private IAeronaveRepository _aeronaveRepository;
  private IUnitOfWork _unitOfWork;

  public CrearAeronaveHandler(
    IAeronaveFactory aeronaveFactory,
    IAeronaveRepository aeronaveRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._aeronaveFactory = aeronaveFactory;
    this._aeronaveRepository = aeronaveRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public UUID handle(CrearAeronaveCommand request) throws Exception {
    Aeronave aeronave = _aeronaveRepository.FindByMatricula(request.matricula);
    if (aeronave != null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "Ya existe una aeronave con esta matricula.");
    }
    aeronave = _aeronaveFactory.Create(request.matricula);
    aeronave.eventCreado();
    _aeronaveRepository.Create(aeronave);
    _unitOfWork.commit();
    return aeronave.key;
  }
}
