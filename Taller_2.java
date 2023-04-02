import java.util.ArrayList;


public class Taller_2<T>
{
    
    public static void main(String [] args) throws Exception
    {
        ListaSimple<String> a = new ListaSimple<>();
        a.addHead("Diego Ospina");
        a.addHead("Diego Gonzalez");
       

        ListaSimple<String> b = new ListaSimple<>();
        b.addHead("Diego Ospina");
    //    ArrayList<Integer> items = new ArrayList<>();
     //   ListaSimple<Integer> items = a.marge(b);
     //   Object[] lista =  a.splitList();
       ArrayList<String> items = a.sort().imprimir();

        
        for (String x : items) {
            System.out.println(x);
        }
    
    
    String s1 = "Diego Gonzalez";
    String s2 = "Diego Ospina";
    
    }
}
