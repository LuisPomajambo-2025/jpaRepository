package com.hazerta.jpaconsultas.servicio;

import com.hazerta.jpaconsultas.modelo.Producto;
import com.hazerta.jpaconsultas.repository.IRepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProductoImpl implements IServicioProducto{
    @Autowired
    private IRepositorioProducto repositorioProducto;

    @Override
    public List<Producto> listarProducto() {
        return repositorioProducto.findAll();
    }

    @Override
    public Producto listarProductoPorId(int id) {
        return repositorioProducto.findById(id).orElse(null);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return repositorioProducto.save(producto);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return repositorioProducto.save(producto);
    }

    @Override
    public void eliminarProducto(int id) {
        repositorioProducto.deleteById(id);
    }

    @Override
    public List<Producto> listarProductoPorNombre(String nombre) {
        return repositorioProducto.findByNombre(nombre);
    }

    @Override
    public List<Producto> listarProductoPorPatron(String patron) {
        return repositorioProducto.findByNombreContaining(patron);
    }

    @Override
    public List<Producto> listarProductoPorPatronJPQuery(String patron) {
        return repositorioProducto.obtenerProductoPorPatron(patron);
    }

    @Override
    public List<Producto> listarProductoPorPatronNativo(String patron) {
        return repositorioProducto.obtenerProductoPorPatronNativo(patron);
    }

}
