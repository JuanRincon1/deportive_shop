package co.edu.umanizales.deportive_shop.controller;


import co.edu.umanizales.deportive_shop.model.EquipoDeportivo;
import co.edu.umanizales.deportive_shop.model.ProductoDeportivo;
import co.edu.umanizales.deportive_shop.model.RopaDeportiva;
import co.edu.umanizales.deportive_shop.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Agregar producto de tipo RopaDeportiva
    @PostMapping("/ropa")
    public String agregarRopaDeportiva(@RequestBody RopaDeportiva ropa) {
        productoService.agregarRopaDeportiva(ropa);
        return "Ropa deportiva agregada correctamente.";
    }

    // Agregar producto de tipo EquipoDeportivo
    @PostMapping("/equipo")
    public String agregarEquipoDeportivo(@RequestBody EquipoDeportivo equipo) {
        productoService.agregarEquipoDeportivo(equipo);
        return "Equipo deportivo agregado correctamente.";
    }

    // Listar todos los productos
    @GetMapping
    public List<ProductoDeportivo> listarProductos() {
        return productoService.listarProductos();
    }

    // Buscar producto por nombre exacto
    @GetMapping("/{nombre}")
    public ProductoDeportivo buscarProductoPorNombre(@PathVariable String nombre) {
        return productoService.buscarProductoPorNombre(nombre);
    }

    // Listar productos por tipo
    @GetMapping("/tipo/{tipo}")
    public List<?> listarPorTipo(@PathVariable String tipo) {
        if (tipo.equalsIgnoreCase("ropa")) {
            return productoService.listarRopaDeportiva();
        } else if (tipo.equalsIgnoreCase("equipo")) {
            return productoService.listarEquipoDeportivo();
        } else {
            throw new IllegalArgumentException("Tipo de producto no válido");
        }
    }

    // Filtrar productos por rango de precio
    @GetMapping("/precio")
    public List<ProductoDeportivo> filtrarPorPrecio(@RequestParam double minimo, @RequestParam double maximo) {
        return productoService.filtrarPorPrecio(minimo, maximo);
    }

    // Buscar productos por nombre parcial
    @GetMapping("/buscar/{nombreParcial}")
    public List<ProductoDeportivo> buscarPorNombreParcial(@PathVariable String nombreParcial) {
        return productoService.buscarPorNombreParcial(nombreParcial);
    }

    // Listar productos por atributo
    @GetMapping("/atributo")
    public List<?> listarPorAtributo(@RequestParam String tipo, @RequestParam String atributo) {
        if (tipo.equalsIgnoreCase("ropa")) {
            return productoService.listarRopaPorMaterial(atributo);
        } else if (tipo.equalsIgnoreCase("equipo")) {
            return productoService.listarEquipoPorTipo(atributo);
        } else {
            throw new IllegalArgumentException("Tipo o atributo no válido");
        }
    }
}
