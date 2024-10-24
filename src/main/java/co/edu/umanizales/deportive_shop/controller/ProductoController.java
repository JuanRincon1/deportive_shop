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

    
    @PostMapping("/ropa")
    public String agregarRopaDeportiva(@RequestBody RopaDeportiva ropa) {
        productoService.agregarRopaDeportiva(ropa);
        return "Ropa deportiva agregada correctamente.";
    }

    
    @PostMapping("/equipo")
    public String agregarEquipoDeportivo(@RequestBody EquipoDeportivo equipo) {
        productoService.agregarEquipoDeportivo(equipo);
        return "Equipo deportivo agregado correctamente.";
    }

    
    @GetMapping
    public List<ProductoDeportivo> listarProductos() {
        return productoService.listarProductos();
    }

    
    @GetMapping("/{nombre}")
    public ProductoDeportivo buscarProductoPorNombre(@PathVariable String nombre) {
        return productoService.buscarProductoPorNombre(nombre);
    }

    
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

    
    @GetMapping("/precio")
    public List<ProductoDeportivo> filtrarPorPrecio(@RequestParam double minimo, @RequestParam double maximo) {
        return productoService.filtrarPorPrecio(minimo, maximo);
    }

    
    @GetMapping("/buscar/{nombreParcial}")
    public List<ProductoDeportivo> buscarPorNombreParcial(@PathVariable String nombreParcial) {
        return productoService.buscarPorNombreParcial(nombreParcial);
    }

    
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
