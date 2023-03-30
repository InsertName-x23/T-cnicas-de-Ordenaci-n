import java.util.ArrayList;
import java.util.Iterator;

/**
 * ListaSimple : Implementacion basica de la lista simplemente enlazada
 * Se proponen como ejercicios operaciones adicionales de la 
 * la lista simple.
 * 
 * @author: Jorge Londoño
 * 
 */
public class ListaSimple<T extends Comparable<T>> implements Iterable<T>, Comparable<T> {

    /**
     * Nodo representa un nodo de la lista simplemente enlazada
     */
    protected class Nodo {
        T item;
        Nodo sig;
    }

    @Override
    public int compareTo(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    private Nodo first=null;
    private int n=0;

    /**
     * Agregar un item a la cabeza de la lista
     * @param item
     */
    public void addHead(T item) {
        Nodo x = new Nodo();
        x.item = item;
        x.sig = first;
        first = x;
        n++;
    }

    /**
     * Remover el primer nodo de la lista
     * @return item contenido en el nodo eliminado
     * @throws Exception
     */
    public T removeHead() throws Exception {
        if (first == null)
            throw new Exception("Lista vacia");
        T i = first.item;
        first = first.sig;
        n--;
        return i;
    }

    /**
     * True si la lista esta vacia
     * @return
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * @return Longitud de la lista
     */
    public int size() {
        return n;
    }

    public void fusionar(ListaSimple<T> a){
        ultimo().sig = a.first;
        a.first = first;
    }

    public Nodo primero(){
        return first; 
    }

    public Nodo ultimo(){
        Nodo tmp = new Nodo();

        for(Nodo x = first; x != null; x=x.sig){
            if(x.sig == null){
                tmp = x;
            }
        }
        return tmp;
    }

    public ArrayList<T> imprimir(){

        ArrayList<T> lista = new ArrayList<>();

        for(Nodo x=first; x!=null;x=x.sig){
            lista.add(x.item);
        }
        return lista;
    }

    /**
     * Obtener un iterador para la lista
     */
    @Override
    public Iterator<T> iterator() {
        return new IteradorLista();
    }

    /**
     * Implementacion del iterador para la lista simple
     */
    private class IteradorLista implements Iterator<T> {

        private Nodo pos = first;

        @Override
        public boolean hasNext() {
            return pos!=null;
        }

        @Override
        public T next() {
            T i = pos.item;
            pos = pos.sig;
            return i;
        }

    }

    /*
     *   Ejercicios: Implementar los siguientes métodos
     */

    /** Remueve el ultimo elemento de la lista */
    public T removeLast() { return null; }

    /** Agregar un elemento al final de la lista */
    public void addLast() {  }

    /** Obtener el item en la i-ésima posición de la lista */
    public T get(int i) { return null; }

    /** Insertar un item en la i-ésima posición de la lista */
    public void insert(int i, T dato) { }

    /** remueve el item de la i-ésima posición de la lista */
    public T remove(int i) { return null; }

    /** Obtener una nueva ListaSimple con todos los items en orden inverso */
    public ListaSimple<T> invert() { return null; }

    /** Dividir una lista en dos mitades */
    public Object[] splitList() {
        int cnt = 0;
        ListaSimple<T> lista1 = new ListaSimple<>();
        ListaSimple<T> lista2 = new ListaSimple<>();
        for(Nodo x=first; x!=null;x=x.sig)
        {
            if(cnt <= n/2) lista1.addHead(x.item);
                else lista2.addHead(x.item);
            cnt++;
        }
        Object[] array = new Object[2];
        array[0] = lista1;
        array[1] = lista2;
        return array; 
    }

    public static void main(String[] args) throws Exception {
        
        // Implementación de algunas pruebas unitarias
        ListaSimple<Integer> l = new ListaSimple<>();
        assert(l.size()==0);
        l.addHead(1);
        assert(l.size()==1);
        int x = l.removeHead();
        assert(x==1);
        assert(l.size()==0);
    }
}