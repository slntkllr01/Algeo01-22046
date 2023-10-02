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
                                    System.out.println("temp keyboard");
                                }
                                else if(choiceInput == 2) {
                                    System.out.println("temp file");
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
                                    System.out.println("temp keyboard");
                                }
                                else if(choiceInput == 2) {
                                    System.out.println("temp file");
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
                                    System.out.println("temp keyboard");
                                }
                                else if(choiceInput == 2) {
                                    System.out.println("temp file");
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
                                    System.out.println("temp keyboard");
                                }
                                else if(choiceInput == 2) {
                                    System.out.println("temp file");
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
                                    System.out.println("temp keyboard");
                                }
                                else if(choiceInput == 2) {
                                    System.out.println("temp file");
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
                                    System.out.printf("Determinan = %.4f\n",OpMatrix.detCofactor(matrix1));
                                }
                                else if(choiceInput == 2) {
                                    System.out.println("temp file");
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
                                    System.out.println("temp keyboard");
                                }
                                else if(choiceInput == 2) {
                                    System.out.println("temp file");
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
                                    System.out.println("Masukkan Matrix: ");
                                    matrix1 = Matrix.ReadMatrixKeyboard();
                                    double[][] result = OpMatrix.inverseAdjoint(matrix1);
                                    if(result[0][0] == -999) {
                                        System.out.println("Matrix tidak mempunyain balikan.");
                                    }
                                    else{
                                        System.out.println("Hasil Matrix balikan: ");
                                        Matrix.DisplayMatrix(result);
                                    }
                                }
                                else if(choiceInput == 2) {
                                    System.out.println("temp file");
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
                        System.out.println("temp keyboard");
                        double[][] result = Interpolation.InterpolasiKeyboard();
                        Interpolation.outputInterpolasi(result);
                        Interpolation.outputFungsi(result);
                    }
                    else if(choiceInput == 2) {
                        System.out.println("temp file");
                        double[][] point = Interpolation.contohMat(); //contoh matrix point, nanti dari file
                        double[][] result = Interpolation.InterpolasiFile(point);
                        Interpolation.outputInterpolasi(result);
                        Interpolation.outputFungsi(result);
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
                    // ###########3 ERROR INPUT : row < 4
                    System.out.println(YELLOW + WHITE_BG + " INPUT: " + RESET);
                    System.out.print("Masukkan nama file: ");
                    String fileName = sc.nextLine();
                    double [][] matrixBicubic = new double[100][100];
                    matrixBicubic = InputOutput.readMatrixFile(matrixBicubic, fileName);
                    String result = Bicubic.bicubicSI(matrixBicubic);
                    
                    // save output
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
                        System.out.println("temp keyboard");

                    }
                    else if(choiceInput == 2) {
                        System.out.println("temp file");
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
        System.out.print("Simpan hasil ke file? (y/n): ");
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
        // return choice;
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
