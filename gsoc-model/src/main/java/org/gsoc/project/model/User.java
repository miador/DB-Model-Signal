package org.gsoc.project.model;

import org.neo4j.ogm.annotation.*;
import org.neo4j.ogm.id.UuidStrategy;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {

    @Id
    @GeneratedValue( strategy = UuidStrategy.class )
    private String id;

    @Property
    private UserType userType;

    @Property
    private String phoneNumber;

    @Property
    private String username;

    @Property
    private String description;

    @Relationship( type = "HAS_ACCESS_TO", direction = Relationship.INCOMING )
    private List<Message> messages;

    @Relationship( type = "IS_CREATED_BY", direction = Relationship.INCOMING )
    private List<Conversation> conversations;

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations( List<Conversation> conversations ) {
        this.conversations = conversations;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages( List<Message> messages ) {
        this.messages = messages;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType( UserType userType ) {
        this.userType = userType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber( String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    @NodeEntity
    public enum UserType {
        SENDER,
        RECEIVER
    }

    public static class Builder {

        private String id;
        private UserType userType;
        private String phoneNumber;
        private String username;
        private String description;
        private List<Message> messages;
        private List<Conversation> conversations;

        public User.Builder id( String id ) {
            this.id = id;
            return this;
        }

        public User.Builder userType( UserType userType ) {
            this.userType = userType;
            return this;
        }

        public User.Builder phoneNumber( String phoneNumber ) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public User.Builder username( String username ) {
            this.username = username;
            return this;
        }

        public User.Builder description( String description ) {
            this.description = description;
            return this;
        }

        public User.Builder messages( List<Message> messages ) {
            this.messages = messages;
            return this;
        }

        public User.Builder message( Message message ) {
            if ( this.messages == null ) {
                this.messages = new ArrayList<>();
            }
            this.messages.add( message );
            return this;
        }

        public User.Builder conversations( List<Conversation> conversations ) {
            this.conversations = conversations;
            return this;
        }

        public User.Builder conversation( Conversation conversation ) {
            if ( this.conversations == null ) {
                this.conversations = new ArrayList<>();
            }
            this.conversations.add( conversation );
            return this;
        }

        public User build(){
            User u = new User();

            u.setConversations( conversations );
            u.setDescription( description );
            u.setMessages( messages );
            u.setUsername( username );
            u.setId( id );
            u.setPhoneNumber( phoneNumber );
            u.setUserType( userType );

            return u;
        }
    }

}
