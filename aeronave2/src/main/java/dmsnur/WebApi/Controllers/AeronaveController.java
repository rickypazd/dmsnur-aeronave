package dmsnur.WebApi.Controllers;

import java.util.ArrayList;
import java.util.List;

import dmsnur.Application.Dto.AeronaveDto;
import dmsnur.Application.UseCases.Command.Aeronaves.Crear.CrearAeronaveCommand;
import dmsnur.Application.UseCases.Command.Aeronaves.Editar.EditarAeronaveCommand;
import dmsnur.Application.UseCases.Command.Aeronaves.Eliminar.EliminarAeronaveCommand;
import dmsnur.Application.UseCases.Queries.Aeronaves.GetAll.GetAllAeronaveQuery;
import dmsnur.Application.UseCases.Queries.Aeronaves.GetByKey.GetAeronaveByKeyQuery;
import dmsnur.Domain.Model.Aeronaves.*;
import dmsnur.SharedKernel.http.Exception.HttpException;
import dmsnur.SharedKernel.http.annotation.*;
import dmsnur.SharedKernel.mediator.Mediator;
import dmsnur.SharedKernel.mediator.Request;
import dmsnur.SharedKernel.mediator.Response;

@RestController
@RequestMapping("/aeronave")
public class AeronaveController {

    private Mediator _mediator;

    public AeronaveController(Mediator mediator) {
        this._mediator = mediator;
    }

    @GetMapping("/")
    public Response<List<Aeronave>> getAll() throws HttpException {
        return _mediator.send(new GetAllAeronaveQuery());
    }

    @GetMapping("/{key}")
    public Response<AeronaveDto> getByKey(@PathVariable GetAeronaveByKeyQuery request) throws HttpException {
        return _mediator.send(request);
    }

    @PostMapping("/registro")
    public Response<Aeronave> register(@RequestBody CrearAeronaveCommand aeronave) throws HttpException {
        return _mediator.send(aeronave);
    }

    @PutMapping("/{key}")
    public Response<Aeronave> edit(@RequestBody Aeronave aeronave, @PathVariable EditarAeronaveCommand request)
            throws HttpException {
        request.aeronave.matricula = aeronave.matricula;
        return _mediator.send(request);
    }

    @DeleteMapping("/{key}")
    public Response<Aeronave> delete(@PathVariable EliminarAeronaveCommand request) throws HttpException {
        return _mediator.send(request);
    }
}
