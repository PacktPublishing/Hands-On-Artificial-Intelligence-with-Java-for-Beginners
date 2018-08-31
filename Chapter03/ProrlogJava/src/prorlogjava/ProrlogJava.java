/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prorlogjava;

import java.util.Map;
import jpl.Query;
import jpl.JPL;
/**
 *
 * @author admin
 */
public class ProrlogJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String t1 = "consult('family.pl')";
        System.out.println(t1 + " " + (Query.hasSolution(t1) ? "succeeded" : "failed"));
        String t2 = "child(sonny, vito)";
        System.out.println(t2 + " " + (Query.hasSolution(t2) ? "provable" : "not provable"));
        String t3 = "grandfather(vito, anthony)";
        System.out.println(t3 + " " + (Query.hasSolution(t3) ? "provable" : "not provable"));      
    }
    
}
