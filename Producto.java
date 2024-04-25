enum Producto {
    BEBIDA {
        public String toString() {
            return "Bebida";
        }
    },
    SNACK {
        public String toString() {
            return "Snack";
        }
    };
    
    enum Bebida {
        COCA("Coca-Cola 550cc", 300),
        SPRITE("Sprite 550cc", 400),
        FANTA("Fanta 550cc", 500);

        private final String nombre;
        private final int precio;

        Bebida(String nombre, int precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public int getPrecio() {
            return precio;
        }
    }

    enum Snack {
        PAPAS("Papas rusticas 70g", 100),
        CHOCOLATE("Chocolate Hershey 75g", 200);

        private final String nombre;
        private final int precio;

        Snack(String nombre, int precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public int getPrecio() {
            return precio;
        }
    }
}