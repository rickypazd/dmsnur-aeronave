package Controllers;

import java.util.ArrayList;
import java.util.List;

import Dto.AeronaveDto;
import UseCases.Command.Aeronaves.Crear.CrearAeronaveCommand;
import UseCases.Command.Aeronaves.Editar.EditarAeronaveCommand;
import UseCases.Command.Aeronaves.Eliminar.EliminarAeronaveCommand;
import UseCases.Queries.Aeronaves.GetAll.GetAllAeronaveQuery;
import UseCases.Queries.Aeronaves.GetByKey.GetAeronaveByKeyQuery;
import Model.Aeronaves.*;
import fourteam.http.Exception.HttpException;
import fourteam.http.annotation.*;
import fourteam.mediator.Mediator;
import fourteam.mediator.Request;
import fourteam.mediator.Response;

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
