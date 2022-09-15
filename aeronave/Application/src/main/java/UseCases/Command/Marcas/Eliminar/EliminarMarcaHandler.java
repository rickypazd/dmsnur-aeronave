package UseCases.Command.Marcas.Eliminar;

import Factories.IAeronaveFactory;
import Factories.IMarcaFactory;
import Model.Aeronaves.Aeronave;
import Model.Marcas.Marca;
import Repositories.IAeronaveRepository;
import Repositories.IMarcaRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class EliminarMarcaHandler implements RequestHandler<EliminarMarcaCommand, Marca> {

  private IMarcaFactory _marcaFactory;
  private IMarcaRepository _marcaRepository;
  private IUnitOfWork _unitOfWork;

  public EliminarMarcaHandler(
    IMarcaFactory marcaFactory,
    IMarcaRepository marcaRepository,
    IUnitOfWork _unitOfWork
  ) {
    this._marcaFactory = marcaFactory;
    this._marcaRepository = marcaRepository;
    this._unitOfWork = _unitOfWork;
  }

  @Override
  public Marca handle(EliminarMarcaCommand request) throws HttpException {
    Marca marca = _marcaRepository.FindByKey(request.marca.key);
    if (marca == null) {
      throw new HttpException(HttpStatus.BAD_REQUEST, "marca no encontrada");
    }

    return _marcaRepository.Delete(marca);
  }
}
