/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supersupervised;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.collective.functions.LLGC;
import weka.classifiers.collective.evaluation.Evaluation;
/**
 *
 * @author admin
 */
public class SuperSupervised {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            DataSource src = new DataSource("/Users/admin/Documents/NetBeansProjects/SuperSupervised/weather.arff");
            Instances dt = src.getDataSet();
            dt.setClassIndex(dt.numAttributes()-1);
            
            LLGC model = new LLGC();
            model.buildClassifier(dt);
            System.out.println(model.getCapabilities());
            
            Evaluation eval = new Evaluation(dt);
            DataSource src1 = new DataSource("/Users/admin/Documents/NetBeansProjects/SuperSupervised/weather.test.arff");
            Instances tdt = src1.getDataSet();
            tdt.setClassIndex(tdt.numAttributes()-1);
            eval.evaluateModel(model, tdt);
            
            System.out.println(eval.toSummaryString("Evaluation results:\n", false));
		
			System.out.println("Correct % = "+eval.pctCorrect());
			System.out.println("Incorrect % = "+eval.pctIncorrect());
			System.out.println("AUC = "+eval.areaUnderROC(1));
			System.out.println("kappa = "+eval.kappa());
			System.out.println("MAE = "+eval.meanAbsoluteError());
			System.out.println("RMSE = "+eval.rootMeanSquaredError());
			System.out.println("RAE = "+eval.relativeAbsoluteError());
			System.out.println("RRSE = "+eval.rootRelativeSquaredError());
			System.out.println("Precision = "+eval.precision(1));
			System.out.println("Recall = "+eval.recall(1));
			System.out.println("fMeasure = "+eval.fMeasure(1));
			System.out.println("Error Rate = "+eval.errorRate());
			//the confusion matrix
			System.out.println(eval.toMatrixString("=== Overall Confusion Matrix ===\n"));
				
				
			}
	catch(Exception e)
	{
	    System.out.println("Error!!!!\n" + e.getMessage());
	}
    }
    
}
