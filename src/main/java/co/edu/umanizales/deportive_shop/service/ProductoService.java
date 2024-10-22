package co.edu.umanizales.deportive_shop.service;

import co.edu.umanizales.deportive_shop.model.ProductoDeportivo;
import co.edu.umanizales.deportive_shop.model.RopaDeportiva;
import co.edu.umanizales.deportive_shop.model.EquipoDeportivo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    private List<ProductoDeportivo> productos = new ArrayList<>();

    // Agregar producto de tipo RopaDeportiva
    public void agregarRopaDeportiva(RopaDeportiva ropa) {
        productos.add(ropa);
    }

    // Agregar producto de tipo EquipoDeportivo
    public void agregarEquipoDeportivo(EquipoDeportivo equipo) {
        productos.add(equipo);
    }

    // Listar todos los productos
    public List<ProductoDeportivo> listarProductos() {
        return productos;
    }

    // Buscar producto por nombre exacto
    public ProductoDeportivo buscarProductoPorNombre(String nombre) {
        return productos.stream()
                .filter(producto -> producto.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    // Listar productos por tipo
    public List<RopaDeportiva> listarRopaDeportiva() {
        return productos.stream()
                .filter(producto -> producto instanceof RopaDeportiva)
                .map(producto -> (RopaDeportiva) producto)
                .collect(Collectors.toList());
    }

    public List<EquipoDeportivo> listarEquipoDeportivo() {
        return productos.stream()
                .filter(producto -> producto instanceof EquipoDeportivo)
                .map(producto -> (EquipoDeportivo) producto)
                .collect(Collectors.toList());
    }

    // Filtrar productos por rango de precio
    public List<ProductoDeportivo> filtrarPorPrecio(double minimo, double maximo) {
        return productos.stream()
                .filter(producto -> producto.getPrecio() >= minimo && producto.getPrecio() <= maximo)
                .collect(Collectors.toList());
    }

    // Buscar productos por nombre parcial
    public List<ProductoDeportivo> buscarPorNombreParcial(String nombreParcial) {
        return productos.stream()
                .filter(producto -> producto.getNombre().toLowerCase().contains(nombreParcial.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Listar productos de RopaDeportiva por material o de EquipoDeportivo por tipo
    public List<RopaDeportiva> listarRopaPorMaterial(String material) {
        return listarRopaDeportiva().stream()
                .filter(ropa -> ropa.getMaterial().equalsIgnoreCase(material))
                .collect(Collectors.toList());
    }

    public List<EquipoDeportivo> listarEquipoPorTipo(String tipo) {
        return listarEquipoDeportivo().stream()
                .filter(equipo -> equipo.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }
}
