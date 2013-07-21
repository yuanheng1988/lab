package jp.co.wap.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jp.co.wap.exam.lib.Interval;

public class Problem2 {
	private List<Integer> deadlineTime;
	private List<Integer> executeTime;
	private List<Integer> startTime;
	private int[] maxstore = new int[24*60+1];
	
	public int getMaxWorkingTime(List<Interval> intervals){
		Map<Integer,Integer> itervalMap = new IdentityHashMap<Integer, Integer>(); 
		for(int i = 0; i < intervals.size();i++){
			itervalMap.put(intervals.get(i).getEndMinuteUnit(), intervals.get(i).getIntervalMinute());
		}
		
		List<Entry<Integer, Integer>> itervallist = new ArrayList<Entry<Integer, Integer>>(itervalMap.entrySet());  
        Collections.sort(itervallist, new Comparator<Object>() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Entry) (o1)).getKey())
						.compareTo(((Entry) (o2)).getKey());
			}
		});
        
        deadlineTime = new ArrayList<Integer>();
        executeTime = new ArrayList<Integer>();
        startTime = new ArrayList<Integer>();
        for (Entry<Integer, Integer> entry : itervallist) {  
//          System.out.println("\t" + entry.getKey() + "\t\t" + entry.getValue());  
          deadlineTime.add(entry.getKey());
          executeTime.add(entry.getValue());
          startTime.add(entry.getKey()- entry.getValue());
        }
        
        int N=itervallist.size();
        
    	for(int i = 0; i <= 24*60; i++){
    			maxstore[i] = 0; 
    	}
    	for(int i=0;i<N;i++)
    	{
    		for(int j=24*60;j>=0;j--)
    		{
    			if(deadlineTime.get(i)<=j)
    			{
    				if(startTime.get(i)>0)
    				{
    					maxstore[j]=Math.max(maxstore[j],maxstore[startTime.get(i)-1]+ executeTime.get(i));
    				}
    				else
    				{
    					maxstore[j]=Math.max(maxstore[j],executeTime.get(i));
    				}
    			}
    		}
    	}
       
		return maxstore[24*60];
	}
	
}


