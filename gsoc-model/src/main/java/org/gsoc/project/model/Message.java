package org.gsoc.project.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.id.UuidStrategy;

import java.sql.Timestamp;

public class Message {

    @Id
    @GeneratedValue( strategy = UuidStrategy.class )
    private String id;

    @Property
    private MessageType messageType;

    //@Property
    //private Timestamp timestamp;

    @Property
    private boolean readReceipt = true; //by default

    public void setId( String id ) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType( MessageType messageType ) {
        this.messageType = messageType;
    }

//    public Timestamp getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp( Timestamp timestamp ) {
//        this.timestamp = timestamp;
//    }

    public boolean isReadReceipt() {
        return readReceipt;
    }

    public void setReadReceipt( boolean readReceipt ) {
        this.readReceipt = readReceipt;
    }

    @NodeEntity
    public enum MessageType {
        TEXT,
        AUDIO,
        IMAGE,
        VIDEO,
        FILE,
        GIF,
        CONTACT,
        LOCATION
    }

    public static class Builder {

        private String id;
        private MessageType messageType;
        private Timestamp timestamp;
        private boolean readReceipt = true; //by default

        public Message.Builder id( String id ) {
            this.id = id;
            return this;
        }

        public Message.Builder messageType( MessageType messageType ) {
            this.messageType = messageType;
            return this;
        }

        public Message.Builder timestamp( Timestamp timestamp ) {
            this.timestamp = timestamp;
            return this;
        }

        public Message.Builder readReceipt( boolean readReceipt ) {
            this.readReceipt = readReceipt;
            return this;
        }

        public Message build(){

            Message m = new Message();

            m.setId( id );
            m.setMessageType( messageType );
            m.setReadReceipt( readReceipt );
//            m.setTimestamp( timestamp );

            return m;
        }

    }

}
