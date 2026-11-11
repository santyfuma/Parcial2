package co.edu.uniquindio.poo.queue;

public class Queue<T> {

    private int size;
    private NodeSimple<T> firstNode;
    private NodeSimple<T> lastNode;

    /**
     * Constructor de la clase Cola.
     * Inicializa una cola vacía estableciendo el tamaño en 0 y
     * los punteros del primer y último nodo en null.
     */
    public Queue() {
        this.size = 0;
        firstNode = null;
        lastNode = null;
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return firstNode == null;
    }


    public void encolar(T data) {
        NodeSimple<T> newNodeSimple = new NodeSimple<>(data);
        if (isEmpty()) {
            firstNode = newNodeSimple;
            lastNode = newNodeSimple;
        } else {
            lastNode.setNext(newNodeSimple);
            lastNode = newNodeSimple;
        }
        size++;
    }


    public T desencolar() {
        if (isEmpty()) {
            throw new RuntimeException("La cola esta vacia");
        } else {
            T data = firstNode.getData();
            firstNode = firstNode.getNext();
            if (firstNode == null) {
                lastNode = null;
            }
            size--;
            return data;
        }
    }

    public Queue<T> clonarCola() {
        Queue<T> colaClon = new Queue<>();
        NodeSimple<T> actual = firstNode;

        while (actual != null) {
            colaClon.encolar(actual.getData());
            actual = actual.getNext();
        }

        return colaClon;
    }


    public boolean sonIdenticas(Queue<T> otraCola) {
        if (this.size != otraCola.size) {
            return false;
        }

        NodeSimple<T> actual1 = this.firstNode;
        NodeSimple<T> actual2 = otraCola.firstNode;

        while (actual1 != null && actual2 != null) {
            if (!actual1.getData().equals(actual2.getData())) {
                return false;
            }
            actual1 = actual1.getNext();
            actual2 = actual2.getNext();
        }

        return true;
    }


    public void invertirColaRecursivo() {
        if (!isEmpty()) {
            T data = desencolar();
            invertirColaRecursivo();
            encolar(data);
        }
    }


    public void invertirColaConPila() {
        java.util.Stack<T> pilaAuxiliar = new java.util.Stack<>();

        // Vaciamos la cola y pasamos todo a la pila
        while (!isEmpty()) {
            pilaAuxiliar.push(desencolar());
        }

        // Sacamos de la pila y volvemos a llenar la cola (quedará invertida)
        while (!pilaAuxiliar.isEmpty()) {
            encolar(pilaAuxiliar.pop());
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("La cola esta vacia");
        }
        return firstNode.getData();
    }

    public void print() {
        NodeSimple<T> aux = firstNode;
        while (aux != null) {
            System.out.println("Elemento: " + aux.getData());
            aux = aux.getNext();
        }
    }

}
