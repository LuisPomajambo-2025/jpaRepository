package com.hazerta.jpaconsultas.repository;

import com.hazerta.jpaconsultas.modelo.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRepositorioCustomer extends JpaRepository<Customer, String> {
    List<Customer> findByCity(String city);
    List<Customer> findByCityAndCountry(String city, String country);
    List<Customer> findByCompanyNameContaining(String patron);
    List<Customer> findByCountry(String country);
    List<Customer> findAllByOrderByCompanyNameDesc();
    List<Customer> findAllByCountryIn(List<String> country);

    //JPQL
    @Query("SELECT c FROM Customer c WHERE c.country = ?1")
    List<Customer> findByPosicionalCountry(String country);
    @Query("SELECT c FROM Customer c WHERE c.country = :country")
    List<Customer> findByParamCountry(@Param("country") String country);
    List<Customer> findAll(Sort sort);
    @Query(value = "SELECT * FROM customers WHERE country = :country", nativeQuery = true)
    List<Customer> findByCountryNative(String country);
}
