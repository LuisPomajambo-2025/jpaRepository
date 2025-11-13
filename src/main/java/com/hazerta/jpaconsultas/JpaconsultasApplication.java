package com.hazerta.jpaconsultas;

import com.hazerta.jpaconsultas.servicio.IServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaconsultasApplication implements CommandLineRunner{
    @Autowired
    IServicioProducto servicioProducto;
	public static void main(String[] args) {
		SpringApplication.run(JpaconsultasApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Lista de producto");
        servicioProducto.listarProducto().forEach(System.out::println);
        System.out.println("Consulta personalizada");
        servicioProducto.listarProductoPorNombre("Geitost").forEach(System.out::println);
        System.out.println("Consulta personalizada por patron");
        servicioProducto.listarProductoPorPatron("F").forEach(System.out::println);
    }
}
