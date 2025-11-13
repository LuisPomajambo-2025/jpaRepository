package com.hazerta.jpaconsultas.repository;

import com.hazerta.jpaconsultas.modelo.Producto;
import org.hibernate.dialect.function.ListaggStringAggEmulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRepositorioProducto extends JpaRepository<Producto, Integer> {
    List<Producto> findByNombre(String nombre);
    List<Producto> findByNombreContaining(String patron);

    @Query("select p from Producto p where p.nombre like %?1%")
    List<Producto> obtenerProductoPorPatron(String patron);
    @Query("select p from Producto p where p.nombre like %?1%")
    List<Producto> obtenerProductoPorPatronNativo(String patron);
}
