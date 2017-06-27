package spoj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*Solution better than N*Q but memory intensive */

public class DQuery2 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int a[] = new int[n];

		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();
		}

		HashMap<Integer, HashMap<Integer, Integer>> hm = new HashMap<Integer, HashMap<Integer, Integer>>();

		HashMap<Integer, Integer> bufferMap = new HashMap<Integer, Integer>();

		bufferMap.put(a[0], 1);

		hm.put(0, bufferMap);

		for (int i = 1; i < a.length; i++) {

			HashMap<Integer, Integer> bufferMap1 = new HashMap<Integer, Integer>(hm.get(i - 1));

			int k = bufferMap1.containsKey(a[i]) ? bufferMap1.get(a[i]) : 0;
			bufferMap1.put(a[i], k + 1);   // every index stores values from 0 till that index

			hm.put(i, bufferMap1);

		}

		int q = in.nextInt();

		while (q > 0) {

			int l = in.nextInt();
			int r = in.nextInt();
			int countDistinct = 0;

			if (l <= 0 || r > a.length) {
				continue;
			}

			else if (l == 1) {     // Range starts from beginning
				System.out.println(hm.get(r - 1).size());

			}

			else {
				HashMap<Integer, Integer> leftSide = new HashMap<Integer, Integer>(hm.get(l - 2));

				HashMap<Integer, Integer> rightSide = new HashMap<Integer, Integer>(hm.get(r - 1));

				// Iterating the leftSide side

				for (Map.Entry<Integer, Integer> entry : leftSide.entrySet()) {

					int num = entry.getKey();
					int lValue = entry.getValue();
					int rValue = rightSide.containsKey(num) ? rightSide.get(num) : 0;

					if ((rValue - lValue) > 0)
						countDistinct++;

				}
				countDistinct += rightSide.size() - leftSide.size();
				System.out.println(countDistinct);
			}
			q--;
		}
	}
}
