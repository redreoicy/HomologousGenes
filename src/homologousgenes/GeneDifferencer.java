package homologousgenes;

public class GeneDifferencer {
	int mismatchPenalty;
	int gapPenalty;
	
	GeneDifferencer(int m, int g){
		this.mismatchPenalty = m;
		this.gapPenalty = g;
	}
	
	String[] geneComparison(String a, String b) {
		
		//ensure that there are more rows than columns in our matrix 
		String longer;
		String shorter;
		if(a.length() < b.length()) {
			shorter = a;
			longer = b;
		}else {
			longer = a;
			shorter = b;
		}
		
		
		//optTable an m x n matrix of integers

		int m = longer.length() + 1;
		int n = shorter.length() + 1;
		int[][] optTable = new int[m][n];
		optTable[m-1][n-1] = 0;  //set the corner to 0.
		
		for(int sum = m + n - 3; sum>=0 ; sum--) {		//iterate by diagonals, from the bottom right, skip bottom right square
			int row;
			int col;
			if (sum >= m-1) {
				row = m-1;
				col = sum - m+1;
			} else {
				row = sum;
				col = 0;
			}
			while(row>=0 && col < n) {	
				
				//determine the value of a given square here.
				int value = Integer.MAX_VALUE;
				
				if(row + 1 < m && optTable[row+1][col] + gapPenalty < value) { //check one square below if it exists.
					value = optTable[row+1][col] + gapPenalty;
				}
				
				if(col + 1 < n && optTable[row][col+1] + gapPenalty < value){ //compare to one square to the right
					value = optTable[row][col+1] + gapPenalty;
				}
				
				if(col + 1 < n && row + 1 < m) {				//compare to the diagonal, and check for a mismatch.
					int candidate = optTable[row+1][col+1];
					if(longer.charAt(row) != shorter.charAt(col)){
						candidate += mismatchPenalty;
					}
					if(candidate < value) {
						value = candidate;
					}
				}
				
				optTable[row][col] = value;					//set the value
				
				
				row--;
				col++;		
			}
		}

		
		//print out the optTable
		System.out.println("The Table");
		System.out.printf("%5c", '-');
		for(int i = 0; i<shorter.length();i++) {
			System.out.printf("%5c", shorter.charAt(i));
		}
		System.out.printf("%5c", '-');
		int index = 0;
		for(int[] row: optTable) {
			System.out.println();
			if(index == longer.length()) {
				System.out.printf("%5c", '-');
			}else {
				System.out.printf("%5c", longer.charAt(index++));
			}
			for(int square : row) {
				System.out.printf("%5d", square);
			}
		}
		
		
		
		String res1 = ""; //the longer string (each char is new row)
		String res2 = ""; //the shorter string
		
		int row = 0;
		int col = 0;
		while(row!=m-1 || col!=n-1) { //haven't reached bottom right
			if(row + 1 < m && optTable[row+1][col] + gapPenalty == optTable[row][col]) { //check one square below to see if we came from there
				res2+='-';
				res1+=longer.charAt(row);
				row++;
			}
			
			else if(col + 1 < n && optTable[row][col+1] + gapPenalty == optTable[row][col]) { //check one square to the right to see if we came from there
				res1+='-';
				res2+=shorter.charAt(col);
				col++;
			}else { //otherwise, we came from the diagonal
				res1+=longer.charAt(row);
				res2+=shorter.charAt(col);
				row++;
				col++;
			}
			
			
		}
		
		
		String[] results = {res1, res2};
		return results;
	}
	void genesDisplay(String [] results) {
		System.out.println("\n\nThe genes");
		for(String gene : results) {
			System.out.println();
			for(int i = 0; i<gene.length();i++) {
				System.out.print(gene.charAt(i) + " ");
			}
		}
	}
	

}
