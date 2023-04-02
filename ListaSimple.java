import java.lang.reflect.Array;
import java.rmi.server.ObjID;
import java.util.ArrayList;
import java.util.Iterator;

import javax.management.ObjectName;

/**
 * ListaSimple : Implementacion basica de la lista simplemente enlazada
 * Se proponen como ejercicios operaciones adicionales de la 
 * la lista simple.
 * 
 * @author: Jorge Londoño
 * 
 */
public class ListaSimple<T extends Comparable<T>> implements Iterable<T>, Comparable<T> {

    private Nodo first=null;
    private int n=0;

    private class Nodo{
        T item;
        Nodo sig;
    }

    @Override
    public int compareTo(T item) {
        if (this.getValor() instanceof String && item instanceof String) {
            int space1 = ((String) item).indexOf(" ");
            int space2 = ((String) getValor()).indexOf(" ");
            char letra1 = ((String)item).charAt(0);
            char letra2 = ((String)  getValor()).charAt(0);
            int var = 0;
            
            while (space1 != -1 || space2 != -1) {
                if(Character.compare(letra1, letra2) > 0) var = 1;
                else if(Character.compare(letra1, letra2) < 0) var = -1;
                else var = 0;
                space1 = ((String) item).indexOf(" ", space1 + 1);
                space2 = ((String) getValor()).indexOf(" ", space2 + 1);
                letra1 = ((String) item).charAt(space1 +1);
                letra2 = ((String)  getValor()).charAt(space2 + 1);
            }
            return var;
        } else {
            return compareTo(item);
        }
        
    }
    public Object getValor(){
        return this.primero().item;
        
        
    }
    @Override
    public Iterator<T> iterator() {
        return new IteradorLista();
    }
    public void addHead(T item) {
        Nodo x = new Nodo();
        x.item = item;
        x.sig = first;
        first = x;
        n++;
    }

    public T removeHead() throws Exception {
        if (first == null)
            throw new Exception("Lista vacia");
        T i = first.item;
        first = first.sig;
        n--;
        return i;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public int size() {
        return n;
    }
    public Nodo primero(){
        return first; 
    }
    public void union(ListaSimple<T> a){
        n = size() + a.size();
        ultimo().sig = a.first;
        a.first = first;
    }

    public ListaSimple<T> marge(ListaSimple<T> a){
        int lo = 0;
        int mid = size();
        union(a);
        int hi = size();
        ArrayList<T> lista = imprimir();
        ArrayList<T> aux = new ArrayList<>(lista);
        int i = lo;
        int j = mid;
        for (int k = lo; k < hi; k++) {
            if      (i >= mid)              lista.set(k, aux.get(j++));
            else if (j >= hi)               lista.set(k, aux.get(i++));
            else if (aux.get(j).compareTo(aux.get(i)) < 0) lista.set(k, aux.get(j++));
            else                           lista.set(k, aux.get(i++));
        }
        ListaSimple<T> b =  new ListaSimple<>();
        for (int k = size()-1; k >= 0; k--) {
            b.addHead(lista.get(k));
        }

        return b;
    }

     
    public ListaSimple<T> sort() throws Exception{
        boolean par = false;
        int cnt = 0;
        int cnt2 = 0;
        ListaSimple<T> b = new ListaSimple<>();;
        Object[] aux = new Object[size()];    
        for(Nodo x=primero(); x!=null;x=x.sig)
        {
            b = new ListaSimple<>();
            b.addHead(x.item);
            aux[cnt++] = b;
        }
        while(cnt != 1){
            par = (cnt%2 == 0)?true:false;
            cnt2 = (cnt == aux.length)?aux.length:cnt;
            cnt = 0;
            for (int i = 0; i < cnt2; i++) 
            {
                b = new ListaSimple<>();
                if(i == cnt2-1 && !par) aux[cnt++] = aux[i];
                else
                {
                    b=((ListaSimple<T>) aux[i]).marge((ListaSimple<T>) aux[++i]);
                    aux[cnt++] = b;
                }   
            }
        }
        return (ListaSimple<T>) aux[0];
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

        for(Nodo x=primero(); x!=null;x=x.sig){
            lista.add(x.item);
        }
        return lista;
    }

    /**
     * Obtener un iterador para la lista
     */


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
        for(Nodo x=primero(); x!=null;x=x.sig)
        {
            if(cnt <= n/2) {
                lista1.addHead(x.item);
                lista1.n = cnt;
            }
            else{
                first = x;
                lista2.addHead(x.item);
                lista1.n = cnt;
            }
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