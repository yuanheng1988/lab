package sampling;

import java.text.DecimalFormat;
import java.util.Random;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.filters.supervised.instance.Resample;

public class RandomSample {
	
	//��weka��resample�������г�����ֻ���ѵ�����ݳ������������ݲ����ˣ������ѵ�����ݺͲ�������ָ���ǲ���10-fold cross validation��ġ�
	//��������������classifier��resample������seed������data��sample�ı���bias��nfp��fp=0.5-1����0.05������
	public static String resample(Classifier cf,int seed, Instances data,double bias) throws Exception{
		Resample rs = new Resample();
		rs.setBiasToUniformClass(bias);
		rs.setSampleSizePercent(100);
		rs.setRandomSeed(seed);
		FilteredClassifier fc = new FilteredClassifier();
		fc.setFilter(rs);
		fc.setClassifier(cf);
		fc.buildClassifier(data);
		
		Evaluation eval = new Evaluation(data);
		eval.crossValidateModel(fc, data, 10, new Random(1));
		
		DecimalFormat df = new DecimalFormat("#.0000");
//		System.out.println(eval.toSummaryString());
//		System.out.println(eval.toClassDetailsString());
//		System.out.println("a       b   <-- classified as");
//		System.out.println(eval.confusionMatrix()[0][0] + "  " + eval.confusionMatrix()[0][1] + "  |a = Y");
//		System.out.println(eval.confusionMatrix()[1][0] + "  " + eval.confusionMatrix()[1][1] + "  |b = N");
		String result = bias + "\t" +df.format(eval.areaUnderROC(0)) + "\t" + df.format(eval.truePositiveRate(0)) + "\t" +
							df.format(eval.falsePositiveRate(0)) + "\t" + df.format(eval.fMeasure(0)) + "\t" + df.format(eval.pctCorrect());
//		System.out.println(result);
		return result;
		
	}

}
