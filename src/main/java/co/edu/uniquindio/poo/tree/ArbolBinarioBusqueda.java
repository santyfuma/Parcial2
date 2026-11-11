package co.edu.uniquindio.poo.tree;

public class ArbolBinarioBusqueda<T extends Comparable<T>> {
    private NodoABB<T> raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    public NodoABB<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoABB<T> raiz) {
        this.raiz = raiz;
    }

    // ==========================================
    // INSERTAR
    // ==========================================
    public void insertar(T elemento) {
        raiz = insertar(raiz, elemento);
    }

    private NodoABB<T> insertar(NodoABB<T> raizAux, T elemento) {
        if (raizAux == null) {
            return new NodoABB<>(elemento);
        }

        int comp = raizAux.getElemento().compareTo(elemento);

        if (comp == 0) {
            throw new RuntimeException("Error: Ya existe ese elemento");
        }

        if (comp > 0) {
            raizAux.setIzquierdo(insertar(raizAux.getIzquierdo(), elemento));
        } else {
            raizAux.setDerecho(insertar(raizAux.getDerecho(), elemento));
        }
        return raizAux;
    }

    // ==========================================
    // EXISTE
    // ==========================================
    public boolean existe(T elemento) {
        return existe(raiz, elemento);
    }

    private boolean existe(NodoABB<T> raizAux, T elemento) {
        if (raizAux == null) {
            return false;
        }

        int comp = raizAux.getElemento().compareTo(elemento);

        if (comp == 0) {
            return true;
        }

        if (comp > 0) {
            return existe(raizAux.getIzquierdo(), elemento);
        } else {
            return existe(raizAux.getDerecho(), elemento);
        }
    }

    // ==========================================
    // ELIMINAR (con el mayor del subárbol izquierdo)
    // ==========================================
    public void eliminar(T elemento) {
        raiz = eliminar(raiz, elemento);
    }

    private NodoABB<T> eliminar(NodoABB<T> nodo, T elemento) {
        if (nodo == null) {
            throw new RuntimeException("Error: No existe ese elemento");
        }

        int comp = nodo.getElemento().compareTo(elemento);

        if (comp > 0) {
            nodo.setIzquierdo(eliminar(nodo.getIzquierdo(), elemento));
        } else if (comp < 0) {
            nodo.setDerecho(eliminar(nodo.getDerecho(), elemento));
        } else {
            // Caso 1 y 2: sin hijos o con un solo hijo
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            }
            if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            // Caso 3: dos hijos. Se reemplaza por el mayor del subárbol izquierdo
            NodoABB<T> mayorIzquierda = obtenerMayor(nodo.getIzquierdo());
            nodo.setElemento(mayorIzquierda.getElemento());
            nodo.setIzquierdo(eliminar(nodo.getIzquierdo(), mayorIzquierda.getElemento()));
        }
        return nodo;
    }

    private NodoABB<T> obtenerMayor(NodoABB<T> nodo) {
        while (nodo.getDerecho() != null) {
            nodo = nodo.getDerecho();
        }
        return nodo;
    }

    // ==========================================
    // RECORRIDOS
    // ==========================================
    public void recorrerInorden() {
        recorrerInorden(raiz);
    }

    private void recorrerInorden(NodoABB<T> nodo) {
        if (nodo == null) return;
        recorrerInorden(nodo.getIzquierdo());
        System.out.print(nodo.getElemento() + " ");
        recorrerInorden(nodo.getDerecho());
    }

    public void recorrerPreorden() {
        recorrerPreorden(raiz);
    }

    private void recorrerPreorden(NodoABB<T> nodo) {
        if (nodo == null) return;
        System.out.print(nodo.getElemento() + " ");
        recorrerPreorden(nodo.getIzquierdo());
        recorrerPreorden(nodo.getDerecho());
    }

    public void recorrerPostorden() {
        recorrerPostorden(raiz);
    }

    private void recorrerPostorden(NodoABB<T> nodo) {
        if (nodo == null) return;
        recorrerPostorden(nodo.getIzquierdo());
        recorrerPostorden(nodo.getDerecho());
        System.out.print(nodo.getElemento() + " ");
    }

    // ==========================================
    // PESO (cantidad de nodos)
    // ==========================================
    public int obtenerPeso() {
        return obtenerPeso(raiz);
    }

    private int obtenerPeso(NodoABB<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + obtenerPeso(nodo.getIzquierdo()) + obtenerPeso(nodo.getDerecho());
    }
}
