package dmsnur.Application.UseCases.Command.Marcas.Editar;

import dmsnur.Domain.Factories.IAeronaveFactory;
import dmsnur.Domain.Factories.IMarcaFactory;
import dmsnur.Domain.Model.Aeronaves.Aeronave;
import dmsnur.Domain.Model.Marcas.Marca;
import dmsnur.Domain.Repositories.IAeronaveRepository;
import dmsnur.Domain.Repositories.IMarcaRepository;
import dmsnur.Domain.Repositories.IUnitOfWork;
import dmsnur.SharedKernel.http.HttpStatus;
import dmsnur.SharedKernel.http.Exception.HttpException;
import dmsnur.SharedKernel.mediator.RequestHandler;

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
