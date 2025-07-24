public class Main2 {
    public static void main(String[] args) {
        int n = 10;
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("alapértelmezett ertek: 10");
            }
        }

        int counter = 0;
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i+1];
            for (int j = 0; j < i+1; j++) {
                arr[i][j] = ++counter;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}