package Repositories;

import Model.Marcas.Marca;
import core.IRepository;
import java.util.List;
import java.util.UUID;

public interface IMarcaRepository extends IRepository<Marca, UUID> {
  public List<Marca> GetAll();

  public Marca Delete(Marca obj);

  public Marca Update(Marca obj);
}
