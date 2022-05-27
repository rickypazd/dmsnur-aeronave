package dmsnur.Infraestructure.Repository;

import java.util.List;
import java.util.UUID;

import dmsnur.Domain.Model.Marcas.Marca;
import dmsnur.Domain.Repositories.IMarcaRepository;
import dmsnur.Infraestructure.Context.IWriteDbContext;
import dmsnur.SharedKernel.db.DbSet;

public class MarcaRepository implements IMarcaRepository {

    private DbSet<Marca> _marcas;

    public MarcaRepository(IWriteDbContext database) {
        _marcas = database.Marca;
    }

    @Override
    public Marca FindByKey(UUID key) {
        return _marcas.Single(obj -> obj.key.equals(key));
    }

    @Override
    public void Create(Marca obj) {
        _marcas.Add(obj);
    }

    @Override
    public List<Marca> GetAll() {
        return _marcas.All();
    }

    @Override
    public Marca Delete(Marca obj) {
        _marcas.Delete((it -> it.key.equals(obj.key)));
        return obj;

    }

    @Override
    public Marca Update(Marca obj) {
        _marcas.Update(obj, (it -> it.key.equals(obj.key)));
        return obj;

    }

}
