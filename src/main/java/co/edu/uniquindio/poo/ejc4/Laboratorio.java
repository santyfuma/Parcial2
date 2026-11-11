package co.edu.uniquindio.poo.ejc4;

import co.edu.uniquindio.poo.tree.NodoABB;

public class Laboratorio {

    /**
     * Retorna cuántos equipos tienen un código dentro del rango [limiteInferior, limiteSuperior],
     * incluidos los extremos. Aprovecha el orden del ABB para omitir los subárboles que no
     * pueden aportar resultados. Si el árbol está vacío o el límite inferior supera al
     * superior, retorna cero.
     */
    public static int contarEquiposEnRango(NodoABB<Integer> raiz, int limiteInferior, int limiteSuperior) {
        if (raiz == null || limiteInferior > limiteSuperior) {
            return 0;
        }

        int codigo = raiz.getElemento();

        // El código está por debajo del rango: solo puede haber resultados a la derecha
        if (codigo < limiteInferior) {
            return contarEquiposEnRango(raiz.getDerecho(), limiteInferior, limiteSuperior);
        }

        // El código está por encima del rango: solo puede haber resultados a la izquierda
        if (codigo > limiteSuperior) {
            return contarEquiposEnRango(raiz.getIzquierdo(), limiteInferior, limiteSuperior);
        }

        // El código está dentro del rango (extremos incluidos): cuenta y revisa ambos lados
        return 1
                + contarEquiposEnRango(raiz.getIzquierdo(), limiteInferior, limiteSuperior)
                + contarEquiposEnRango(raiz.getDerecho(), limiteInferior, limiteSuperior);
    }
}
