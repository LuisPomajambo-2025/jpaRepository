package com.hazerta.jpaconsultas;

import com.hazerta.jpaconsultas.servicio.IServicioCustomer;
import com.hazerta.jpaconsultas.servicio.IServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.util.List;

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
        System.out.println("1.-Consulta personalizada en Custumer por city");
        servicioCustomer.clientByCity("Berlin").forEach(System.out::println);
        System.out.println("2.-Consulta personalizada en Custumer por city y country");
        servicioCustomer.clientByCityAndCountry("México D.F.","Mexico").forEach(System.out::println);
        System.out.println("3.-Consulta personalizada en Custumer por patron en compani");
        servicioCustomer.clientByCompanyContaining("del").forEach(System.out::println);
        System.out.println("4.-Consulta personalizada en Custumer por las ciudades de un pais");
        servicioCustomer.clientByCountry("Spain").forEach(System.out::println);
        System.out.println("5.-Consulta personalizada en Custumer por compañia desc");
        servicioCustomer.clientByCompanyDesc().forEach(System.out::println);
        System.out.println("6.-Consulta personalizada en Custumer por lista de country");
        List<String> listaCountry = List.of("Mexico", "Spain","Brazil");
        servicioCustomer.clientByCountryIn(listaCountry).forEach(System.out::println);
        System.out.println("7.-Diferentes formas de consultar clientes por país utilizando:");
        System.out.println("7.1-consulta JPQL con parámetro posicional:");
        servicioCustomer.clientByPosicional("Spain").forEach(System.out::println);
        System.out.println("7.2-consulta JPQL con parámetro con nombre:");
        servicioCustomer.clientByContactName("Yang Wang").forEach(System.out::println);
        System.out.println("7.3-consulta nativa mediante SQL");
        servicioCustomer.clientByCountryNative("Germany").forEach(System.out::println);
        System.out.println("7.4-consulta JPQL ordenable mediante un objeto Sort");
        servicioCustomer.clientByCitySort().forEach(System.out::println);
    }
}
