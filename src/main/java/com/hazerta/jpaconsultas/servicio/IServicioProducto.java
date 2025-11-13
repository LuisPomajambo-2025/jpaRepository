package com.hazerta.jpaconsultas.servicio;

import com.hazerta.jpaconsultas.modelo.Producto;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IServicioProducto {
    List<Producto> listarProducto();
    Producto listarProductoPorId(int id);
    Producto actualizarProducto(Producto producto);
    Producto guardarProducto(Producto producto);
    void eliminarProducto(int id);
    List<Producto> listarProductoPorNombre(String nombre);
    List<Producto> listarProductoPorPatron(String patron);
    List<Producto> listarProductoPorPatronJPQuery(String patron);
    List<Producto> listarProductoPorPatronNativo(String patron);
    //
}
