package DisjointSet;

public class Main {

    public static void main(String[] args) {

        disjointSet ds = new disjointSet(7);

        System.out.println("Initial:");
        for (int i = 0; i < 7; i++) {
            System.out.println(i + " -> " + ds.find(i));
        }

        ds.union(0, 1);
        ds.union(1, 2);
        ds.union(3, 4);
        ds.union(5, 6);

        System.out.println("\nAfter unions:");

        for (int i = 0; i < 7; i++) {
            System.out.println(i + " -> " + ds.find(i));
        }


        System.out.println("\nSame set checks:");
        System.out.println("0 and 2: " + (ds.find(0) == ds.find(2)));

        System.out.println("0 and 3: " + (ds.find(0) == ds.find(3)));

        System.out.println("3 and 4: " + (ds.find(3) == ds.find(4)));

        System.out.println("5 and 6: " + (ds.find(5) == ds.find(6)));

        ds.union(2, 4);

        System.out.println("\nAfter union(2, 4):");

        for (int i = 0; i < 7; i++) {
            System.out.println(i + " -> " + ds.find(i));
        }

        System.out.println("\nFinal same set checks:");

        System.out.println("0 and 4: " + (ds.find(0) == ds.find(4)));

        System.out.println("1 and 3: " + (ds.find(1) == ds.find(3)));

        System.out.println("5 and 6: " + (ds.find(5) == ds.find(6)));

        System.out.println("0 and 5: " + (ds.find(0) == ds.find(5)));
    }
}