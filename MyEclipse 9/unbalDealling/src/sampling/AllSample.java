package sampling;


import io.SmartFile;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import original.Baseline;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.functions.Logistic;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;

public class AllSample {
	
	public static void allSample(Instances data, String sampleMethod, Classifier curClassifier, String output_path) throws Exception{
		DecimalFormat df = new DecimalFormat("#.0000");
		
		int fpNum =0;
		int nfpNum = 0;
		for(int i=0;i<data.numInstances();i++){
			if (data.instance(i).classValue() == 0)
				fpNum++;
			else 
				nfpNum++;
		}
		int ratio = nfpNum/fpNum;
//		Random seed = new Random();
//		data.randomize(seed);
//		if(data.classAttribute().isNominal())
//			data.stratify(10);
//		Instances trainingSet = data.trainCV(10, 1);
//		Instances testSet = data.testCV(10, 1);
		
//		trainingSet.resample(seed);
//		System.out.println(trainingSet.instance(0).value(0));
//		System.out.println(testSe.numInstances());
//		System.out.println(testSet.toString());
					
		String orig_result = null;
		String result = null; 
		double sumAUC = 0;
		double sumTPR = 0;
		double sumFPR = 0;
		double sumFMeasure = 0;
		double sumAccuracy = 0;
		
		String[] name = curClassifier.getClass().toString().split("\\.");
		SmartFile sf = new SmartFile(output_path.concat("\\" + data.relationName() + "_" + sampleMethod + "_" + name[name.length-1] + ".txt"),false);
		
  
		for(int j = 1; j <= 10; j++){
			orig_result = Baseline.baseline_classifier(curClassifier, j, data);
			sumAUC += Double.parseDouble(orig_result.split("\t")[0]);
			sumTPR += Double.parseDouble(orig_result.split("\t")[1]);
			sumFPR += Double.parseDouble(orig_result.split("\t")[2]);
			sumFMeasure += Double.parseDouble(orig_result.split("\t")[3]);
			sumAccuracy += Double.parseDouble(orig_result.split("\t")[4]);	
		}
		sf.writeLine(data.relationName() + "_" + sampleMethod + "_" + name[name.length-1]);
		sf.writeLine("Bias\tavgAUC\tavgTPR\tavgFPR\tavgF-measure\tavgAccuracy");
		//original result
		sf.writeLine(df.format((double)fpNum/nfpNum) + "\t" + Double.parseDouble(df.format(sumAUC/10)) + "\t" +
				Double.parseDouble(df.format(sumTPR/10)) + "\t" + Double.parseDouble(df.format(sumFPR/10)) + "\t" +
				Double.parseDouble(df.format(sumFMeasure/10)) + "\t" + Double.parseDouble(df.format(sumAccuracy/10)));
		
		//做sampling
		for(int i = 0; i <= 20; i++){   //用resample时i不能超过10,因为bias超过1和1的效果时一样的
			sumAUC = 0;
			sumTPR = 0;
			sumFPR = 0;
			sumFMeasure = 0;
			sumAccuracy = 0;
			for(int j=1; j<=10;j++){
				if (sampleMethod.equals("resample"))
					result = RandomSample.resample(curClassifier,j, data, Double.parseDouble(df.format(0.5+0.05*i)));
				
				if (sampleMethod.equals("SMOTE"))
					result = SMOTESample.SMOTEsample(curClassifier, j, data, ratio, Double.parseDouble(df.format(0.5+0.05*i)));

				if (sampleMethod.equals("spread")){
					result = SpreadSample.spreadsubsample(curClassifier, j, data, Double.parseDouble(df.format(0.5+0.05*i)));
//					result = SpreadSample.spreadsubsample(j48, j, data, Double.parseDouble(df.format(0.1+0.1*i)));
				}


				sumAUC += Double.parseDouble(result.split("\t")[1]);
				sumTPR += Double.parseDouble(result.split("\t")[2]);;
				sumFPR += Double.parseDouble(result.split("\t")[3]);;
				sumFMeasure += Double.parseDouble(result.split("\t")[4]);;
				sumAccuracy += Double.parseDouble(result.split("\t")[5]);;					
			}
			sf.writeLine(Double.parseDouble(result.split("\t")[0]) + "\t" + Double.parseDouble(df.format(sumAUC/10)) + "\t" +
					Double.parseDouble(df.format(sumTPR/10)) + "\t" + Double.parseDouble(df.format(sumFPR/10)) + "\t" +
					Double.parseDouble(df.format(sumFMeasure/10)) + "\t" + Double.parseDouble(df.format(sumAccuracy/10)));
			System.out.println(Double.parseDouble(result.split("\t")[0]) + "done" + (new SimpleDateFormat()).format(new Date()));
		}
		System.out.println("file:" + data.relationName() + "_" + sampleMethod + "_" + name[name.length-1] + ".txt done.");
		
		sf.close();
	}

}
