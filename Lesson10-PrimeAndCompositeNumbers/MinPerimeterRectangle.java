public class MinPerimeterRectangle {
    public int solution(int N) {
        int sqr = (int) (Math.sqrt(N) + 0.5);
        while (N % sqr != 0) {
            sqr--;
        }
        return 2 * (sqr + N/sqr);
    }
}
