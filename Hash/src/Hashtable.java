public class Hashtable<E> {
    public static final int M = 23;
    @SuppressWarnings("unchecked")
    private final SimpleList<HashEntry<E>>[] data;

    private static class HashEntry<E> {
        private final String key;
        private final E value;

        public HashEntry(String key, E value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public E getValue() {
            return value;
        }
    }

    public Hashtable() {
        data = (SimpleList<HashEntry<E>>[]) new SimpleList[M];
        for (int i = 0; i < M; i++) {
            data[i] = new SimpleList<>();
        }
    }

    /**
     * Función hash que calcula el índice basado en la clave
     * @param key La clave para calcular el hash
     * @return El índice en la tabla hash
     */

    private int hashFunction(String key) {
        if (key == null) {
            throw new IllegalArgumentException("La clave no puede ser nula");
        }
        return Math.abs(key.hashCode() % M);
    }

    /**
     * Inserta un elemento en la tabla hash
     * @param key La clave del elemento
     * @param value El valor a insertar
     * @throws IllegalArgumentException si la clave es nula
     */

    public void put(String key, E value) {
        if (key == null) {
            throw new IllegalArgumentException("La clave no puede ser nula");
        }
        int index = hashFunction(key);
        data[index].insertarUltimaPosicion(new HashEntry<>(key, value));
    }

    /**
     * Obtiene un valor de la tabla hash
     * @param key La clave del elemento a buscar
     * @return El valor asociado a la clave, o null si no se encuentra
     */
    public E get(String key) {
        if (key == null) {
            return null;
        }
        int index = hashFunction(key);
        SimpleList<HashEntry<E>> list = data[index];
        
        // Buscar en la lista enlazada
        for (int i = 0; i < list.size(); i++) {
            HashEntry<E> entry = list.obtenerElemento(i);
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null; // No se encontró la clave
    }

    /**
     * Verifica si la tabla contiene una clave
     * @param key La clave a buscar
     * @return true si la clave existe, false en caso contrario
     */
    public boolean containsKey(String key) {
        return get(key) != null;
    }

    /**
     * Elimina un elemento de la tabla hash
     * @param key La clave del elemento a eliminar
     * @return true si se eliminó el elemento, false si no se encontró
     */
    public boolean remove(String key) {
        if (key == null) {
            return false;
        }
        int index = hashFunction(key);
        SimpleList<HashEntry<E>> list = data[index];
        
        // Buscar y eliminar el elemento
        for (int i = 0; i < list.size(); i++) {
            HashEntry<E> entry = list.obtenerElemento(i);
            if (entry.getKey().equals(key)) {
                list.eliminar(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Muestra el contenido de la tabla hash
     */
    public void display() {
        System.out.println("\n=== Tabla Hash ===");
        for (int i = 0; i < M; i++) {
            System.out.print("[" + i + "]: ");
            SimpleList<HashEntry<E>> list = data[i];
            if (list.estaVacia()) {
                System.out.println("Vacío");
            } else {
                for (int j = 0; j < list.size(); j++) {
                    HashEntry<E> entry = list.obtenerElemento(j);
                    System.out.print("(" + entry.getKey() + ", " + entry.getValue() + ") ");
                }
                System.out.println();
            }
        }
        System.out.println("=================\n");
    }
}
