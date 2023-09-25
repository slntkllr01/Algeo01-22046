
public class OpMatrix {
    public class Gaussian{
        public static double[][] switchRow(double[][] m1, int r1, int r2){
        double[][] m2 = new double[Matrix.getRow(m1)][Matrix.getCol(m1)];
        m2 = Matrix.copyMatrix(m1);
        for (int j=0;j < Matrix.getCol(m1);j++){
            m1[r1][j] = m2[r2][j];
            m1[r2][j] = m2[r1][j];  
        }
        return m1;

    }
        public static double[][] oBE (double[][] m1, int n, int j){
            for(int i=1+n;i<Matrix.getRow(m1);i++){
                double obe = m1[i][j];
                if (m1[n][j] == 0){
                        continue;
                    } else {
                        for (int k = 0;k<Matrix.getCol(m1);k++){
                            m1[i][k] -= (obe)/(m1[n][j]) * m1[n][k];
                        }
                    }
                }
                
                    
            
            return m1;
        }
        public static double[][] Gauss(double[][] m1){
            for (int i=0;i<Matrix.getRow(m1)-1;i++){
                if (m1[0][0] != 0){
                    break;
                } else {
                    switchRow(m1, i+1, i);

                }
                    
            }
            for(int i=0;i<Matrix.getRow(m1);i++){
                for (int j=0;j<Matrix.getCol(m1);j++){
                    if (m1[i][j] == 0){
                        continue;
                    } else {
                        double div = m1[i][j];
                        for (int k=0;k<Matrix.getCol(m1);k++){
                            m1[i][k] /= div;
                        }
                        m1 = oBE(m1, i, j);
                        break;
                    }  
                }
            }
            
            return m1;
        }      
    }
    public double[][] GaussJordan(double[][] m1){
        m1 = Gaussian.Gauss(m1);
        for (int j=0;j<Matrix.getCol(m1);j++){
            for (int i=0;i<Matrix.getRow(m1);i++){

            }
        }
        return m1;
    }

    
}
