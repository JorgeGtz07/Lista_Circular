
package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListaEnlazada<T> implements IList<T>, Iterable<T> {

    protected NodoSimple inicio;
    protected int nElementos;
    private NodoSimple fin;
    private NodoSimple actual;

    private class NodoSimple {
        private T dato;
        private NodoSimple sig;
        private NodoSimple ant;

        public NodoSimple(T dato) {
            this.dato = dato;
        }
    }

    public ListaEnlazada() {
        inicio = null;
        fin = null;
        actual = null;
        nElementos = 0;
    }

    public void irInicio() {
        actual = inicio;
    }

    public void irFinal() {
        actual = fin;
    }

    public void next() {
        if (actual != null) {
            actual = actual.sig;
        }
    }

    public void previous() {
        if (actual != null) {
            actual = actual.ant;
        }
    }

    public T getActual() {
        if (actual == null) {
            return null;
        }

        return actual.dato;
    }

    @Override
    public void append(T elemento) {
        NodoSimple nuevo = new NodoSimple(elemento);

        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
            nuevo.sig = nuevo;
            nuevo.ant = nuevo;
        } else {
            nuevo.ant = fin;
            nuevo.sig = inicio;
            fin.sig = nuevo;
            inicio.ant = nuevo;
            fin = nuevo;
        }

        nElementos++;
    }

    @Override
    public void insert(T elemento, int index) {
        if (index < 0 || index > nElementos) {
            throw new ListException("Indice fuera de limites");
        }

        if (index == nElementos) {
            append(elemento);
            return;
        }

        NodoSimple nuevo = new NodoSimple(elemento);

        if (index == 0) {
            nuevo.sig = inicio;
            nuevo.ant = fin;
            inicio.ant = nuevo;
            fin.sig = nuevo;
            inicio = nuevo;
        } else {
            NodoSimple nodo = inicio;

            for (int i = 0; i < index; i++) {
                nodo = nodo.sig;
            }

            nuevo.sig = nodo;
            nuevo.ant = nodo.ant;
            nodo.ant.sig = nuevo;
            nodo.ant = nuevo;
        }

        nElementos++;
    }

    @Override
    public T remove(int index) {
        if (empty()) {
            throw new ListException("Lista vacia");
        }

        if (index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de limites");
        }

        NodoSimple nodo = inicio;

        for (int i = 0; i < index; i++) {
            nodo = nodo.sig;
        }

        T dato = (T) nodo.dato;

        if (nElementos == 1) {
            inicio = null;
            fin = null;
            actual = null;
        } else {
            nodo.ant.sig = nodo.sig;
            nodo.sig.ant = nodo.ant;

            if (nodo == inicio) {
                inicio = nodo.sig;
            }

            if (nodo == fin) {
                fin = nodo.ant;
            }

            if (actual == nodo) {
                actual = nodo.sig;
            }
        }

        nElementos--;
        return dato;
    }

    @Override
    public boolean removeObj(T elemento) {
        NodoSimple nodo = inicio;

        for (int i = 0; i < nElementos; i++) {
            if (Objects.equals(nodo.dato, elemento)) {
                remove(i);
                return true;
            }

            nodo = nodo.sig;
        }

        return false;
    }

    @Override
    public int indexOf(T elemento) {
        NodoSimple nodo = inicio;

        for (int i = 0; i < nElementos; i++) {
            if (Objects.equals(nodo.dato, elemento)) {
                return i;
            }

            nodo = nodo.sig;
        }

        return -1;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de limites");
        }

        NodoSimple nodo = inicio;

        for (int i = 0; i < index; i++) {
            nodo = nodo.sig;
        }

        return (T) nodo.dato;
    }

    @Override
    public void set(T elemento, int index) {
        if (index < 0 || index >= nElementos) {
            throw new ListException("Indice fuera de limites");
        }

        NodoSimple nodo = inicio;

        for (int i = 0; i < index; i++) {
            nodo = nodo.sig;
        }

        nodo.dato = elemento;
    }

    public void invertir() {
        if (nElementos <= 1) {
            return;
        }

        NodoSimple nodo = inicio;

        for (int i = 0; i < nElementos; i++) {
            NodoSimple temp = nodo.sig;
            nodo.sig = nodo.ant;
            nodo.ant = temp;
            nodo = temp;
        }

        NodoSimple temp = inicio;
        inicio = fin;
        fin = temp;
        actual = inicio;
    }

    public void concatenar(ListaEnlazada<T> otraLista) {
        int cantidad = otraLista.size();

        for (int i = 0; i < cantidad; i++) {
            append(otraLista.get(i));
        }
    }

    @Override
    public void clear() {
        inicio = null;
        fin = null;
        actual = null;
        nElementos = 0;
    }

    @Override
    public boolean empty() {
        return nElementos == 0;
    }

    @Override
    public int size() {
        return nElementos;
    }

    @Override
    public String toString() {
        String texto = "[";
        NodoSimple nodo = inicio;

        for (int i = 0; i < nElementos; i++) {
            texto += nodo.dato;

            if (i < nElementos - 1) {
                texto += ", ";
            }

            nodo = nodo.sig;
        }

        texto += "]";
        return texto;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private NodoSimple nodo = inicio;
            private int contador = 0;

            @Override
            public boolean hasNext() {
                return contador < nElementos;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                T dato = (T) nodo.dato;
                nodo = nodo.sig;
                contador++;

                return dato;
            }
        };
    }
}
