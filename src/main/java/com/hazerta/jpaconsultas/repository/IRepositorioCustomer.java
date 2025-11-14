package com.hazerta.jpaconsultas.repository;

import com.hazerta.jpaconsultas.modelo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRepositorioCustomer extends JpaRepository<Customer, String> {
    List<Customer> findByCity(String city);
    List<Customer> findByCityAndCountry(String city, String country);
    List<Customer> findByCompanyNameContaining(String patron);
    List<Customer> findByCountry(String country);
    List<Customer> findAllByOrderByCompanyNameDesc();
}
