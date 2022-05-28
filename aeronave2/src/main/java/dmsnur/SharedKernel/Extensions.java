package dmsnur.SharedKernel;

public class Extensions {
    public static Class[] classes = {
            dmsnur.SharedKernel.core.AggregateRoot.class,
            dmsnur.SharedKernel.core.DomainEvent.class,
            dmsnur.SharedKernel.core.Entity.class,
            dmsnur.SharedKernel.core.ValueObject.class,
            dmsnur.SharedKernel.core.BussinessRuleValidateExeption.class,
            dmsnur.SharedKernel.core.IRepository.class,
            // http
            dmsnur.SharedKernel.http.Rest.class,
            // rule
            dmsnur.SharedKernel.rule.NotNullRule.class,
            dmsnur.SharedKernel.rule.StringNotNullOrEmptyRule.class,
            // mediator
            dmsnur.SharedKernel.mediator.AggregateException.class,
            dmsnur.SharedKernel.mediator.IMediator.class,
            dmsnur.SharedKernel.mediator.NotificationHandler.class,
            dmsnur.SharedKernel.mediator.Notification.class,
            dmsnur.SharedKernel.mediator.Request.class,
            dmsnur.SharedKernel.mediator.Response.class,
            // Class
            dmsnur.SharedKernel.extensions.IServiceCollection.class,
            // DB
            dmsnur.SharedKernel.db.DbContext.class,
            dmsnur.SharedKernel.db.DbSet.class,
            dmsnur.SharedKernel.db.ModelBuilder.class,
    };

    public static void AddKernel() {
        int i = 0;
        int l = classes.length;
        for (Class clas : classes) {
            i++;
            System.out.print("Add kerel class: (" + i + "/" + l + ")\r");
        }
        System.out.println("\n");
    }
}
