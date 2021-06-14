package org.gsoc.project.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageGenerator {

    public static List<Message> generate( int n){
        List<Message> messages = new ArrayList<>();

        for ( int i = 0; i < n; i++ ) {
            Message message = new Message.Builder()
                    .messageType( Message.MessageType.TEXT )
                    .readReceipt( true )
                    //.timestamp( Timestamp.valueOf( LocalDateTime.now() ) )
                    .build();

            messages.add( message );
        }
        return messages;
    }

}
