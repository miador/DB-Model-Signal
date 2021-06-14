package org.gsoc.project.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConversationGenerator {

    public static List<Conversation> generate(int n) {
        List<Conversation> conversations = new ArrayList<>();

        for ( int i = 0; i < n; i++ ) {
            Conversation conversation = new Conversation.Builder()
                    .conversationType( Conversation.ConversationType.INDIVIDUAL )
                    .startDate( OffsetDateTime.now() )
                    .build();

            conversations.add( conversation );
        }
        return conversations;
    }
}
