package dmsnur.Application.UseCases.Queries.Aeronaves.GetByKey;

import dmsnur.Application.Dto.AeronaveDto;
import dmsnur.Application.Dto.AsientoDto;
import dmsnur.Domain.Model.Aeronaves.Aeronave;
import dmsnur.Domain.Repositories.IAeronaveRepository;
import dmsnur.SharedKernel.http.HttpStatus;
import dmsnur.SharedKernel.http.Exception.HttpException;
import dmsnur.SharedKernel.mediator.RequestHandler;

public class GetAeronaveByKeyHandler implements RequestHandler<GetAeronaveByKeyQuery, AeronaveDto> {

    private IAeronaveRepository _aeronaveRepository;

    public GetAeronaveByKeyHandler(IAeronaveRepository aeronaveRepository) {
        this._aeronaveRepository = aeronaveRepository;
    }

    @Override
    public AeronaveDto handle(GetAeronaveByKeyQuery request) throws HttpException {
        Aeronave aeronave = _aeronaveRepository.FindByKey(request.key);
        if (aeronave == null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Aeronave no encontrada");
        }
        AeronaveDto aeronaveDto = new AeronaveDto();
        aeronaveDto.matricula = aeronave.matricula;
        aeronave.asientos.iterator().forEachRemaining(obj -> {
            aeronaveDto.asientos.add(new AsientoDto(obj.key, obj.numero, obj.clase));
        });
        return aeronaveDto;
    }
}
