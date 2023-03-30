import java.util.ArrayList;

public class Taller_2<T>{
    
    public static void main(String [] args){
        ListaSimple<Integer> a = new ListaSimple<>();
        a.addHead(5);
        a.addHead(2);

        ListaSimple<Integer> b = new ListaSimple<>();
        b.addHead(3);
        b.addHead(4);

        a.fusionar(b);

        ArrayList<Integer> items = new ArrayList<>();
        items = a.imprimir();

        for (Integer x : items) {
            System.out.println(x);
        }
        
    }

    @Override
    public int compareTo(T o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
