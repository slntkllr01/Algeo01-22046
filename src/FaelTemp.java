public class FaelTemp {
    public static double[] backwardSubstitution(double[][] matrix) {
        int length = Matrix.getRow(matrix);
        double[] solutions = new double[length];
    
        for (int i = length - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < length; j++) {
                sum += matrix[i][j] * solutions[j];
            }
            solutions[i] = (matrix[i][length] - sum) / matrix[i][i];
        }
    
        return solutions;
    }
}
