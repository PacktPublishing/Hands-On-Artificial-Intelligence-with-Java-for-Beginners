/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arff2csv;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVSaver;
import java.io.File;
/**
 *
 * @author admin
 */
public class Arff2CSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ArffLoader loader = new ArffLoader();
        loader.setSource(new File("/Users/admin/Documents/NetBeansProjects/Datasets/weather.arff"));
        Instances data = loader.getDataSet();
        
        CSVSaver saver = new CSVSaver();
        saver.setInstances(data);
        
        saver.setFile(new File("weather.csv"));
        saver.writeBatch();
    }
    
}
