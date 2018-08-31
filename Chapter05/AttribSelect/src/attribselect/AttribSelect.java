/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attribselect;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;

/**
 *
 * @author admin
 */
public class AttribSelect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
              DataSource src = new DataSource("/Users/admin/Documents/NetBeansProjects/Datasets/weather.arff");
              Instances dt = src.getDataSet();
              
              AttributeSelection asel = new AttributeSelection();
              
              CfsSubsetEval evl = new CfsSubsetEval();
              GreedyStepwise sh = new GreedyStepwise();
              
              asel.setEvaluator(evl);
              asel.setSearch(sh);
              asel.setInputFormat(dt);
              
              Instances nd = Filter.useFilter(dt, asel);
              ArffSaver as = new ArffSaver();
              as.setInstances(nd);
              as.setFile(new File("weather-sel.arff"));
              as.writeBatch();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
