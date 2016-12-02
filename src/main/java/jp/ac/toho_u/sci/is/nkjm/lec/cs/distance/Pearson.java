package jp.ac.toho_u.sci.is.nkjm.lec.cs.distance;

import java.util.List;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

public class Pearson {

	public double distance(List<Double> counts1, List<Double> counts2) {
		double corr = new PearsonsCorrelation().correlation(
				counts1.stream().mapToDouble(d -> d).toArray(),
				counts2.stream().mapToDouble(d -> d).toArray());
		return 1 - corr;
	}

}
