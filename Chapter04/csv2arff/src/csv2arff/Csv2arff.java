/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv2arff;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import java.io.File;

/**
 *
 * @author admin
 */
public class Csv2arff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File("/Users/admin/Documents/NetBeansProjects/Arff2CSV/weather.csv"));
        Instances data = loader.getDataSet();

        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);

        saver.setFile(new File("weather.arff"));
        saver.writeBatch();
    }
    
}
