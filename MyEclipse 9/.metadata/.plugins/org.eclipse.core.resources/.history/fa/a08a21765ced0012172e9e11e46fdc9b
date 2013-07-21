package dp;

/*
 * ≤‚ ‘ ˝æ›£∫
4 2
1 2
2 3
4 7
6 2
 */

import java.util.Arrays;
import java.util.Scanner;

public class jury {
	static final int MAX_NUM = 200;
	static final int MAX_OUT = 20;
	static final int INFINITE = 10000;
	static int[] pScore = new int[MAX_NUM + 10];
	static int[] nScore = new int[MAX_NUM + 10];
	static int[] diff = new int[MAX_NUM + 10];
	static int[] sum = new int[MAX_NUM + 10];
	static int[][] alldiff = new int[MAX_NUM + 10][MAX_OUT + 10];
	static int[][] allsum = new int[MAX_NUM + 10][MAX_OUT + 10];
	static int[][] path = new int[MAX_OUT + 10][MAX_OUT + 10];
	static int[] ans = new int[MAX_OUT + 10];
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int nCaseNo = 0;
		while((n + m) != 0){
			nCaseNo++;
			for(int i = 1;i <= n; i++){
				pScore[i] = scanner.nextInt();
				nScore[i] = scanner.nextInt();
				diff[i] = pScore[i] - nScore[i];
				sum[i] = pScore[i] + nScore[i];
			}
			Arrays.fill(alldiff[0], 0);
			for(int i = 1; i <=n; i++){
				alldiff[i][0] = 0;
			}
			for(int i = 1; i <= n; i++){
				for(int j = 1;j<=i && j <= m; j++){
					if(i == j){
						alldiff[i][j] = alldiff[i-1][j-1] + diff[i];
						allsum[i][j] = allsum[i-1][j-1] + sum[i];
						path[i][j] = i;
					}
					else if(Math.abs(alldiff[i-1][j-1] + diff[i]) < Math.abs(alldiff[i-1][j])){
						alldiff[i][j] = alldiff[i-1][j-1] + diff[i];
						allsum[i][j] = allsum[i-1][j-1] + sum[i];
						path[i][j] = i;
					}
					else if(Math.abs(alldiff[i-1][j-1] + diff[i]) == Math.abs(alldiff[i-1][j])){
						if(Math.abs(allsum[i-1][j-1] + sum[i]) > allsum[i-1][j]){
							alldiff[i][j] = alldiff[i-1][j-1] + diff[i];
							allsum[i][j] = allsum[i-1][j-1] + sum[i];
							path[i][j] = i;
						}
					}
					else{
						alldiff[i][j] = alldiff[i-1][j];
						allsum[i][j] = allsum[i-1][j];
						path[i][j] = 0;
					}
				}
			}
			int sum4p = 0;
			int sum4n = 0;
			int k = m;
			int index = 0;
			for(int i = n; i >= 1; i--){
				if(path[i][k] != 0){
					index++;
					ans[index] = path[i][k];
					sum4p += pScore[path[i][k]];
					sum4n += nScore[path[i][k]];
					k--;
				}
			}
			System.out.println("Jury #" + nCaseNo + "\nBest jury has value " + sum4p + " for prosecution and value " + sum4n + " for defence:");
			for(int i = m; i > 1; i--){
				System.out.print(ans[i] + " ");
			}
			System.out.println(ans[1]);
			n = scanner.nextInt();
			m = scanner.nextInt();
		}
	}
}
