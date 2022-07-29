package Controllers;

import Dto.AeronaveDto;
import Model.Aeronaves.Aeronave;
import UseCases.Command.Aeronaves.Crear.CrearAeronaveCommand;
import UseCases.Command.Aeronaves.Editar.EditarAeronaveCommand;
import UseCases.Command.Aeronaves.Eliminar.EliminarAeronaveCommand;
import UseCases.Queries.Aeronaves.GetAll.GetAllAeronaveQuery;
import UseCases.Queries.Aeronaves.GetByKey.GetAeronaveByKeyQuery;
import fourteam.http.Exception.HttpException;
import fourteam.http.annotation.DeleteMapping;
import fourteam.http.annotation.GetMapping;
import fourteam.http.annotation.PathVariable;
import fourteam.http.annotation.PostMapping;
import fourteam.http.annotation.PutMapping;
import fourteam.http.annotation.RequestBody;
import fourteam.http.annotation.RequestMapping;
import fourteam.http.annotation.RestController;
import fourteam.mediator.Mediator;
import fourteam.mediator.Response;
import java.util.List;

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
  public Response<AeronaveDto> getByKey(
    @PathVariable GetAeronaveByKeyQuery request
  ) throws HttpException {
    return _mediator.send(request);
  }

  @PostMapping("/registro")
  public Response<Aeronave> register(
    @RequestBody CrearAeronaveCommand aeronave
  ) throws HttpException {
    return _mediator.send(aeronave);
  }

  @PutMapping("/{key}")
  public Response<Aeronave> edit(
    @RequestBody Aeronave aeronave,
    @PathVariable EditarAeronaveCommand request
  ) throws HttpException {
    request.aeronave.matricula = aeronave.matricula;
    return _mediator.send(request);
  }

  @DeleteMapping("/{key}")
  public Response<Aeronave> delete(
    @PathVariable EliminarAeronaveCommand request
  ) throws HttpException {
    return _mediator.send(request);
  }
}
