import core.IntegrationEvent;
import fourteam.console.console;

public class SharedKernel {

  public static Class[] classes = {
    // core
    core.AggregateRoot.class,
    core.BussinessRule.class,
    core.BussinessRuleValidateExeption.class,
    core.ConfirmedDomainEvent.class,
    core.DomainEvent.class,
    core.Entity.class,
    core.IntegrationEvent.class,
    core.IRepository.class,
    core.ValueObject.class,
    // IntegrationEvents
    IntegrationEvents.AeronaveCreado.class,
    IntegrationEvents.CheckInCreado.class,
    IntegrationEvents.TripulacionCreado.class,
    IntegrationEvents.VentaCreado.class,
    IntegrationEvents.VueloCreado.class,
    // rule
    rule.NotNullRule.class,
    rule.StringNotNullOrEmptyRule.class,
    // mediator

  };

  public static void AddKernel() {
    FourTeam.AddFourTeam();
    console.warning("[", SharedKernel.class.getSimpleName(), "]", "Trying to load dependencies");
    for (Class clas : classes) {
      System.out.print(clas.getName() + "\r");
    }
    console.succes("[", SharedKernel.class.getSimpleName(), "]", "Dependecies load succesfull!");
  }
}
