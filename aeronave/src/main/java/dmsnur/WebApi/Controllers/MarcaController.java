package dmsnur.WebApi.Controllers;

import java.util.ArrayList;
import java.util.List;

import dmsnur.Application.UseCases.Command.Marcas.Crear.CrearMarcaCommand;
import dmsnur.Application.UseCases.Command.Marcas.Editar.EditarMarcaCommand;
import dmsnur.Application.UseCases.Command.Marcas.Eliminar.EliminarMarcaCommand;
import dmsnur.Application.UseCases.Queries.Marcas.GetAll.GetAllMarcaQuery;
import dmsnur.Application.UseCases.Queries.Marcas.GetByKey.GetMarcaByKeyQuery;
import dmsnur.Domain.Model.Marcas.*;
import dmsnur.Domain.Model.Marcas.Marca;
import dmsnur.SharedKernel.http.Exception.HttpException;
import dmsnur.SharedKernel.http.annotation.*;
import dmsnur.SharedKernel.mediator.Mediator;
import dmsnur.SharedKernel.mediator.Response;

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
