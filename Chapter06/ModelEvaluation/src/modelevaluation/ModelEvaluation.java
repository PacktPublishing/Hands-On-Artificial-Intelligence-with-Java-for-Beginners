/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelevaluation;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;
import java.util.Random;
/**
 *
 * @author admin
 */
public class ModelEvaluation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            DataSource src = new DataSource("/Users/admin/Documents/NetBeansProjects/ModelEvaluation/segment-challenge.arff");
            Instances dt = src.getDataSet();
            dt.setClassIndex(dt.numAttributes()- 1);

            String[] options = new String[4];
            options[0] = "-C";
            options[1] = "0.1";
            options[2] = "-M";
            options[3] = "2";
            J48 mytree = new J48();
            mytree.setOptions(options);
            mytree.buildClassifier(dt);
            
            Evaluation eval = new Evaluation(dt);
            Random rand = new Random(1);
            
            DataSource src1 = new DataSource("/Users/admin/Documents/NetBeansProjects/ModelEvaluation/segment-test.arff");
            Instances tdt = src1.getDataSet();
            tdt.setClassIndex(tdt.numAttributes() - 1);
            
            eval.evaluateModel(mytree, tdt);
            
            System.out.println(eval.toSummaryString("Evaluation results:\n", false));
                System.out.println("Correct % = " + eval.pctCorrect());
                System.out.println("Incorrect % = " + eval.pctIncorrect());
                System.out.println("kappa = " + eval.kappa());
                System.out.println("MAE = " + eval.meanAbsoluteError());
                System.out.println("RMSE = " + eval.rootMeanSquaredError());
                System.out.println("RAE = " + eval.relativeAbsoluteError());
                System.out.println("Precision = " + eval.precision(1));
                System.out.println("Recall = " + eval.recall(1));
                System.out.println("fMeasure = " + eval.fMeasure(1));
                System.out.println(eval.toMatrixString("=== Overall Confusion Matrix ==="));
        } catch (Exception e) {
            System.out.println("Error!!!!\n" + e.getMessage());
        }
    }
    
}
