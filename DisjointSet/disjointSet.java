package DisjointSet;

public class disjointSet{
    private int[] parent;
    private int[] componentSize;
    private int size;

    disjointSet(int size) {
        this.size = size;
        this.parent = new int[size];
        this.componentSize = new int[size];

        for (int i = 0; i < this.size; i++) {
            parent[i] = i;
            componentSize[i] = 1;
        }
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return;

        if (componentSize[rootA] >= componentSize[rootB]) {
            parent[rootB] = rootA;
            componentSize[rootA] += componentSize[rootB];
        } 
        else {
            parent[rootA] = rootB;
            componentSize[rootB] += componentSize[rootA];
        }
    }

    public int find(int i) {
        if (parent[i] == i)
            return i;

        return parent[i] = find(parent[i]);
    }
}