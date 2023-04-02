import java.util.ArrayList;


public class Taller_2<T>
{
    
    public static void main(String [] args) throws Exception
    {
        ListaSimple<Integer> a = new ListaSimple<>();
        a.addHead(20);
        a.addHead(15);
        a.addHead(40);
        a.addHead(34);
        a.addHead(80);
        ListaSimple<Integer> b = new ListaSimple<>();
        b.addHead(22);
    //    ArrayList<Integer> items = new ArrayList<>();
     //   ListaSimple<Integer> items = a.marge(b);
     //   Object[] lista =  a.splitList();
        ArrayList<Integer> items = a.sort().imprimir();

        
        for (Integer x : items) {
            System.out.println(x);
        }

    }
}
