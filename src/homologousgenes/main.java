package homologousgenes;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneDifferencer gd = new GeneDifferencer(1,2); //Set the mismatch penalty to 1, and the gap penalty to 2
		System.out.println("\n\nTEST 1");  //the first test
		String test1a = "CAGCACTTGGATTCTCGG";
		String test1b = "CAGCGTGG";
		
		String[] results;

		
		//display the table and genes
		results = gd.geneComparison(test1a, test1b);
		gd.genesDisplay(results);
		
		
		
		System.out.println("\n\nTEST 2"); //the second test
		String test2a = "TCCCAGTTATGTCAGGGGACACGAGCATGCAGAGAC";
		String test2b = "AATTGCCGCCGTCGTTTTCAGCAGTTATGTCAGATC";
		
		
		//display the table and genes
		results = gd.geneComparison(test2a, test2b);
		gd.genesDisplay(results);
	}

}
