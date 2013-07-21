package jp.co.wap.exam.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import jp.co.wap.exam.Problem2;
import jp.co.wap.exam.backups.Problem2_original1;
import jp.co.wap.exam.backups.Problem2_original2;
import jp.co.wap.exam.lib.Interval;

public class test2 {
	
	public static void main(String[] args){
		Problem2_original1 p = new Problem2_original1();
		Problem2_original2 p2 = new Problem2_original2();
		Problem2 pdp = new Problem2();
		
		//example:Figure 3
//		List<Interval> figure3 = Arrays.asList(new Interval("06:00","08:30"),
//			new Interval("08:00","09:00"),new Interval("09:00","11:00"),
//			new Interval("09:00","11:30"),new Interval("10:30","14:00"),new Interval("12:30","14:00"));
//		System.out.println(p.getMaxWorkingTime(figure3));
//		
//		//example:Figure 4
//		List<Interval> figure4 = Arrays.asList(new Interval("06:00","08:30"),
//			new Interval("07:00","10:00"),new Interval("10:00","14:00"),
//			new Interval("11:30","14:00"));
//		System.out.println(p.getMaxWorkingTime(figure4));
//		
//		//example:Figure 5
//		List<Interval> figure5 = Arrays.asList(new Interval("06:00","08:30"));
//		System.out.println(p.getMaxWorkingTime(figure5));
		
		//example:Figure 6
		List<Interval> figure6 = Arrays.asList(new Interval("06:00","08:30"),
			new Interval("07:00","11:29"),new Interval("10:00","14:00"),
			new Interval("11:30","14:00"));
		
		long startTime = System.nanoTime();
		System.out.println(p.getMaxWorkingTime(figure6));
		long endTime = System.nanoTime();
		System.out.println("The execute time of original1 is:" + (endTime-startTime) + "ns");
		
		startTime = System.nanoTime();
		System.out.println(p2.getMaxWorkingTime(figure6));
		endTime = System.nanoTime();
		System.out.println("The execute time of original2 is:" + (endTime-startTime) + "ns");
		
		startTime = System.nanoTime();
		System.out.println(pdp.getMaxWorkingTime(figure6));
		endTime = System.nanoTime();
		System.out.println("The execute time of final is:" + (endTime-startTime) + "ns");
		
		//example:figure 7
		List<Interval> figure7 = new ArrayList<Interval>();
		Interval inte;
		String time1;
		String time2;
		for(int i = 0; i< 10000; i++){
			time1 = String.format("%02d", (int)Math.floor(Math.random()*23)) + ":" + String.format("%02d", (int)Math.floor(Math.random()*60));
			time2 = String.format("%02d", (int)Math.floor(Math.random()*23)) + ":" + String.format("%02d", (int)Math.floor(Math.random()*60));
			if (time1.compareTo(time2) > 0)
				inte = new Interval(time2,time1);
			else
				inte = new Interval(time1,time2);
			
//			System.out.println(i + ":" + inte.toString());
			figure7.add(inte);
		}
		
//		startTime = System.nanoTime();
//		System.out.println(p.getMaxWorkingTime(figure7));
//		endTime = System.nanoTime();
//		System.out.println("The execute time of original1 is:" + (endTime-startTime) + "ns");
		
//		startTime = System.nanoTime();
//		System.out.println(p2.getMaxWorkingTime(figure7));
//		endTime = System.nanoTime();
//		System.out.println("The execute time of original2 is:" + (endTime-startTime) + "ns");
		
		startTime = System.nanoTime();
		System.out.println(pdp.getMaxWorkingTime(figure7));
		endTime = System.nanoTime();
		System.out.println("The execute time of final is:" + (endTime-startTime) + "ns");
	}

}
