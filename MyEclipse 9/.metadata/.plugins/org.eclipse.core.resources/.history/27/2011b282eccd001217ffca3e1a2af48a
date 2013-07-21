package jp.co.wap.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import jp.co.wap.exam.lib.Interval;

public class Problem1 {
	
	@SuppressWarnings("unchecked")
	public int getMaxIntervalOverlapCount(List<Interval> intervals){
		Map<Integer,Integer> timeMap = new IdentityHashMap<Integer, Integer>(); 
		for(int i = 0; i < intervals.size();i++){
			timeMap.put(intervals.get(i).getBeginMinuteUnit(), 0);
			timeMap.put(intervals.get(i).getEndMinuteUnit(), 1);
		}
		
//		Map timeTreeMap = new TreeMap(timeMap);
		List<Entry<Integer, Integer>> timelist = new ArrayList<Entry<Integer, Integer>>(timeMap.entrySet());  
        Collections.sort(timelist, new Comparator<Object>() {
			@SuppressWarnings("rawtypes")
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Entry) (o1)).getKey())
						.compareTo(((Entry) (o2)).getKey());
			}
		});  
        
        int count = 0;
        int maxcount = 0;
        for (Entry<Integer, Integer> entry : timelist) {  
//            System.out.println("\t" + entry.getKey() + "\t\t" + entry.getValue());  
            if(entry.getValue().equals(0)){
            	count++;
            	if (count > maxcount)
            		maxcount = count;
            }
            else
            	count--;
        }  

		return maxcount;
		
	}
}


  
	
	


	
