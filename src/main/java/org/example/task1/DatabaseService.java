package org.example.task1;

import org.flywaydb.core.Flyway;

public class DatabaseService {

    public static void initAndPopulate() {
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:h2:C:/Users/Asus/DataBases/h2","sa", "")
                .load();
        flyway.migrate();
        System.out.println("Database initialized and populated successfully");
    }
}
