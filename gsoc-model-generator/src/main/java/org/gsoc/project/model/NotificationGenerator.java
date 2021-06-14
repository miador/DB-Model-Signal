package org.gsoc.project.model;

import java.util.ArrayList;
import java.util.List;

public class NotificationGenerator {

    public static Notification generate(){

        return new Notification.Builder()
                .notificationType( Notification.NotificationType.CUSTOM )
                .isOn( true )
                .build();
    }

}
