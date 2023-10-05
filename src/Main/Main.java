package Main;

import java.util.Scanner;

import Matrix.InputOutput;
import Matrix.Matrix;
import Method.*;

public class Main {
    public static Scanner sc;

    // TEXT COLOR
    public static String RESET = "\u001B[0m";
    public static String GREEN = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";
    public static String RED = "\u001B[31m";
    public static String WHITE_BG = "\u001B[47m";
    
    // NECESSARY STRING
    public static String pilMenu = """

            1. Sistem Persamaaan Linier              
            2. Determinan
            3. Matriks balikan
            4. Interpolasi Polinom
            5. Interpolasi Bicubic Spline
            6. Regresi linier berganda
            7. Keluar
            """;
            
    public static String subMenuSPL = """
        
            1. Metode eliminasi Gauss
            2. Metode eliminasi Gauss-Jordan
            3. Metode matriks balikan
            4. Kaidah Cramer 
            5. Kembali                
            """;

    public static String subMenuDET = """
        
            1. Metode Reduksi Baris
            2. Metode ekspansi kofaktor 
            3. Kembali                
            """;

    public static String subMenuINV = """
        
            1. Metode eliminasi Gauss-Jordan
            2. Metode adjoint   
            3. Kembali              
            """;
    
    public static String input = """
        
            1. Keyboard
            2. File 
            3. Kembali               
            """;

    public static String kelompok = """
            
            ░█████╗░██╗░░░██╗░█████╗░███╗░░██╗██╗░░██╗██╗
            ██╔══██╗██║░░░██║██╔══██╗████╗░██║██║░██╔╝██║
            ██║░░╚═╝██║░░░██║███████║██╔██╗██║█████═╝░██║
            ██║░░██╗██║░░░██║██╔══██║██║╚████║██╔═██╗░██║
            ╚█████╔╝╚██████╔╝██║░░██║██║░╚███║██║░╚██╗██║
            ░╚════╝░░╚═════╝░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚═╝╚═╝
            m a t r i x   c a l c u l a t o r
            """;
    // RUN
    public static void main(String[] args) {
        
        double[][] matrix1;
        Scanner sc = new Scanner(System.in);
        int choiceMenu = 0;
        System.out.print(kelompok);

        do {
            // INPUT MENU
            System.out.println("\n" + YELLOW + WHITE_BG + " MENU: " + RESET);
            System.out.println(YELLOW + pilMenu + RESET);

            System.out.print("Masukan pilihan menu: ");
            
            choiceMenu = ErHandling(choiceMenu, 1, 7);

            if(choiceMenu == 7) {
                System.out.println(YELLOW + "Keluar dari program..." + RESET);
            }

            // MENU (1-7)
            switch (choiceMenu) {
                case 1:
                    int choiceSub = 0;
                    do {
                        System.out.println("""
                            ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                        ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                            
                    S I S T E M  P E R S A M A A N  L I N E A R

                        ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                            ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                                """);
                        // INPUT SUBMENU
                        printSub(subMenuSPL);
                        choiceSub = ErHandling(choiceSub, 1, 5);
                        switch (choiceSub) {
                            case 1:
                                System.out.println("""
                                        ============================================
                                                    METODE ELIMINASI GAUSS
                                        ============================================
                                        """);
                                // INPUT CARA MASUKAN
                                printInput();
                                int choiceInput = 0;
                                choiceInput = ErHandling(choiceInput, 1, 3);
    
                                if(choiceInput == 1) {
                                    System.out.println("Masukkan matrix Ax=b (augmented): ");
                                    /* ISI ALGORITMA KEYBOARD DI SINI */
                                    String result;
                                    matrix1 = Matrix.ReadMatrixKeyboard();
                                    // SPL.
                                    result = SPL.OutputSPLGauss(matrix1);
                                    System.out.println(result);


                                    /* SAVE OUTPUT */
                                    SaveOutput(result); // ganti null dengan tipe String yg mau disimpan, 
                                    // contoh: String kata = "ini isi kata"; SaveOutput(kata);
                                    // nanti hapus comment ini semua ya

                                }
                                else if(choiceInput == 2) {
                                    
                                    /* ISI ALGORITMA FILE DI SINI */
                                    matrix1 = new double[100][100];
                                    String result;
                                    System.out.print("Masukkan nama file: ");
                                    String fileName = sc.nextLine();
                                    matrix1 = InputOutput.readMatrixFile(matrix1, fileName);
                                    result = SPL.OutputSPLGauss(matrix1);
                                    System.out.println(result);

                                    /* SAVE OUTPUT */
                                    SaveOutput(result); // ganti null dengan tipe String yg mau disimpan, 
                                    // contoh: String kata = "ini isi kata"; SaveOutput(kata);
                                    // nanti hapus comment ini semua ya
                                }
                                else {
                                    choiceSub = 0;
                                }
                                break;
                            case 2:
                                System.out.println("""
                                        ============================================
                                                METODE ELIMINASI GAUSS-JORDAN
                                        ============================================
                                        """);
                                // INPUT CARA MASUKAN
                                printInput();
                                choiceInput = 0;
                                choiceInput = ErHandling(choiceInput, 1, 3);

                                if(choiceInput == 1) {
                                    System.out.println("Masukkan matrix Ax=b (augmented): ");
                                    /* ISI ALGORITMA KEYBOARD DI SINI */
                                    String result;
                                    matrix1 = Matrix.ReadMatrixKeyboard();
                                    // SPL.
                                    result = SPL.OutputSPLGauss(matrix1);
                                    System.out.println(result);

                                    /* SAVE OUTPUT */
                                    SaveOutput(result); // ganti null dengan tipe String yg mau disimpan, 
                                    // contoh: String kata = "ini isi kata"; SaveOutput(kata);
                                    // nanti hapus comment ini semua ya
                                    
                                }
                                else if(choiceInput == 2) {
                                    
                                    /* ISI ALGORITMA FILE DI SINI */
                                    matrix1 = new double[100][100];
                                    String result;
                                    System.out.print("Masukkan nama file: ");
                                    String fileName = sc.nextLine();
                                    matrix1 = InputOutput.readMatrixFile(matrix1, fileName);
                                    result = SPL.OutputSPLGauss(matrix1);
                                    System.out.println(result);
                                    /* SAVE OUTPUT */
                                    SaveOutput(result); // ganti null dengan tipe String yg mau disimpan, 
                                    // contoh: String kata = "ini isi kata"; SaveOutput(kata);
                                    // nanti hapus comment ini semua ya
                                }
                                else {
                                    choiceSub = 0;
                                }
                                break;
                            case 3:
                                System.out.println("""
                                        ============================================
                                                    METODE MATRIKS BALIKAN
                                        ============================================
                                        """);
                                // INPUT CARA MASUKAN
                                printInput();
                                choiceInput = 0;
                                choiceInput = ErHandling(choiceInput, 1, 3);

                                if(choiceInput == 1) {
                                    System.out.println("Masukkan matrix Ax=b (augmented): ");
                                    /* ISI ALGORITMA KEYBOARD DI SINI */
                                    String strResult = "";
                                    matrix1 = Matrix.ReadMatrixKeyboard();
                                    if((Matrix.getCol(matrix1) > Matrix.getRow(matrix1)+1) || (Matrix.getCol(matrix1) == Matrix.getRow(matrix1)) || (Matrix.getCol(matrix1) < Matrix.getRow(matrix1))) {
                                        strResult = "SPL tidak dapat diselesaikan dengan metode balikan.";
                                        System.out.println(strResult);
                                    }
                                    else {
                                        strResult = SPL.OutputSPLInverse(matrix1);
                                        System.out.println(strResult);
                                    }

                                    /* SAVE OUTPUT */
                                    SaveOutput(strResult);
                                }
                                else if(choiceInput == 2) {
                                    String strResult = "";
                                    System.out.print("Masukkan nama file: ");
                                    String fileName = sc.nextLine();
                                    double [][] matrixSPL = new double[100][100];
                                    matrixSPL = InputOutput.readMatrixFile(matrixSPL, fileName);
                                    if((Matrix.getCol(matrixSPL) > Matrix.getRow(matrixSPL)+1) || (Matrix.getCol(matrixSPL) == Matrix.getRow(matrixSPL)) || (Matrix.getCol(matrixSPL) < Matrix.getRow(matrixSPL))) {
                                        strResult = "SPL tidak dapat diselesaikan dengan metode balikan.";
                                        System.out.println(strResult);
                                    }
                                    else {
                                        strResult = SPL.OutputSPLInverse(matrixSPL);
                                        System.out.println(strResult);
                                    }

                                    /* SAVE OUTPUT */
                                    SaveOutput(strResult);
                                }
                                else {
                                    choiceSub = 0;
                                }
                                break;
                            case 4:
                                System.out.println("""
                                        ============================================
                                                        KAIDAH CRAMER
                                        ============================================
                                        """);
                                // INPUT CARA MASUKAN
                                printInput();
                                choiceInput = 0;
                                choiceInput = ErHandling(choiceInput, 1, 3);

                                if(choiceInput == 1) {
                                    System.out.println("Masukkan matrix Ax=b (augmented): ");
                                    /* ISI ALGORITMA KEYBOARD DI SINI */
                                    String strResult = "";
                                    matrix1 = Matrix.ReadMatrixKeyboard();
                                    if((Matrix.getCol(matrix1) > Matrix.getRow(matrix1)+1) || (Matrix.getCol(matrix1) == Matrix.getRow(matrix1)) || (Matrix.getCol(matrix1) < Matrix.getRow(matrix1))) {
                                        strResult = "SPL tidak dapat diselesaikan dengan kaidah cramer.";
                                        System.out.println(strResult);
                                    }
                                    else {
                                        strResult = SPL.OutputSPLCramer(matrix1);
                                        System.out.println(strResult);
                                    }

                                    /* SAVE OUTPUT */
                                    SaveOutput(strResult);
                                }
                                else if(choiceInput == 2) {
                                    String strResult = "";
                                    System.out.print("Masukkan nama file: ");
                                    String fileName = sc.nextLine();
                                    double [][] matrixSPL = new double[100][100];
                                    matrixSPL = InputOutput.readMatrixFile(matrixSPL, fileName);
                                    if((Matrix.getCol(matrixSPL) > Matrix.getRow(matrixSPL)+1) || (Matrix.getCol(matrixSPL) == Matrix.getRow(matrixSPL)) || (Matrix.getCol(matrixSPL) < Matrix.getRow(matrixSPL))) {
                                        strResult = "SPL tidak dapat diselesaikan dengan kaidah cramer.";
                                        System.out.println(strResult);
                                    }
                                    else {
                                        strResult = SPL.OutputSPLCramer(matrixSPL);
                                        System.out.println(strResult);
                                    }

                                    /* SAVE OUTPUT */
                                    SaveOutput(strResult);
                                }

                                else {
                                    choiceSub = 0;
                                }
                                break;
                            case 5:
                                break;
                        }
                    }while(choiceSub == 0);
                    break;
                    
                case 2:
                    do {
                        System.out.println("""
                            ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                        ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                            
                            D E T E R M I N A N

                        ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                            ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                                """);
                        // INPUT SUBMENU
                        printSub(subMenuDET);
                        choiceSub = 0;
                        choiceSub = ErHandling(choiceSub, 1, 3);
                        
                        switch (choiceSub) {
                            case 1:
                                System.out.println("""
                                        ===============================
                                            METODE REDUKSI BARIS
                                        ===============================
                                        """);
                                // INPUT CARA MASUKAN
                                printInput();
                                int choiceInput = 0;
                                choiceInput = ErHandling(choiceInput, 1, 3);

                                if(choiceInput == 1) {
                                    /* ISI ALGORITMA KEYBOARD DI SINI */
                                    matrix1 = Matrix.ReadMatrixSquare();
                                    double det;
                                    String result;
                                    det = OpMatrix.detGauss(matrix1);
                                    System.out.printf("Hasil determinan matrix adalah: %f\n", det);
                                    result = String.format("Hasil determinan matrix adalah: %f\n", det);               
                                    /* SAVE OUTPUT */
                                    SaveOutput(result); // ganti null dengan tipe String yg mau disimpan, 
                                    // contoh: String kata = "ini isi kata"; SaveOutput(kata);
                                    // nanti hapus comment ini semua ya
                                }
                                else if(choiceInput == 2) {
                                    /* ISI ALGORITMA FILE DI SINI */
                                    matrix1 = new double[100][100];
                                    double det;
                                    String result;
                                    System.out.print("Masukkan nama file: ");
                                    String fileName = sc.nextLine();
                                    matrix1 = InputOutput.readMatrixFile(matrix1, fileName);
                                    while (!Matrix.isSquare(matrix1)){
                                        System.out.print("Masukkan nama file: ");
                                        fileName = sc.nextLine();
                                        matrix1 = InputOutput.readMatrixFile(matrix1, fileName);
                                    }
                                    det = OpMatrix.detGauss(matrix1);
                                    System.out.printf("Hasil determinan matrix adalah: %f\n", det);
                                    result = String.format("Hasil determinan matrix adalah: %f\n", det); 

                                    /* SAVE OUTPUT */
                                    SaveOutput(result); // ganti null dengan tipe String yg mau disimpan, 
                                    // contoh: String kata = "ini isi kata"; SaveOutput(kata);
                                    // nanti hapus comment ini semua ya
                                }
                                else {
                                    choiceSub = 0;
                                }
                                break;
                            case 2:
                                System.out.println("""
                                        ===============================
                                            METODE EKSPANSI KOFAKTOR
                                        ===============================
                                        """);
                                // INPUT CARA MASUKAN
                                printInput();
                                choiceInput = 0;
                                choiceInput = ErHandling(choiceInput, 1, 3);

                                if(choiceInput == 1) {
                                    System.out.println("Masukkan Matrix: ");
                                    matrix1 = Matrix.ReadMatrixKeyboard();
                                    String strResult = String.format("Determinan = %.4f",OpMatrix.detCofactor(matrix1));
                                    System.out.println(strResult);
                                    
                                    /* SAVE OUTPUT */
                                    SaveOutput(strResult);
                                }
                                else if(choiceInput == 2) {
                                    System.out.print("Masukkan nama file: ");
                                    String fileName = sc.nextLine();
                                    double [][] matrixDet = new double[100][100];
                                    matrixDet = InputOutput.readMatrixFile(matrixDet, fileName);
                                    String strResult = String.format("Determinan = %.4f",OpMatrix.detCofactor(matrixDet));
                                    System.out.println(strResult);

                                    /* SAVE OUTPUT */
                                    SaveOutput(null);
                                }
                                else {
                                    choiceSub = 0;
                                }
                                break;
                        }
                    }while(choiceSub == 0);
                    break;
                case 3:
                    do {
                        System.out.println("""
                            ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                        ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                            
                        M A T R I K S  B A L I K A N

                        ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                            ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                                """);
                        // INPUT SUBMENU
                        printSub(subMenuINV);
                        choiceSub = 0;
                        choiceSub = ErHandling(choiceSub, 1,3);
                        
                        switch (choiceSub) {
                            case 1:
                                System.out.println("""
                                        ===============================
                                        METODE ELIMINASI GAUSS-JORDAN
                                        ===============================
                                        """);
                                // INPUT CARA MASUKAN
                                printInput();
                                int choiceInput = 0;
                                choiceInput = ErHandling(choiceInput, 1, 3);

                                if(choiceInput == 1) {
                                    
                                    /* ISI ALGORITMA KEYBOARD DI SINI */
                                    matrix1 = Matrix.ReadMatrixSquare();
                                    System.out.println("Hasil inverse matrixnya:");
                                    String result = OpMatrix.strInverseGauss(matrix1);
                                    result = String.format("Hasil inverse matrixnya: \n" + result);
                                    /* SAVE OUTPUT */
                                    SaveOutput(result); // ganti null dengan tipe String yg mau disimpan, 
                                    // contoh: String kata = "ini isi kata"; SaveOutput(kata);
                                    // nanti hapus comment ini semua ya
                                }
                                else if(choiceInput == 2) {
                                    
                                    /* ISI ALGORITMA FILE DI SINI */
                                    matrix1 = new double[100][100];
                                    System.out.print("Masukkan nama file: ");
                                    String fileName = sc.nextLine();
                                    matrix1 = InputOutput.readMatrixFile(matrix1, fileName);
                                    while (!Matrix.isSquare(matrix1)){
                                        System.out.print("Masukkan nama file: ");
                                        fileName = sc.nextLine();
                                        matrix1 = InputOutput.readMatrixFile(matrix1, fileName);    
                                    }
                                    System.out.println("Hasil inverse matrixnya:");
                                    String result = OpMatrix.strInverseGauss(matrix1);
                                    result = String.format("Hasil inverse matrixnya: \n" + result);
                                    /* SAVE OUTPUT */
                                    SaveOutput(result); // ganti null dengan tipe String yg mau disimpan, 
                                    // contoh: String kata = "ini isi kata"; SaveOutput(kata);
                                    // nanti hapus comment ini semua ya
                                }
                                else {
                                    choiceSub = 0;
                                }
                                break;
                            case 2:
                                System.out.println("""
                                        ===============================
                                                METODE ADJOINT
                                        ===============================
                                        """);
                                // INPUT CARA MASUKAN
                                printInput();
                                choiceInput = 0;
                                choiceInput = ErHandling(choiceInput, 1, 3);

                                if(choiceInput == 1) {
                                    String strResult = "";
                                    System.out.println("Masukkan Matrix: ");
                                    matrix1 = Matrix.ReadMatrixKeyboard();
                                    double[][] result = OpMatrix.inverseAdjoint(matrix1);
                                    if(result[0][0] == -999) {
                                        strResult = "Matrix tidak mempunyain balikan.";
                                        System.out.println(strResult);
                                    }
                                    else{
                                        strResult = "Hasil Matrix balikan: \n";
                                        System.out.print(strResult);
                                        strResult += Matrix.DisplayMatrix(result);System.out.println();
                                    }
                                    /* save output */
                                    SaveOutput(strResult);
                                }
                                else if(choiceInput == 2) {
                                    System.out.print("Masukkan nama file: ");
                                    String fileName = sc.nextLine();
                                    double [][] matrixInv = new double[100][100];
                                    matrixInv = InputOutput.readMatrixFile(matrixInv, fileName);
                                    double[][] result = OpMatrix.inverseAdjoint(matrixInv);
                                    String strResult = "";
                                    if(result[0][0] == -999) {
                                        strResult = "Matrix tidak mempunyain balikan.";
                                        System.out.println(strResult);
                                    }
                                    else{
                                        strResult = "Hasil Matrix balikan: \n";
                                        System.out.print(strResult);
                                        strResult += Matrix.DisplayMatrix(result);System.out.println();
                                    }
                                    /* SAVE OUTPUT */
                                    SaveOutput(strResult);
                                }
                                else {
                                    choiceSub = 0;
                                }
                                break;
                        }
                    }while(choiceSub == 0);
                    break;
                case 4:
                    System.out.println("""
                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                        
                   I N T E R P O L A S I  P O L I N O M

                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                            """);
                    // INPUT CARA MASUKAN
                    System.out.println(YELLOW + WHITE_BG + " INPUT: " + RESET);
                    System.out.println(input);
                    System.out.print("Masukan pilihan input: ");
                    int choiceInput = 0;
                    choiceInput = ErHandling(choiceInput, 1, 3);

                    if(choiceInput == 1) {
                        double[][] result = Interpolation.InterpolasiKeyboard();
                        String strResult = Interpolation.outputInterpolasi(result);
                        strResult += ", " + Interpolation.outputFungsi(result,(Interpolation.X(-9999)));
                        SaveOutput(strResult);
                    }
                    else if(choiceInput == 2) {
                        System.out.print("Masukkan nama file: ");
                        String fileName = sc.nextLine();
                        double [][] matrixPolinom = new double[100][100];
                        matrixPolinom = InputOutput.readMatrixFile(matrixPolinom, fileName);
                        // Matrix.DisplayMatrix(matrixPolinom);
                        double[][] result = Interpolation.InterpolasiFile(matrixPolinom);
                        String strResult = Interpolation.outputInterpolasi(result);
                        strResult += ", " + Interpolation.outputFungsi(result,(Interpolation.X(matrixPolinom[matrixPolinom.length-1][0])));
                        SaveOutput(strResult);
                    }
                    break;
                case 5:
                    System.out.println("""
                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                        
                         I N T E R P O L A S I  
                       B I C U B I C  S P L I N E

                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                            """);
                    // INPUT CARA MASUKAN
                    System.out.println(YELLOW + WHITE_BG + " INPUT: " + RESET);
                    System.out.print("Masukkan nama file: ");
                    String fileName = sc.nextLine();
                    double [][] matrixBicubic = new double[100][100];
                    matrixBicubic = InputOutput.readMatrixFile(matrixBicubic, fileName);
                    while(Matrix.getCol(matrixBicubic) != 4)
                    {
                        System.out.println("Ukuran matrix salah, masukkan matrix 4x4.");
                        System.out.print("Masukkan nama file: ");
                        fileName = sc.nextLine();
                        matrixBicubic = new double[100][100];
                        matrixBicubic = InputOutput.readMatrixFile(matrixBicubic, fileName);
                    }
                    String result = Bicubic.bicubicSI(matrixBicubic);
                    
                    // Save Output
                    SaveOutput(result);
                    break;
                case 6:
                    System.out.println("""
                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                        
                             R E G R E S I 
                       L I N E A R  B E R G A N D A

                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                            """);
                    // INPUT CARA MASUKAN
                    System.out.println(YELLOW + WHITE_BG + " INPUT: " + RESET);
                    System.out.println(input);
                    System.out.print("Masukan pilihan input: ");
                    choiceInput = 0;
                    choiceInput = ErHandling(choiceInput, 1, 3);

                    if(choiceInput == 1) {
                        
                        /* ISI ALGORITMA KEYBOARD DI SINI */
                        result = MultipleLinearRegression.regression();
                        /* SAVE OUTPUT */
                        SaveOutput(result); // ganti null dengan tipe String yg mau disimpan, 
                        // contoh: String kata = "ini isi kata"; SaveOutput(kata);
                        // nanti hapus comment ini semua ya

                    }
                    else if(choiceInput == 2) {
                        
                        /* ISI ALGORITMA FILE DI SINI */
                        matrix1 = new double[100][100];
                        System.out.print("Masukkan nama file: ");
                        fileName = sc.nextLine();
                        result = MultipleLinearRegression.regressionfile(matrix1, fileName);
                        /* SAVE OUTPUT */
                        SaveOutput(result); // ganti null dengan tipe String yg mau disimpan, 
                        // contoh: String kata = "ini isi kata"; SaveOutput(kata);
                        // nanti hapus comment ini semua ya
                    }
                    break; 
            }

        } while (choiceMenu < 7);
        sc.close(); // close Scanner (input)
    }

    public static int ErHandling(int choice, int a, int b) {
        sc = new Scanner(System.in);
        choice = sc.nextInt();
        while (choice < a || choice > b) {
            System.out.println(RED + "Pilihan tidak tersedia, mohon ulangi." + RESET);
            System.out.print("Masukan pilihan: ");
            choice = sc.nextInt();  
        }
        System.out.println();
        return choice;
    }

    public static void SaveOutput(String result) {
        // save output
        sc = new Scanner(System.in);
        System.out.print("\nSimpan hasil ke file? (y/n): ");
        String wannaSave = sc.nextLine();
        char wSave = wannaSave.charAt(0);                
        while(wSave != 'y' && wSave != 'n') {
            System.out.print("Input salah, ulangi: ");
            wannaSave = sc.nextLine();
            wSave = wannaSave.charAt(0);                
        } 
        if(wSave == 'y') {
            System.out.print("Masukkan nama file: ");
            String namaFile = sc.nextLine();
            InputOutput.outputFile(result, namaFile);
            System.out.println("File berhasil disimpan.");
        }
    }

    public static void printInput() {
        System.out.println(YELLOW + WHITE_BG + " INPUT: " + RESET);
        System.out.println(input);
        System.out.print("Masukan pilihan input: ");
    }

    public static void printSub(String sub) {
        System.out.println(YELLOW + WHITE_BG + " SUBMENU: " + RESET);
        System.out.println(sub);
        System.out.print("Masukan pilihan submenu: ");
    }
}
