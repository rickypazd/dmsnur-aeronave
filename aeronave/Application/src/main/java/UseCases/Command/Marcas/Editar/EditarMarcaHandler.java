package UseCases.Command.Marcas.Editar;

import Factories.IAeronaveFactory;
import Factories.IMarcaFactory;
import Model.Aeronaves.Aeronave;
import Model.Marcas.Marca;
import Repositories.IAeronaveRepository;
import Repositories.IMarcaRepository;
import Repositories.IUnitOfWork;
import http.HttpStatus;
import http.Exception.HttpException;
import mediator.RequestHandler;

public class EditarMarcaHandler implements RequestHandler<EditarMarcaCommand, Marca> {

    private IMarcaFactory _marcaFactory;
    private IMarcaRepository _marcaRepository;
    private IUnitOfWork _unitOfWork;

    public EditarMarcaHandler(IMarcaFactory marcaFactory, IMarcaRepository marcaRepository,
            IUnitOfWork _unitOfWork) {
        this._marcaFactory = marcaFactory;
        this._marcaRepository = marcaRepository;
        this._unitOfWork = _unitOfWork;
    }

    @Override
    public Marca handle(EditarMarcaCommand request) throws HttpException {
        Marca marca = _marcaRepository.FindByKey(request.marca.key);
        if (marca == null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "marca no encontrada");
        }
        marca.nombre = request.marca.nombre;
        _marcaRepository.Update(marca);
        return marca;

    }

}
