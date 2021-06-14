package org.gsoc.project.model;

import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Conversation {

    @Id
    @GeneratedValue( strategy = UuidStrategy.class )
    private String id;

    @Property
    private OffsetDateTime startDate;

    @Property
    private ConversationType conversationType;

    @Relationship( type = "HELD_BY", direction = Relationship.INCOMING )
    private Notification notification;

    @Relationship( type = "CONSIST_OF", direction = Relationship.INCOMING )
    private List<Message> messages;

    public ConversationType getConversationType() {
        return conversationType;
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public void setConversationType( ConversationType conversationType ) {
        this.conversationType = conversationType;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages( List<Message> messages ) {
        this.messages = messages;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification( Notification notification ) {
        this.notification = notification;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate( OffsetDateTime startDate ) {
        this.startDate = startDate;
    }

    @NodeEntity
    public enum ConversationType {
        INDIVIDUAL,
        GROUP
    }

    public static class Builder {

        private String id;
        private OffsetDateTime startDate;
        private ConversationType conversationType;
        private Notification notification;
        private List<Message> messages;

        public Conversation.Builder id( String id ) {
            this.id = id;
            return this;
        }

        public Conversation.Builder startDate( OffsetDateTime startDate ) {
            this.startDate = startDate;
            return this;
        }

        public Conversation.Builder conversationType( ConversationType conversationType ) {
            this.conversationType = conversationType;
            return this;
        }

        public Conversation.Builder notification( Notification notification ) {
            this.notification = notification;
            return this;
        }

        public Conversation.Builder message( Message message ) {
            if ( this.messages == null ) {
                this.messages = new ArrayList<>();
            }
            this.messages.add( message );
            return this;
        }

        public Conversation.Builder messages( List<Message> messages ) {
            this.messages = messages;
            return this;
        }

        public Conversation build(){
            Conversation c = new Conversation();

            c.setId( id );
            c.setConversationType( conversationType );
            c.setMessages( messages );
            c.setNotification( notification );
            c.setStartDate( startDate );

            return c;
        }

    }

}
