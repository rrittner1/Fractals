public class ScuffedTimer {
    public static void main(String args[]) {
        System.out.println(0);
        wait(10000);
        System.out.println(10);
    }
    public static void wait(int millis) {
        for(int i = 0; i < millis*2; i++) {
            delayRunner(0);
        }
    }
    private static int delayRunner(int n) {
        if (n == 19) {
            return 0;
        } else {
            delayRunner(n+1);
            return delayRunner(n+1);

        }
    }
}
