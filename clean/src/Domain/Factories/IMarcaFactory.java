package Domain.Factories;

import Domain.Model.Marcas.Marca;

public interface IMarcaFactory {

    public Marca Create(String nombre);
}
