package com.hazerta.jpaconsultas.servicio;

import com.hazerta.jpaconsultas.modelo.Customer;
import com.hazerta.jpaconsultas.repository.IRepositorioCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioCustomerImpl implements IServicioCustomer{
    @Autowired
    private IRepositorioCustomer repositorioCustomer;
    @Override
    public List<Customer> clientByCity(String city) {
        return repositorioCustomer.findByCity(city);
    }

    @Override
    public List<Customer> clientByCityAndCountry(String city, String country) {
        return repositorioCustomer.findByCityAndCountry(city, country);
    }

    @Override
    public List<Customer> clientByCompanyContaining(String patron) {
        return repositorioCustomer.findByCompanyNameContaining(patron);
    }

    @Override
    public List<Customer> clientByCountry(String country) {
        return repositorioCustomer.findByCountry(country);
    }

    @Override
    public List<Customer> clientByCompanyDesc() {
        return repositorioCustomer.findAllByOrderByCompanyNameDesc();
    }


}
