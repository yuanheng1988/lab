package original;

import java.text.DecimalFormat;
import java.util.Random;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;

public class Baseline {
	
	public static String baseline_classifier(Classifier cf,int seed, Instances data) throws Exception{
		DecimalFormat df = new DecimalFormat("#.0000");
		cf.buildClassifier(data);
		
		Evaluation eval = new Evaluation(data);
		eval.crossValidateModel(cf, data, 10, new Random(seed));
		
		String result =  df.format(eval.areaUnderROC(0)) + "\t" + df.format(eval.truePositiveRate(0)) + "\t" +
				df.format(eval.falsePositiveRate(0)) + "\t" + df.format(eval.fMeasure(0)) + "\t" + df.format(eval.pctCorrect());
		
//		System.out.println(result);
		return result;
		
	}

}
