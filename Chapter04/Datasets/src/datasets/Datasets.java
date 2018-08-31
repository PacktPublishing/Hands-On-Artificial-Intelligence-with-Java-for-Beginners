/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasets;

/**
 *
 * @author admin
 */
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import java.io.File;
public class Datasets {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
                DataSource src = new DataSource("/Users/admin/wekafiles/data/weather.numeric.arff");
                Instances dt= src.getDataSet();
                
                System.out.println(dt.toSummaryString());
                
                ArffSaver as = new ArffSaver();
                as.setInstances(dt);
                as.setFile(new File("weather.arff"));
                as.writeBatch();
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
