package FuncionamientoExpendedor;

/**
 * Enumeración Producto que representa los tipos de productos disponibles.
 */
enum Producto {
    /**
     * Tipo de producto: Bebida.
     */
    BEBIDA {
        public String toString() {
            return "Bebida";
        }
    },
    /**
     * Tipo de producto: Snack.
     */
    SNACK {
        public String toString() {
            return "Snack";
        }
    };

    /**
     * Enumeración Bebida que representa los tipos de bebidas disponibles.
     */
    enum Bebida {
        /**
         * Bebida: Coca-Cola 550cc.
         */
        COCA("Coca-Cola 550cc", 300),
        /**
         * Bebida: Sprite 550cc.
         */
        SPRITE("Sprite 550cc", 400),
        /**
         * Bebida: Fanta 550cc.
         */
        FANTA("Fanta 550cc", 500);

        private final String nombre;
        private final int precio;

        /**
         * Constructor de la enumeración Bebida.
         * @param nombre Nombre de la bebida.
         * @param precio Precio de la bebida.
         */
        Bebida(String nombre, int precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        /**
         * Método para obtener el nombre de la bebida.
         * @return Nombre de la bebida.
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Método para obtener el precio de la bebida.
         * @return Precio de la bebida.
         */
        public int getPrecio() {
            return precio;
        }
    }

    /**
     * Enumeración Snack que representa los tipos de snacks disponibles.
     */
    enum Snack {
        /**
         * Snack: Papas rusticas 70g.
         */
        PAPAS("Papas rusticas 70g", 100),
        /**
         * Snack: Chocolate Hershey 75g.
         */
        CHOCOLATE("Chocolate Hershey 75g", 200);

        private final String nombre;
        private final int precio;

        /**
         * Constructor de la enumeración Snack.
         * @param nombre Nombre del snack.
         * @param precio Precio del snack.
         */
        Snack(String nombre, int precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        /**
         * Método para obtener el nombre del snack.
         * @return Nombre del snack.
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Método para obtener el precio del snack.
         * @return Precio del snack.
         */
        public int getPrecio() {
            return precio;
        }
    }
}
