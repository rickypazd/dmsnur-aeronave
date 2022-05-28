package dmsnur.Domain.Factories;

import dmsnur.Domain.Model.Aeronaves.Aeronave;

public interface IAeronaveFactory {

    public Aeronave Create(String matricula) ;
}
