public class WeightedQuickUnionUF
{
    int[] array;
    int[] size;
    
    public WeightedQuickUnionUF(int n)
    {
        array = new int[n];
        size = new int[n];
        
        for (int i = 0; i < n; i++)
        {
            array[i] = i;
            size[i] = 1;
        }
    }
    
    public int root(int p)
    {
        while (p != array[p])
        {
            array[p] = array[array[p]];
            p = array[p];
        }
        
        return p;
    }
    
    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }
    
    public void union(int p, int q)
    {
        int a = root(p); //child
        int b = root(q); //root
        
        //join smaller root to larger root
        if (size[b] > size[a])
        {
            array[a] = b;
            size[b] += size[a];
        }
        else
        {
            array[b] = a;
            size[a] += size[b];
        }
    }
}