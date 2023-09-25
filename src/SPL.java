public class SPL {
    public static double[] solveCramer(double[][] matrix) {
        int n = matrix.length;
        double det = Matrix.detCofactor(Matrix.slice_a(matrix));
        double[] x = new double[n];
    
        if (det != 0) {
            for (int i = 0; i < n; i++) {
                double[][] Ai = Matrix.slice_a(matrix);
                for (int j = 0; j < n; j++) {
                    Ai[j][i] = Matrix.slice_b(matrix)[j][0];
                }
                x[i] = Matrix.detCofactor(Ai) / det;
            }
        }
        return x;

    }
}
