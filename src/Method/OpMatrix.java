package Method;
import Matrix.Matrix;

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

        public static double[][] oBe (double[][] m1, int i, int j){ /* n adalah baris */
            for(int n=1+i;n<Matrix.getRow(m1);n++){
                double obe = m1[n][j]; /* angka yang akan menjadikan 0 */
                if (m1[i][j] == 0){ /* jika elemen pada baris dan kolom tersebut 0 */
                    continue; /* lanjut ke baris berikutnya */
                } else {
                    for (int k = 0;k<Matrix.getCol(m1);k++){ /* k sebagai iterator kolom saat melakukan obe */
                        m1[n][k] -= (obe)/(m1[i][j]) * m1[i][k]; /* operasi obe pada baris tersebut dengan baris pivot */
                    }
                }
            }
            return m1;
        }

        public static double[][] Gauss(double[][] m1){
            /* switch jika element pertama pada baris pertama adalah 0 atau tidak 1 */
            
            /* menjadikan elemen tidak 0 pertama pada suatu barus menjadi 1 */
            for(int i=0;i<Matrix.getRow(m1);i++){
                for (int j=i;j<Matrix.getCol(m1);j++){
                    if (m1[i][j] == 0){
                        if (Matrix.isColZero(m1, j)){
                            continue;
                        } else {
                            boolean udhdiobe = false;
                            for (int k=i;k<Matrix.getRow(m1);k++){
                                if (m1[k][j] == 0){ /* kalo 0 */
                                    continue; /* kita pindah baris */
                                } else {
                                    switchRow(m1, i, k);
                                    double div = m1[i][j]; /* pembuat 1 */
                                    for (int l=0;l<Matrix.getCol(m1);l++){
                                        m1[i][l] /= div; /* dibagi dengan pembuat 1 */
                                    }
                                    /* lakukan obe */
                                    m1 = oBe(m1, i, j);
                                    udhdiobe = true;
                                    /* setelah obe langsung lanjut ke baris berikutnya */
                                    break;                                   
                                } 
                            }
                            if(udhdiobe){
                                break;
                            }
                            
                        }
                    } else {
                        double div = m1[i][j]; /* pembuat 1 */
                        for (int k=0;k<Matrix.getCol(m1);k++){
                            m1[i][k] /= div; /* dibagi dengan pembuat 1 */
                        }
                        /* lakukan obe */
                        m1 = oBe(m1, i, j);
                        /* setelah obe langsung lanjut ke baris berikutnya */
                        break;
                    }  
                }
            }

            /* jika ada baris yang elemennya 0 semua */
            /* pindahkan ke bagian paling bawah */
            for (int i=0;i<Matrix.getRow(m1)-1;i++){
                if(Matrix.isRowZero(m1, i)){
                    Matrix.moveUpAddZero(m1, i);
                }
                
            }
            return m1;
        }      

        public static double[][] GaussJordan(double[][] m1){
            m1 = Gaussian.Gauss(m1); /* memanggil fungsi gauss untuk mendapat matrix eselon baris */
            for (int i=1;i<Matrix.getRow(m1);i++){
                for (int j=0+i;j<Matrix.getCol(m1);j++){
                    if (m1[i][j] == 0){ /* cari kolom yang tidak 0 pada baris ke dua dan seterusnya */
                        continue;
                    }
                    else{
                        double pivot = m1[i][j];
                        for (int n = 0; n<Matrix.getRow(m1);n++){
                            double obe = m1[n][j]; /* variabel untuk menyimpan elemen yang akan di 0 kan,  */
                            for (int k = 0; k<Matrix.getCol(m1);k++){
                                if (n != i){ /* bisa dibuat lebih efektif lagi */
                                m1[n][k] -= (obe)/(pivot) * m1[i][k]; /* melakukan obe */
                                }
                            }
                        }
                        break;
                        
                    }
                
                }
            }
            return m1;
        }
    }

    public static double detGauss(double[][] m1){
            double det = 1;
            /* switch jika element pertama pada baris pertama adalah 0 */
            
            if (m1[0][0] == 0){ /* kalo 0 */
                if(Matrix.isColZero(m1, 0)){ /* kalo 1 kolom 0 semua */
                    return 0.0; /* det = 0 */
                } else {
                    boolean switched = false;
                    for (int i = 1;i<Matrix.getRow(m1);i++){ /* kita mencari 1 pada kolom tersebut */
                        if (m1[i][0] == 1){
                            Gaussian.switchRow(m1, i, 0); /* jika ada kita switch */
                            switched = true;
                            break;
                        }
                    }
                    if (switched == false){ /* jika ternyata tidak ada yang 1 */
                        for (int i = 1;i<Matrix.getRow(m1);i++){ /* kita switch dengan yang tidak 0 */
                            if (m1[i][0] != 0){
                            Gaussian.switchRow(m1, i, 0);
                            break;
                            }   
                        }
                    }
                    
                }
            } else { /* kalo tidak 0 dan tidak 1 */
                for (int i = 1;i<Matrix.getRow(m1);i++){
                    if (m1[i][0] == 1){ /* kita cari yang 1 pada kolom tersebut dan kita switch */
                        Gaussian.switchRow(m1, i, 0);
                        break;
                    }
                }
            } 
                
            
            
            /* menjadikan elemen tidak 0 pertama pada suatu barus menjadi 1 */
            for(int i=0;i<Matrix.getRow(m1);i++){
                for (int j=0;j<Matrix.getCol(m1);j++){
                    if (m1[i][j] == 0){
                        continue;
                    } else {
                        /* lakukan obe */
                        m1 = Gaussian.oBe(m1, i, j);
                        /* setelah obe langsung lanjut ke baris berikutnya */
                        break;
                    }  
                }
            }
            for (int i=0;i<Matrix.getRow(m1);i++){
                det *= m1[i][i];

            }
            return det;
        }      
    public static String strInverseGauss(double[][] m1){
        double[][] m2 = new double[Matrix.getRow(m1)][Matrix.getCol(m1)];
        String result;
        for(int i=0;i<Matrix.getRow(m1);i++){
            m2[i][i] = 1;
        }
        m1 = Matrix.mergeMatCol(m1, m2);
        m1 = Gaussian.GaussJordan(m1);
        // Matrix.DisplayMatrix(m1);
        // System.out.println();
        m2 = Matrix.sliceMatrixLeft(m1);
        if (Matrix.isIdentity(m2)){
            m1 = Matrix.sliceMatrixRight(m1);
            return Matrix.DisplayMatrix(m1);
        }
        else {
            result = "Matrix tidak mempunyai balikan";
            return result;
        }

    }
    public static double[][] inverseGauss(double[][] m1){
        
        double[][] m2 = new double[Matrix.getRow(m1)][Matrix.getCol(m1)];
        for(int i=0;i<Matrix.getRow(m1);i++){
            m2[i][i] = 1;
        }
        m1 = Matrix.mergeMatCol(m1, m2);
        m1 = Gaussian.GaussJordan(m1);
        // Matrix.DisplayMatrix(m1);
        // System.out.println();
        double[][] temp = Matrix.sliceMatrixLeft(m1);
        if (Matrix.isIdentity(temp)){
            m1 = Matrix.sliceMatrixRight(m1);
            return m1;
        }
        double notIdentity[][] = new double[1][1];
        notIdentity[0][0] = -9999;
        return notIdentity;
        
    }

    public static double detCofactor(double[][] matrix) {
        /* mengirim hasil determinan dengan expansi kofaktor */
        if(Matrix.getRow(matrix) == 1) {
            return matrix[0][0];
        }
        if(Matrix.getRow(matrix) == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }

        double result = 0;
        for(int i=0; i<Matrix.getCol(matrix); i++) {
            result += Math.pow(-1, i)*matrix[0][i]*detCofactor(Matrix.minorMatrix(matrix, 0, i));
        }
        return result;
    }

    public static double[][] inverseAdjoint(double[][] matrix) {
        /* inverse dengan adjoin */
        double[][] result = {{-999},{0}}; ;
        if(detCofactor(matrix) != 0) {
            result = (Matrix.MultiplyByConst(Matrix.adjoint(matrix),(1/detCofactor(matrix))));
        }
        return result;
    }

    public static double rounding(double n) {
        double x = Math.pow(10, -8);
        double y = Math.abs(n)-Math.abs(n%1);
        if(y == 0 && (Math.abs(n%1) < x || Math.abs(1-(n%1)) < x)) {
            n = 0;
        }
        else if(Math.abs(n%1) < x) {
            if(n<0) {
                n += (n%1);
            }
            else {
                n -= (n%1);
            }
        }
        else if(Math.abs(1-(n%1)) < x) {
            if(n<0) {
                n -= (1-(n%1));
            }
            else {
                n += (1-(n%1));
            }
        }
        return n;
    }
}

