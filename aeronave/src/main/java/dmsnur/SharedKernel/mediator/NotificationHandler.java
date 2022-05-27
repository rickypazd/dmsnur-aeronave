package dmsnur.SharedKernel.mediator;

public interface NotificationHandler<T> {
    public void handle(Notification notification);
}
