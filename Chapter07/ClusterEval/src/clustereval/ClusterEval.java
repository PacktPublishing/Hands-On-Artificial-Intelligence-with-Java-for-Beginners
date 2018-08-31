/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustereval;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.clusterers.SimpleKMeans;
import weka.clusterers.ClusterEvaluation;
/**
 *
 * @author admin
 */
public class ClusterEval {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            DataSource src = new DataSource("/Users/admin/Documents/NetBeansProjects/ClusterEval/weather.arff");
            Instances dt = src.getDataSet();
            SimpleKMeans model = new SimpleKMeans();
            model.setNumClusters(3);
            model.buildClusterer(dt);
            System.out.println(model);
            
            ClusterEvaluation eval = new ClusterEvaluation();
            DataSource src1 = new DataSource("/Users/admin/Documents/NetBeansProjects/ClusterEval/weather.test.arff");
            Instances tdt = src1.getDataSet();
            eval.setClusterer(model);
            eval.evaluateClusterer(tdt);
            
            System.out.println(eval.clusterResultsToString());
            System.out.println("# of clusters: " + eval.getNumClusters());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
