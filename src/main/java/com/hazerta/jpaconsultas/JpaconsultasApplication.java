package com.hazerta.jpaconsultas;

import com.hazerta.jpaconsultas.servicio.IServicioCustomer;
import com.hazerta.jpaconsultas.servicio.IServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaconsultasApplication implements CommandLineRunner{
    @Autowired
    IServicioProducto servicioProducto;
    @Autowired
    IServicioCustomer servicioCustomer;
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
        System.out.println("Consulta personalizada en Custumer por city");
        servicioCustomer.clientByCity("Berlin").forEach(System.out::println);
        System.out.println("Consulta personalizada en Custumer por city y country");
        servicioCustomer.clientByCityAndCountry("México D.F.","Mexico").forEach(System.out::println);
        System.out.println("Consulta personalizada en Custumer por patron en compani");
        servicioCustomer.clientByCompanyContaining("del").forEach(System.out::println);
        System.out.println("Consulta personalizada en Custumer por las ciudades de un pais");
        servicioCustomer.clientByCountry("Spain").forEach(System.out::println);
        System.out.println("Consulta personalizada en Custumer por compañia desc");
        servicioCustomer.clientByCompanyDesc().forEach(System.out::println);
    }
}
