package dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Platform{
	int leftX;
	int rightX;
	int height;
}
public class Jimmy {
	static int MAX_NUM = 1000; 
	static int INFINITE = 1000000;
	static int platformNum;
	static int maxH;
	static Platform[] platforms = new Platform[MAX_NUM + 10]; 
	static int aLeftMinTime[] = new int[MAX_NUM + 10];
	static int aRightMinTime[] = new int[MAX_NUM + 10];
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int testNum = scanner.nextInt();
		for(int t = 0; t < testNum; t++){
			platformNum = scanner.nextInt();
			Arrays.fill(platforms, new Platform());
			Arrays.fill(aLeftMinTime, -1);
			Arrays.fill(aRightMinTime, -1);
			platforms[0] = new Platform();
			platforms[0].leftX = scanner.nextInt();
			platforms [0].rightX = platforms[0].leftX;
			platforms[0].height = scanner.nextInt();
			maxH = scanner.nextInt();
			for(int i = 1; i <= platformNum; i++){
				platforms[i] = new Platform();
				platforms[i].leftX = scanner.nextInt();
				platforms[i].rightX = scanner.nextInt();
				platforms[i].height = scanner.nextInt();
			}
			Arrays.sort(platforms, new Comparator<Platform>() {
	            public int compare(Platform p1, Platform p2) {
	            		return ((Comparable)p2.height).compareTo(p1.height);
	            }
			}); 
			/*for(int i = 0; i < platforms.length; i++){
				if(platforms[i].height == 0)
					continue;
				System.out.println(platforms[i].height);
			}*/
			System.out.println(MinTime(0,platforms[0].leftX) + platforms[0].height);
		}
	}
	public static int MinTime(int index, int x){
		int y = platforms[index].height;
		int i;
		for(i = index+1; i <= platformNum; i++){
			if(platforms[i].leftX <= x && platforms[i].rightX >= x)
				break;
		}
		if(i <= platformNum){
			if(y - platforms[i].height > maxH)
				return INFINITE;
		}
		else{
			if(y > maxH)
				return INFINITE;
			else
				return 0;
		}
		if(aLeftMinTime[i] == -1)
			aLeftMinTime[i] = MinTime(i,platforms[i].leftX);
		if(aRightMinTime[i] == -1)
			aRightMinTime[i] = MinTime(i,platforms[i].rightX);
		int curLeftTime = aLeftMinTime[i] + x - platforms[i].leftX;
		int curRightTime = aRightMinTime[i] + platforms[i].rightX - x;
		return Math.min(curLeftTime, curRightTime);
	}
}
