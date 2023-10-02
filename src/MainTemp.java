
// nyoba akses method dari Matrix.java

import java.io.File;

import Matrix.Matrix;

public class MainTemp {
    public static void main(String[] args) {
        double[][] Matrix1, Matrix2, Matrix3;
        Matrix1 = Matrix.ReadMatrixKeyboard();


        // Bicubic.changeSize(Matrix1, 4, 4);
        // Bicubic.bicubicSI(Matrix1);
        // System.out.println("me: ");
        // Bicubic.bicubicSI(Matrix1);

        // Matrix.DisplayMatrix(Bicubic.slice4x4(Matrix1));System.out.println();
        // Matrix.DisplayMatrix(Bicubic.sliceAB(Matrix1));

        /* STUDI KASUS INTERPOLASI */
        // double x = Interpolation.tanggalDesimal();
        // Matrix1 = Interpolation.InterpolasiKeyboard();
        // // Matrix1 = Interpolation.InterpolasiFile(Interpolation.contohMat());
        // Interpolation.outputInterpolasi(Matrix1);
        // Interpolation.outputFungsi(Matrix1);
        // Interpolation.outputFungsi(Matrix1);
        // Interpolation.outputFungsi(Matrix1);
        // Interpolation.outputFungsi(Matrix1);

        /* STUDI KASUS BICUBIC */
        // double[][] mat1 = 
        // {{21,98,125,153},
        // {51,101,161,59},
        // {0,42,72,210},
        // {16,12,81,96},
        // {0,0,0,0}};
        // System.out.println("1: ");Bicubic.bicubicSI(mat1);System.out.println();

        // double[][] mat2 = 
        // {{21,98,125,153},
        // {51,101,161,59},
        // {0,42,72,210},
        // {16,12,81,96},
        // {0.5,0.5,0,0}};
        // System.out.println("2: ");Bicubic.bicubicSI(mat2);System.out.println();

        // double[][] mat3 = 
        // {{21,98,125,153},
        // {51,101,161,59},
        // {0,42,72,210},
        // {16,12,81,96},
        // {0.25,0.75,0,0}};
        // System.out.println("3: ");Bicubic.bicubicSI(mat3);System.out.println();

        // double[][] mat4 = 
        // {{21,98,125,153},
        // {51,101,161,59},
        // {0,42,72,210},
        // {16,12,81,96},
        // {0.1,0.9,0,0}};
        // System.out.println("4: ");Bicubic.bicubicSI(mat4);System.out.println();

        // // Matrix2 = Matrix.Gauss(Matrix1);
        // Matrix.DisplayMatrix(Matrix1);
        // System.out.println();
        // Matrix2 = Matrix.ReadMatrixKeyboard();
        // Matrix.DisplayMatrix(Matrix2);
        
        // int baris = Matrix.getRow(Matrix1);
        // int kolom = Matrix.getCol(Matrix1);
        // System.out.println("baris: " + baris);
        // System.out.println("kolom: " + kolom + "\n");

        // Matrix3 = Matrix.AddMatrix(Matrix1, Matrix2);
        // Matrix.DisplayMatrix(Matrix3); System.out.println();
        
        // Matrix3 = Matrix.MultiplyMatrix(Matrix1, Matrix2);
        // Matrix.DisplayMatrix(Matrix3);

        // // tes kofaktor
        // Matrix3 = Matrix.cofactor(Matrix1);
        // Matrix.DisplayMatrix(Matrix3);System.out.println();

        // // tes adjoin
        // Matrix3 = Matrix.adjoint(Matrix1);
        // Matrix.DisplayMatrix(Matrix3);System.out.println();
        
        // tes determinan
        // double det = Matrix.detCofactor(Matrix1);
        // System.out.println("det: " +det);
        
        // tes inverseAdjoint
        // System.out.println("\ninverse: ");
        // Matrix2 = Matrix.inverseAdjoint(Matrix1);
        // Matrix.DisplayMatrix(Matrix2);System.out.println();
        
        // // tes Cramer
        // double[] result = SPL.solveCramer(Matrix1);
        // for (double value : result) {
        //     System.out.println(value);
        // }

        
        

    //     // Matrix2 = Matrix.slice_b(Matrix1);
    //     // Matrix.DisplayMatrix(Matrix2);System.out.println();

    //     Matrix2 = Matrix.slice_a(Matrix1);
    //     Matrix.DisplayMatrix(Matrix2);System.out.println();
    }
}
