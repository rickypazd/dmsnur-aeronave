package dmsnur.Domain.Repositories;

import java.util.List;
import java.util.UUID;

import dmsnur.Domain.Model.Marcas.Marca;
import dmsnur.SharedKernel.core.IRepository;

public interface IMarcaRepository extends IRepository<Marca, UUID> {

    public List<Marca> GetAll();

    public Marca Delete(Marca obj);

    public Marca Update(Marca obj);
}
