package Controllers;

import java.util.ArrayList;
import java.util.List;

import UseCases.Command.Marcas.Crear.CrearMarcaCommand;
import UseCases.Command.Marcas.Editar.EditarMarcaCommand;
import UseCases.Command.Marcas.Eliminar.EliminarMarcaCommand;
import UseCases.Queries.Marcas.GetAll.GetAllMarcaQuery;
import UseCases.Queries.Marcas.GetByKey.GetMarcaByKeyQuery;
import Model.Marcas.*;
import Model.Marcas.Marca;
import fourteam.http.Exception.HttpException;
import fourteam.http.annotation.*;
import fourteam.mediator.Mediator;
import fourteam.mediator.Response;

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
