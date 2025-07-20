package com.example.meli;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

  private final DataSource dataSource;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("-> Ejecutando el inicializador de datos...");

    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.addScript(new ClassPathResource("db/init/init-db.sql"));

    populator.setContinueOnError(false);
    populator.setIgnoreFailedDrops(true);

    try {
      populator.execute(dataSource);
      System.out.println("-> Inicialización de datos completada exitosamente.");
    } catch (Exception e) {
      String msg = e.getMessage() != null ? e.getMessage().toLowerCase() : "";
      if (msg.contains("already exists") || msg.contains("duplicate key") || msg.contains("unique constraint")) {
        System.err.println("-> Datos ya existentes, ignorando: " + e.getMessage());
      } else {
        System.err.println("-> Error grave durante la inicialización de datos: " + e.getMessage());
        e.printStackTrace(); // Para ver el stack trace completo
        throw e;
      }
    }
  }
}