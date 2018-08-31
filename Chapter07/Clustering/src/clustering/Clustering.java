/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustering;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.clusterers.SimpleKMeans;
/**
 *
 * @author admin
 */
public class Clustering {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            DataSource src = new DataSource("/Users/admin/Documents/NetBeansProjects/Clustering/weather.arff");
            Instances dt = src.getDataSet();
            SimpleKMeans model = new SimpleKMeans();
            model.setNumClusters(3);
            model.buildClusterer(dt);
            System.out.println(model);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
