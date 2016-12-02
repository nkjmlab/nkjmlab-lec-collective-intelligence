package jp.ac.toho_u.sci.is.nkjm.lec.cs.distance;

import java.util.List;

public class MyPearson {

	public double distance(List<Double> counts1, List<Double> counts2) {
		double sum1 = sum(counts1);
		double sum2 = sum(counts2);
		double sum1Sq = squreSum(counts1);
		double sum2Sq = squreSum(counts2);
		double pSum = productSum(counts1, counts2);

		double num = pSum - (sum1 * sum2 / counts1.size());
		double den = Math.sqrt((sum1Sq - Math.pow(sum1, 2) / counts1.size())
				* (sum2Sq - Math.pow(sum2, 2) / counts2.size()));
		if (den == 0) {
			return 0;
		}
		return 1 - num / den;
	}

	private double productSum(List<Double> counts1, List<Double> counts2) {
		double pSum = 0;
		for (int i = 0; i < counts1.size(); i++) {
			pSum += counts1.get(i) * counts2.get(i);
		}

		return pSum;
	}

	private double squreSum(List<Double> counts) {
		return counts.stream().mapToDouble(i -> i * i).sum();
	}

	private double sum(List<Double> counts) {
		return counts.stream().mapToDouble(i -> i).sum();
	}

}
