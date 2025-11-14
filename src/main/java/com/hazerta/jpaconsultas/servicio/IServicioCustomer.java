package com.hazerta.jpaconsultas.servicio;

import com.hazerta.jpaconsultas.modelo.Customer;

import java.util.List;

public interface IServicioCustomer {
     List<Customer> clientByCity(String city);
     List<Customer> clientByCityAndCountry(String city, String country);
     List<Customer> clientByCompanyContaining(String patron);
     List<Customer> clientByCountry(String country);
     List<Customer> clientByCompanyDesc();
     List<Customer> clientByCountryIn(List<String> country);
}
