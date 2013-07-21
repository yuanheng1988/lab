package io;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Random;

import original.Baseline;

import sampling.AllSample;
import sampling.RandomSample;
import sampling.SMOTESample;
import sampling.SpreadSample;

import iscas.itechs.crossvalidation.straCrossValidation;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.functions.Logistic;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.supervised.instance.RemoveClass;
import weka.filters.supervised.instance.Resample;

public class test {
	
	public static void main(String[] args){
		try {
			String trainingDir = "E:\\data\\NASA_MDP\\D'\\";
			String output_path = "E:\\outputs\\2\\";
			File dir = new File(trainingDir);
			File[] trainingFiles = dir.listFiles();			 

			J48 j48 = new J48();
			NaiveBayes nb = new NaiveBayes();
			RandomForest rf = new RandomForest();
			Logistic logistic = new Logistic();
			Classifier[] classifiers = {j48,nb,rf,logistic};
			
//			String[] sampleMethods ={"resample","SMOTE","spread"};					
			      
/*			for(int i = 0; i < trainingFiles.length; i++){
				for(String sampleMethod:sampleMethods){
					for(Classifier curClassifier:classifiers){
						Instances data = ReadArffFile.readArffData(trainingFiles[1].getAbsolutePath());
						AllSample.allSample(data, sampleMethod, curClassifier, output_path);
					}
				}
			}*/
			
			Instances data = ReadArffFile.readArffData(trainingFiles[0].getAbsolutePath());
//			AllSample.allSample(data, "resample", j48, output_path);
			RemoveClass rc = new RemoveClass();
			rc.setInputFormat(data);
			Instances newData = Filter.useFilter(data, rc);
			SmartFile sf = new SmartFile("E:\\haha.arff",false);
			sf.writeLine(newData.toString());
			sf.close();
			System.out.println(newData.numInstances());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}

}
