package com.metacube.training.commonFactors;

public class CommonFactors {
	static private int lcm = 0;

	int findLCM(int x, int y) {
		lcm = lcm + y;
		if (lcm % x == 0 && lcm % y == 0) {
			return lcm;
		} else {
			return findLCM(x, y);
		}

	}

	int findHCF(int x, int y) {
		if (x == 0) {
			return y;
		}
		return findHCF(y % x, x);
	}

}
