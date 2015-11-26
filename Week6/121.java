    public int maxProfit(int[] prices) {
        int len = prices.length;
		int leftmin[] = new int[len];
		int rightmax[] = new int[len];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++) {
			if (prices[i] < min) {
				leftmin[i] = prices[i];
				min = prices[i];
			} else {
				leftmin[i] = min;
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = len - 1; i >= 0; i--) {
			if (prices[i] > max) {
				rightmax[i] = prices[i];
				max = prices[i];
			} else {
				rightmax[i] = max;
			}
		}
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			int gap = rightmax[i] - leftmin[i];
			result = gap > result ? gap : result;
		}
		return result > 0 ? result : 0;
    }