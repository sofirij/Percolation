import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
public class Percolation
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        
        //array list to generate random numbers for opening sites
        ArrayList<Integer> tracker = new ArrayList<>();
        
        int n = scan.nextInt();
        int count = 0;
        int x, a; 
        
        //array to keep track of open sites
        boolean[] array = new boolean[n * n];
        
        //array to keep track of whether a node is open or closed
        for (int i = 0; i < n*n; i++)
        {
            array[i] = false;
            tracker.add(i);
        }
        
        //the first of the added 2 to (n * n) accounts for the imaginary top node and the other for the imaginary bottom node
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF((n * n) + 2);

        for (int i = 0; i < n; i++)
        {
            //join the top to imaginary top node for the union check
            uf.union(i, n * n);
            
            //join the bottom to imaginary bottom node for the union check
            uf.union((n * (n - 1)) + i, (n * n) + 1);
        }
        
        
        //randomly open and connect sites until the top connects to the bottom
        while (!uf.connected((n * n), (n * n) + 1))
        {
            //generate random site
            a = rand.nextInt(tracker.size());
            x = tracker.get(a);
            
            //remove the opened site from random possibilities
            tracker.remove(a);
            
            //open that site
            array[x] = true;
            count++;
            
            //connect adjacent sites that are open
            //check the sites on the same row
            //check left column
            if ((x % n) != 0 && (x-1) >= 0 && array[x - 1])
            {
                uf.union(x, x-1);
            }
            //check right column
            if ((x % n) != n-1 && (x+1) < (n*n) && array[x + 1])
            {
                uf.union(x, x+1);
            }
            
            //check sites on the same column
            //check top row
            if ((x-n) >= 0 && array[x-n])
            {
                uf.union(x, x-n);
            }
            //check bottom row
            if ((x+n) < (n*n) && array[x+n])
            {
                uf.union(x, x+n);
            }
            
        }
        
        //print out what the grid looks like after percolation
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print((array[(i * n) + j] ? "1 " : "0 "));
            }
            System.out.println();
        }
        
        //print out the percolation threshold
        System.out.print("Percolation threshold = ");
        System.out.println((count * 1.0) / (n*n)); 
    }
}