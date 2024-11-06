# Percolation Simulation

This Java program simulates a percolation process on an n x n grid. The program randomly opens sites on the grid and uses the Weighted Quick Union algorithm to model the connectivity between open sites. It calculates and prints the percolation threshold, which is the fraction of open sites required for percolation to occur.

Features
Randomly opens sites on an n x n grid.
Uses a Weighted Quick Union algorithm to track connectivity between open sites.
Simulates percolation by connecting open sites and checking if there is a path from the top row to the bottom row.
Prints the grid layout after percolation and calculates the percolation threshold.

How It Works
Grid Setup: The grid is represented as a 1D array of boolean values. Initially, all sites are closed.
Random Site Opening: Random sites are opened until a path connects the top row to the bottom row.
Union-Find Algorithm: The program uses the WeightedQuickUnionUF class to efficiently manage the connectivity between sites. The top row is connected to an imaginary top node, and the bottom row is connected to an imaginary bottom node.
Percolation Check: The simulation continues opening sites and connecting them until a path is formed from the top to the bottom, indicating percolation.
Percolation Threshold: Once percolation occurs, the program calculates the percolation threshold, which is the fraction of open sites to the total number of sites.

Inputs
The program takes a single integer n as input, representing the size of the grid (i.e., the grid will be n x n).

Outputs
Grid Layout: After percolation occurs, the program outputs the grid with 1 representing an open site and 0 representing a closed site.
Percolation Threshold: The fraction of open sites required for percolation.

Example Output
1 0 0 1 0 
0 1 1 0 1 
1 1 1 1 0 
0 1 0 0 1 
1 0 1 1 0 

Percolation threshold = 0.25

How to Run
Compile the Java file:
javac Percolation.java

Run the program:
java Percolation
Enter the grid size n when prompted.
