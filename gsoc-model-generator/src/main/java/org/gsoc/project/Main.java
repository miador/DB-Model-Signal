package org.gsoc.project;

public class Main {

    public static void main( String... args ) {

        Generator.init( "bolt://localhost:7687", "neo4j", "helloworld" );

        Generator.generate();
        System.exit( 0 );
    }

}