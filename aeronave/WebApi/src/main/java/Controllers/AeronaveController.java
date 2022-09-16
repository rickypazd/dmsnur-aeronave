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
  public List<Aeronave> getAll() throws HttpException {
    try {
      Response<List<Aeronave>> lista = _mediator.send(new GetAllAeronaveQuery());
      return lista.data;
    } catch (Exception e) {
      e.printStackTrace();
      throw new HttpException(404, "Error " + e.getMessage());
    }
  }

  @GetMapping("/{key}")
  public Response<AeronaveDto> getByKey(@PathVariable GetAeronaveByKeyQuery request)
    throws HttpException {
    try {
      return _mediator.send(request);
    } catch (Exception e) {
      throw new HttpException(404, e.getMessage());
    }
  }

  @PostMapping("/registro")
  public Response<Aeronave> register(@RequestBody CrearAeronaveCommand aeronave)
    throws HttpException {
    try {
      return _mediator.send(aeronave);
    } catch (Exception e) {
      throw new HttpException(404, e.getMessage());
    }
  }

  @PutMapping("/{key}")
  public Response<Aeronave> edit(
    @RequestBody Aeronave aeronave,
    @PathVariable EditarAeronaveCommand request
  ) throws HttpException {
    request.aeronave.matricula = aeronave.matricula;
    try {
      return _mediator.send(request);
    } catch (Exception e) {
      throw new HttpException(404, e.getMessage());
    }
  }

  @DeleteMapping("/{key}")
  public Response<Aeronave> delete(@PathVariable EliminarAeronaveCommand request)
    throws HttpException {
    try {
      return _mediator.send(request);
    } catch (Exception e) {
      throw new HttpException(404, e.getMessage());
    }
  }
}
