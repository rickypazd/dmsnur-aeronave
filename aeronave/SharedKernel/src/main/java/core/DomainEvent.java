package core;

import java.time.LocalDateTime;
import java.util.UUID;

import fourteam.mediator.Notification;

public class DomainEvent implements Notification {

    public LocalDateTime OcurredOn;
    public UUID Key;

    public DomainEvent() {
        
    }

    public DomainEvent(LocalDateTime ocurredOn) {
        this.OcurredOn = ocurredOn;
        this.Key = UUID.randomUUID();
    }

    public LocalDateTime getOcurredOn() {
        return OcurredOn;
    }

    public UUID getKey() {
        return Key;
    }

}
