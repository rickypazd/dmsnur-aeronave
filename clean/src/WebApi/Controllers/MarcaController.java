package WebApi.Controllers;

import java.util.ArrayList;
import java.util.List;

import Application.UseCases.Command.Marcas.Crear.CrearMarcaCommand;
import Application.UseCases.Command.Marcas.Editar.EditarMarcaCommand;
import Application.UseCases.Command.Marcas.Eliminar.EliminarMarcaCommand;
import Application.UseCases.Queries.Marcas.GetAll.GetAllMarcaQuery;
import Application.UseCases.Queries.Marcas.GetByKey.GetMarcaByKeyQuery;
import Domain.Model.Marcas.*;
import Domain.Model.Marcas.Marca;
import SharedKernel.http.Exception.HttpException;
import SharedKernel.http.annotation.*;
import SharedKernel.mediator.Mediator;
import SharedKernel.mediator.Response;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    private Mediator _mediator;

    public MarcaController(Mediator mediator) {
        this._mediator = mediator;
    }

    @GetMapping("/")
    public Response<List<Marca>> getAll() throws HttpException {
        return _mediator.send(new GetAllMarcaQuery());
    }

    @GetMapping("/{key}")
    public Response<Marca> getByKey(@PathVariable GetMarcaByKeyQuery request) throws HttpException {
        return _mediator.send(request);
    }

    @PostMapping("/registro")
    public Response<Marca> register(@RequestBody CrearMarcaCommand Marca) throws HttpException {
        return _mediator.send(Marca);
    }

    @PutMapping("/{key}")
    public Response<Marca> edit(@RequestBody Marca Marca, @PathVariable EditarMarcaCommand request)
            throws HttpException {
        request.marca.nombre = Marca.nombre;
        return _mediator.send(request);
    }

    @DeleteMapping("/{key}")
    public Response<Marca> delete(@PathVariable EliminarMarcaCommand request) throws HttpException {
        return _mediator.send(request);
    }
}
