package co.edu.umanizales.deportive_shop.model;

public class RopaDeportiva extends ProductoDeportivo {
    
        private String talla;
        private String material;
    
        
        public RopaDeportiva(String nombre, double precio, String talla, String material) {
            super(nombre, precio);
            this.talla = talla;
            this.material = material;
        }
    
        
        public String getTalla() {
            return talla;
        }
    
        public void setTalla(String talla) {
            this.talla = talla;
        }
    
        public String getMaterial() {
            return material;
        }
    
        public void setMaterial(String material) {
            this.material = material;
        }
}
