package org.gsoc.project.model;

import java.util.ArrayList;
import java.util.List;

public class UserGenerator {

    public static List<User> generate(int n){
        List<User> users = new ArrayList<>();

        for ( int i = 0; i < n; i++ ) {
            User user = new User.Builder()
                    .userType( User.UserType.RECEIVER )
                    .description( "sample description" )
                    .phoneNumber( "+3144456712" )
                    .username( "miador" )
                    .build();

            users.add( user );
        }
        return users;
    }

}
