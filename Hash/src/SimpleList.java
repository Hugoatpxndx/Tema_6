/**
 * @param <T> el tipo de elementos en la lista
 */
public class SimpleList<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public SimpleList() {
        head = null;
        size = 0;
    }

    /**
     * @param data el elemento a insertar
     */
    public void insertarUltimaPosicion(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * @param index el índice del elemento a obtener
     * @return el elemento en la posición especificada
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    public T obtenerElemento(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Elimina el elemento en la posición especificada.
     * @param index el índice del elemento a eliminar
     * @return el elemento que fue eliminado
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    public T eliminar(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        T removedData;
        if (index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node<T> previous = null;
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }
            removedData = current.data;
            previous.next = current.next;
        }
        size--;
        return removedData;
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return size == 0;
    }

    /**
     * Obtiene el tamaño de la lista.
     * @return el número de elementos en la lista
     */
    public int size() {
        return size;
    }
}
