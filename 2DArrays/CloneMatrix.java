public class CloneMatrix {

    static double[][] clone(double[][] a) {
        if (a == null) {
            return a;
        }
        if (a.length == 0 || a[0].length == 0) {
            return new double[0][0];
        }
        int length = a.length;
        int width = a[0].length;
        double[][] b = new double[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                b[i][j] = a[i][j];
            }
        }
        return b;
    }


}
