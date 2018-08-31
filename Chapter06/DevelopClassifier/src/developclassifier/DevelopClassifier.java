/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developclassifier;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;
// import the following class to train the classifier using Naive Bayes
import weka.classifiers.bayes.NaiveBayes;
/**
 *
 * @author admin
 */
public class DevelopClassifier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            DataSource src = new DataSource("/Users/admin/Documents/NetBeansProjects/DevelopClassifier/vote.arff");
            Instances dt = src.getDataSet();
            dt.setClassIndex(dt.numAttributes()-1);
            
            String[] options = new String[4];
            options[0] = "-C";
            options[1] = "0.1";
            options[2] = "-M";
            options[3] = "2";
            J48 tree = new J48();
            tree.setOptions(options);
            tree.buildClassifier(dt);
            System.out.println(tree.getCapabilities().toString());
            System.out.println(tree.graph());
            
            //uncomment the following three lines of code for Naive Bayes 
            NaiveBayes nb = new NaiveBayes();
            nb.buildClassifier(dt);
            System.out.println(nb.getCapabilities().toString());
            
            }        
        catch(Exception e){
            System.out.println("Error!!!!\n" + e.getMessage());
        }
    }
    
}
