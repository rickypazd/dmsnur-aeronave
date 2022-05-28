package dmsnur.Domain.Model.Aeronaves;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dmsnur.Domain.Event.AeronaveCreado;
import dmsnur.Domain.Model.Aeronaves.ValueObjects.MatriculaAeronave;
import dmsnur.SharedKernel.core.AggregateRoot;
import dmsnur.SharedKernel.core.BussinessRuleValidateExeption;

public class Aeronave extends AggregateRoot<UUID> {

    public String matricula;
    public List<Asiento> asientos;

    public Aeronave() {

    }
    public Aeronave(String matricula) {
        key = UUID.randomUUID();
        try {
            this.matricula = new MatriculaAeronave(matricula).toString();
        } catch (BussinessRuleValidateExeption e) {
            e.printStackTrace();
            return;
        }
        asientos = new ArrayList<Asiento>();
    }

    public void eventCreado() {
        addDomainEvent(new AeronaveCreado(key, matricula));
    }

    public void agregarAsiento(Asiento asiento) {
        asientos.parallelStream().filter(p -> p.getKey() == asiento.getKey()).findFirst().ifPresent(p -> {
            throw new RuntimeException("El asiento ya existe");
        });
        asientos.add(asiento);
    }
}
