package spoj;

import java.util.HashSet;
import java.util.Scanner;

public class DQuery1 {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int a[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		int q = in.nextInt();
		
		while(q > 0) {
			
			int l  =  in.nextInt();
			int r =  in.nextInt();
			
			HashSet<Integer> set = new 	HashSet<Integer>();	
			for(int i = l-1; i < r; i++) {
				
				set.add(a[i]);
				
			}
			System.out.println(set.size());
			
			q--;
		}
	}

}
