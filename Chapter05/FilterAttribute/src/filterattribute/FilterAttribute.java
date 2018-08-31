/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filterattribute;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

/**
 *
 * @author admin
 */
public class FilterAttribute {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            DataSource src = new DataSource("/Users/admin/Documents/NetBeansProjects/Datasets/weather.arff");
            Instances dt = src.getDataSet();
            
            String[] op = new String[]{"-R","2-4"};
            Remove rmv = new Remove();
            rmv.setOptions(op);
            rmv.setInputFormat(dt);
            Instances nd = Filter.useFilter(dt, rmv);
            
            ArffSaver s = new ArffSaver();
            s.setInstances(nd);
            s.setFile(new File("fw.arff"));
            s.writeBatch();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
