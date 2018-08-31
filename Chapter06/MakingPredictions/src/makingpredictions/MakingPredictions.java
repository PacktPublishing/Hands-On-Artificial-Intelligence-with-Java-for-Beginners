/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makingpredictions;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;
import weka.core.Instance;

/**
 *
 * @author admin
 */
public class MakingPredictions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        // TODO code application logic here
        try {
            DataSource src = new DataSource("/Users/admin/Documents/NetBeansProjects/MakingPredictions/segment-challenge.arff");
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

            DataSource src1 = new DataSource("/Users/admin/Documents/NetBeansProjects/MakingPredictions/segment-test.arff");
            Instances tdt = src1.getDataSet();
            tdt.setClassIndex(tdt.numAttributes()-1);
             
            System.out.println("ActualClass \t ActualValue \t PredictedValue \t PredictedClass");
            for (int i = 0; i < tdt.numInstances(); i++)
            {
                String act = tdt.instance(i).stringValue(tdt.instance(i).numAttributes()-1);
                double actual = tdt.instance(i).classValue();
                Instance inst = tdt.instance(i);
                double predict = mytree.classifyInstance(inst);
                String pred = inst.toString(inst .numAttributes()-1);
                System.out.println(act + " \t\t " + actual + " \t\t " + predict + " \t\t " + pred);
            }
            
        } 
        catch (Exception e) {
            System.out.println(e.getCause());
        }
    }
    
}
