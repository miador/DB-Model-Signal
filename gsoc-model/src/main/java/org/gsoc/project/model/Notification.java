package org.gsoc.project.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.id.UuidStrategy;

import java.time.OffsetDateTime;

public class Notification {

    @Id
    @GeneratedValue( strategy = UuidStrategy.class )
    private String id;

    @Property
    private NotificationType notificationType;

    @Property
    private boolean isOn = true; //true by default

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType( NotificationType notificationType ) {
        this.notificationType = notificationType;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn( boolean on ) {
        isOn = on;
    }

    public enum NotificationType {
        CUSTOM,
        DEFAULT
    }

    public static class Builder{

        private String id;
        private NotificationType notificationType;
        private boolean isOn = true; //true by default

        public Notification.Builder id( String id ) {
            this.id = id;
            return this;
        }

        public Notification.Builder notificationType( NotificationType notificationType ) {
            this.notificationType = notificationType;
            return this;
        }

        public Notification.Builder isOn( boolean isOn ) {
            this.isOn = isOn;
            return this;
        }

        public Notification build(){

            Notification n = new Notification();

            n.setId( id );
            n.setNotificationType( notificationType );
            n.setOn( isOn );

            return n;
        }

    }

}
