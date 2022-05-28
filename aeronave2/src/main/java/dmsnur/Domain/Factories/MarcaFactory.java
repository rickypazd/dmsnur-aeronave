package dmsnur.Domain.Factories;

import dmsnur.Domain.Model.Marcas.Marca;

public class MarcaFactory implements IMarcaFactory {

    public MarcaFactory() {

    }

    @Override
    public Marca Create(String nombre) {
        return new Marca(nombre);
    }
}
