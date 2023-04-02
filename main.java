import java.util.ArrayList;
import java.util.List;

import ea04_MétodosDeOrdenación.*;
import edu.princeton.cs.algs4.StdOut;


public class main<T>
{
    
    public static void main(String [] args) throws Exception
    {
        ListaSimple<String> a = new ListaSimple<>();
        GeneradorADTs g = new GeneradorADTs();

        List<Person> personas = g.generar(10);

        for (Person p : personas)
            a.addHead(p.toString());
       
       ArrayList<String> items = a.sort().imprimir();

        for (String x : items) {
            System.out.println(x);
        }
    
    }
}
