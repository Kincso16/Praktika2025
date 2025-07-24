public class Main {
    public static void main(String[] args) {
        int n = 10;
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("alapértelmezett ertek: 10");
            }
        }

        int lineCounter = 1;
        int argsCounter = 1;
        for (int i = 1; i <= n; i++) {
            if (argsCounter == lineCounter) {
                lineCounter++;
                System.out.println(i + " ");
                argsCounter = 1;
            } else {
                System.out.print(i + " ");
                argsCounter++;
            }
        }
    }
}