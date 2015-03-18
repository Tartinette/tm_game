package core;

public class CalculationTable {
	
	public CalculationTable() {}
	
	/**
	 * Calculate the reduction in % given the associated score
	 * @param s. Score armor/reduction score 
	 * @return reduction. Return the % of reduction allowed by the score s. Returns -1 in case of error
	 */
	public int getReduction (int score) {
		int reduction = 0;
		reduction = _getReduction(score, 0, 0);
		return (1- (reduction / 20));
	}
	
	/**
	 * You don't want to use that. Please use getReduction(int) instead.
	 * This function is used by getReduction() to find the % reduction given a score n. 
	 * Oh one more thing this is recursive.
	 * @param n. Is the score.
	 * @param acu. Contains the number of times a value has been repeated so far.
	 * @param av. Contain the actual value of the progression so far.
	 * @return
	 */
	public int _getReduction(int n, int acu, int av) {
		if (n == 0) { 
			return av;
		} 
		if (acu == av) {
			return _getReduction(n-1, 1, av+1);
		}
		return _getReduction(n-1, acu+1, av);
	}
}
