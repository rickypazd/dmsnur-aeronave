package Application.UseCases.Command.Marcas.Editar;

import Domain.Factories.IAeronaveFactory;
import Domain.Factories.IMarcaFactory;
import Domain.Model.Aeronaves.Aeronave;
import Domain.Model.Marcas.Marca;
import Domain.Repositories.IAeronaveRepository;
import Domain.Repositories.IMarcaRepository;
import Domain.Repositories.IUnitOfWork;
import SharedKernel.http.HttpStatus;
import SharedKernel.http.Exception.HttpException;
import SharedKernel.mediator.RequestHandler;

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
