package co.edu.uniquindio.poo.stack;

public class Stack<T> {

    private int size;
    private NodeSimple<T> top;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        NodeSimple<T> newNodeSimple = new NodeSimple<>(data);
        if (isEmpty()) {
            top = newNodeSimple;
        } else {
            newNodeSimple.setNext(top);
            top = newNodeSimple;
        }
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        } else {
            T data = top.getData();
            top = top.getNext();
            size--;
            return data;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        }
        return top.getData();
    }

    public Stack<T> clone() {
        Stack<T> auxStack = new Stack<>();
        Stack<T> clonedStack = new Stack<>();

        NodeSimple<T> current = this.top;
        while (current != null) {
            auxStack.push(current.getData());
            current = current.getNext();
        }

        while (!auxStack.isEmpty()) {
            clonedStack.push(auxStack.pop());
        }

        return clonedStack;
    }

    public void print() {
        NodeSimple<T> aux = top;
        while (aux != null) {
            System.out.println("Elemento: " + aux.getData());
            aux = aux.getNext(); // Avanzar al siguiente nodo
        }
    }


    public void addAll(Stack<T> otherStack) {
        if (otherStack == null || otherStack.isEmpty()) {
            return;
        }

        Stack<T> tempStack = otherStack.clone();
        Stack<T> auxStack = new Stack<>();

        while (!tempStack.isEmpty()) {
            auxStack.push(tempStack.pop());
        }

        while (!auxStack.isEmpty()) {
            this.push(auxStack.pop());
        }
    }
    public int getSize() {
        return size;
    }


}
