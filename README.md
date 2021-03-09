# HomologousGenes
A program for finding the best way to pair 2 genes

Test case 1:

CAGCACTTGGATTCTCGG

CAGCGTGG

Results:

![testcase1](TestImages/Testcase1.png)

Test case 2:

TCCCAGTTATGTCAGGGGACACGAGCATGCAGAGAC

AATTGCCGCCGTCGTTTTCAGCAGTTATGTCAGATC

Results:

![testcase2](TestImages/Testcase2.png)

(The mismatch penalty is set to 1, and the gap penalty is set to 2, in the main method. This can be easily adjusted by changing the values passed to the GeneDifferencer constructor.)
