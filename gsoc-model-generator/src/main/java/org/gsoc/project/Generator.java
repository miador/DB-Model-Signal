package org.gsoc.project;

import org.gsoc.project.model.*;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;

import java.util.List;

public class Generator {

    public static SessionFactory sessions;

    public static void init( String uri, String username, String password ) {
        sessions = new SessionFactory( new Configuration.Builder().uri( uri ).useNativeTypes().credentials( username, password ).build(), "org.gsoc.project.model" );
    }

    public static void generate() {

        List<User> users = UserGenerator.generate( 5 );
        for ( User u : users ) {
            List<Conversation> conversations = ConversationGenerator.generate( 5 );
            for ( Conversation c : conversations ){
                c.setMessages( MessageGenerator.generate( 10 ) );
                c.setNotification( NotificationGenerator.generate() );
            }
            u.setConversations( conversations );
            sessions.openSession().save( u );
        }



    }


}
