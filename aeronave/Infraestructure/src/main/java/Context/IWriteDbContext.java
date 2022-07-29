package Context;

import Model.Aeronaves.Aeronave;
import Model.Aeronaves.Asiento;
import Model.Marcas.Marca;
import fourteam.db.DbContext;
import fourteam.db.DbSet;

public abstract class IWriteDbContext extends DbContext {

  public IWriteDbContext(Class dbContextClass) {
    super(dbContextClass);
  }

  public DbSet<Aeronave> Aeronave;
  public DbSet<Asiento> Asiento;
  public DbSet<Marca> Marca;
}
