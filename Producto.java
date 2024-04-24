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
        COCA("Coca-Cola 550cc", 1000),
        SPRITE("Sprite 550cc", 1000);

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
        PAPAS("Papas rusticas 700g", 990),
        CHOCOLATE("Chocolate Hershey 75g", 1500);

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