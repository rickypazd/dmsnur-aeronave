package dmsnur.Domain.Factories;

import dmsnur.Domain.Model.Marcas.Marca;

public interface IMarcaFactory {

    public Marca Create(String nombre);
}
