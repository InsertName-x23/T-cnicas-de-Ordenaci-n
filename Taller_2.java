import java.util.ArrayList;


public class Taller_2<T>{
    
    public static void main(String [] args){
        ListaSimple<Integer> a = new ListaSimple<>();
        a.addHead(5);
        a.addHead(2);

        ListaSimple<Integer> b = new ListaSimple<>();
        b.addHead(3);
        b.addHead(4);
        b.addHead(7);

        a.fusionar(b);

        ArrayList<Integer> items = new ArrayList<>();
        
        Object[] lista =  a.splitList();
        items = ((ListaSimple<Integer>)lista[0]).imprimir();

        for (Integer x : items) {
            System.out.println(x);
        }

    }


}
