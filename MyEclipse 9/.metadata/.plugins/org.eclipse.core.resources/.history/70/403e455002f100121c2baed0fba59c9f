package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class FullPermutationNonRecursion {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		char[] str = scanner.next().toCharArray();
		Arrays.sort(str);
		System.out.println(String.valueOf(str));
		while(getNextPerm(str) == true){
			System.out.println(String.valueOf(str));
		}
	}
	
	private static boolean getNextPerm(char[] perm){
		int i;
		for(i = perm.length-1; i > 0;){
			if(perm[i] <= perm[i-1]){
				i--;
			}
			else
				break;
		}
		if(i > 0){
			i--;
			for(int j = perm.length-1; j > i; j--){
				if(perm[j] > perm[i]){
					char tmp = perm[j];
					perm[j] = perm[i];
					perm[i] = tmp;
					break;
				}
			}
			int len = perm.length;
			for(int k = i + 1; k <= (len + i)/2; k++){
				char tmp = perm[k];
				perm[k] = perm[len-1-k+(i+1)];
				perm[len-1-k+(i+1)] = tmp;
			}
			return true;
		}
		else
			return false;
	}
}

