/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savemodel;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;
/**
 *
 * @author admin
 */
public class SaveModel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            DataSource src = new DataSource("/Users/admin/Documents/NetBeansProjects/SaveModel/segment-challenge.arff");
            Instances dt = src.getDataSet();
            dt.setClassIndex(dt.numAttributes() - 1);

            String[] options = new String[4];
            options[0] = "-C";
            options[1] = "0.1";
            options[2] = "-M";
            options[3] = "2";
            J48 mytree = new J48();
            mytree.setOptions(options);
            mytree.buildClassifier(dt);
            
            weka.core.SerializationHelper.write("/Users/admin/Documents/NetBeansProjects/SaveModel/myDT.model", mytree);
        }
        catch (Exception e) {
            System.out.println("Error!!!!\n" + e.getMessage());
        }
    }
    
}
