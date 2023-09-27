
import java.util.Scanner;

public class Main {
    public static Scanner sc;

    public static void main(String[] args) {
        // TEXT COLOR
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String WHITE_BG = "\u001B[47m";
        
        // NECESSARY STRING
        String pilMenu = """
                1. Sistem Persamaaan Linier              
                2. Determinan
                3. Matriks balikan
                4. Interpolasi Polinom
                5. Interpolasi Bicubic Spline
                6. Regresi linier berganda
                7. Keluar
                """;
                
        String subMenuSPL = """
            
                1. Metode eliminasi Gauss
                2. Metode eliminasi Gauss-Jordan
                3. Metode matriks balikan
                4. Kaidah Cramer                 
                """;

        String subMenuDET = """
            
                1. Metode eliminasi Gauss (Reduksi Baris)?
                2. Metode ekspansi kofaktor               
                """;

        String subMenuINV = """
            
                1. Metode eliminasi Gauss-Jordan
                2. Metode adjoint               
                """;
        
        String input = """
            
                1. Keyboard
                2. File              
                """;

        String kelompok = """
                
                ░█████╗░██╗░░░██╗░█████╗░███╗░░██╗██╗░░██╗██╗
                ██╔══██╗██║░░░██║██╔══██╗████╗░██║██║░██╔╝██║
                ██║░░╚═╝██║░░░██║███████║██╔██╗██║█████═╝░██║
                ██║░░██╗██║░░░██║██╔══██║██║╚████║██╔═██╗░██║
                ╚█████╔╝╚██████╔╝██║░░██║██║░╚███║██║░╚██╗██║
                ░╚════╝░░╚═════╝░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝░░╚═╝╚═╝
                m a t r i x   c a l c u l a t o r
                """;
        String kelompok2 = """
                █▀▀ █░█ ▄▀█ █▄░█ █▄▀ █
                █▄▄ █▄█ █▀█ █░▀█ █░█ █
                matrix calculator
                """;
        
        String judul = """
                
                █▀▀ █░█ ▄▀█ █▄░█ █▄▀ █ █▄▀ █░█ █░░ ▄▀█ ▀█▀ █▀█ █▀█
                █▄▄ █▄█ █▀█ █░▀█ █░█ █ █░█ █▄█ █▄▄ █▀█ ░█░ █▄█ █▀▄
                """;
        
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
                System.out.println("Keluar dari program...");
            }

            // MENU
            switch (choiceMenu) {
                case 1:
                    System.out.println("""
                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                        
                S I S T E M  P E R S A M A A N  L I N E A R

                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                            """);
                    // INPUT SUBMENU
                    System.out.println(YELLOW + WHITE_BG + " SUBMENU: " + RESET);
                    System.out.println(subMenuSPL);
                    System.out.print("Masukan pilihan submenu: ");
                    int choiceSub = 0;
                    choiceSub = ErHandling(choiceSub, 1, 4);
                    
                    switch (choiceSub) {
                        case 1:
                            System.out.println("""
                                    ===============================
                                        METODE ELIMINASI GAUSS
                                    ===============================
                                    """);
                            // INPUT CARA MASUKAN
                            System.out.println(YELLOW + WHITE_BG + " INPUT: " + RESET);
                            System.out.println(input);
                            System.out.print("Masukan pilihan input: ");
                            int choiceInput = 0;
                            choiceInput = ErHandling(choiceInput, 1, 2);
 
                            if(choiceInput == 1) {
                                System.out.println("temp keyboard");
                            }
                            else {
                                System.out.println("temp file");
                            }
                            break;
                        case 2:
                            System.out.println("""
                                    ===============================
                                     METODE ELIMINASI GAUSS-JORDAN
                                    ===============================
                                    """);
                            // INPUT CARA MASUKAN
                            System.out.println(YELLOW + WHITE_BG + " INPUT: " + RESET);
                            System.out.println(input);
                            System.out.print("Masukan pilihan input: ");
                            choiceInput = 0;
                            choiceInput = ErHandling(choiceInput, 1, 2);

                            if(choiceInput == 1) {
                                System.out.println("temp keyboard");
                            }
                            else {
                                System.out.println("temp file");
                            }
                            break;
                        case 3:
                            System.out.println("""
                                    ===============================
                                        METODE MATRIKS BALIKAN
                                    ===============================
                                    """);
                            // INPUT CARA MASUKAN
                            System.out.println(YELLOW + WHITE_BG + " INPUT: " + RESET);
                            System.out.println(input);
                            System.out.print("Masukan pilihan input: ");
                            choiceInput = 0;
                            choiceInput = ErHandling(choiceInput, 1, 2);

                            if(choiceInput == 1) {
                                System.out.println("temp keyboard");
                            }
                            else {
                                System.out.println("temp file");
                            }
                            break;
                        case 4:
                            System.out.println("""
                                    ===============================
                                            KAIDAH CRAMER
                                    ===============================
                                    """);
                            // INPUT CARA MASUKAN
                            System.out.println(YELLOW + WHITE_BG + " INPUT: " + RESET);
                            System.out.println(input);
                            System.out.print("Masukan pilihan input: ");
                            choiceInput = 0;
                            choiceInput = ErHandling(choiceInput, 1, 2);

                            if(choiceInput == 1) {
                                System.out.println("temp keyboard");
                            }
                            else {
                                System.out.println("temp file");
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.println("""
                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                        
                           D E T E R M I N A N

                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                            """);
                    // INPUT SUBMENU
                    System.out.println(YELLOW + WHITE_BG + " SUBMENU: " + RESET);
                    System.out.println(subMenuDET);
                    System.out.print("Masukan pilihan submenu: ");
                    choiceSub = 0;
                    choiceSub = ErHandling(choiceSub, 1, 2);
                    
                    switch (choiceSub) {
                        case 1:
                            System.out.println("""
                                    ===============================
                                          METODE REDUKSI BARIS
                                    ===============================
                                    """);
                            // INPUT CARA MASUKAN
                            System.out.println(YELLOW + WHITE_BG + " INPUT: " + RESET);
                            System.out.println(input);
                            System.out.print("Masukan pilihan input: ");
                            int choiceInput = 0;
                            choiceInput = ErHandling(choiceInput, 1, 2);

                            if(choiceInput == 1) {
                                System.out.println("temp keyboard");
                            }
                            else {
                                System.out.println("temp file");
                            }
                            break;
                        case 2:
                            System.out.println("""
                                    ===============================
                                        METODE EKSPANSI KOFAKTOR
                                    ===============================
                                    """);
                            // INPUT CARA MASUKAN
                            System.out.println(YELLOW + WHITE_BG + " INPUT: " + RESET);
                            System.out.println(input);
                            System.out.print("Masukan pilihan input: ");
                            choiceInput = 0;
                            choiceInput = ErHandling(choiceInput, 1, 2);

                            if(choiceInput == 1) {
                                System.out.println("temp keyboard");
                            }
                            else {
                                System.out.println("temp file");
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("""
                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                        
                      M A T R I K S  B A L I K A N

                    ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
                            """);
                    // INPUT SUBMENU
                    System.out.println(YELLOW + WHITE_BG + " SUBMENU: " + RESET);
                    System.out.println(subMenuINV);
                    System.out.print("Masukan pilihan submenu: ");
                    choiceSub = 0;
                    choiceSub = ErHandling(choiceSub, 1, 2);
                    
                    switch (choiceSub) {
                        case 1:
                            System.out.println("""
                                    ===============================
                                     METODE ELIMINASI GAUSS-JORDAN
                                    ===============================
                                    """);
                            // INPUT CARA MASUKAN
                            System.out.println(YELLOW + WHITE_BG + " INPUT: " + RESET);
                            System.out.println(input);
                            System.out.print("Masukan pilihan input: ");
                            int choiceInput = 0;
                            choiceInput = ErHandling(choiceInput, 1, 2);

                            if(choiceInput == 1) {
                                System.out.println("temp keyboard");
                            }
                            else {
                                System.out.println("temp file");
                            }
                            break;
                        case 2:
                            System.out.println("""
                                    ===============================
                                            METODE ADJOINT
                                    ===============================
                                    """);
                            // INPUT CARA MASUKAN
                            System.out.println(YELLOW + WHITE_BG + " INPUT: " + RESET);
                            System.out.println(input);
                            System.out.print("Masukan pilihan input: ");
                            choiceInput = 0;
                            choiceInput = ErHandling(choiceInput, 1, 2);

                            if(choiceInput == 1) {
                                System.out.println("temp keyboard");
                            }
                            else {
                                System.out.println("temp file");
                            }
                            break;
                    }
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
                    choiceInput = ErHandling(choiceInput, 1, 2);

                    if(choiceInput == 1) {
                        System.out.println("temp keyboard");
                        Interpolation.Interpolasi();
                    }
                    else {
                        System.out.println("temp file");
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
                    System.out.println(input);
                    System.out.print("Masukan pilihan input: ");
                    choiceInput = 0;
                    choiceInput = ErHandling(choiceInput, 1, 2);

                    if(choiceInput == 1) {
                        System.out.println("temp keyboard");
                    }
                    else {
                        System.out.println("temp file");
                    }
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
                    choiceInput = ErHandling(choiceInput, 1, 2);

                    if(choiceInput == 1) {
                        System.out.println("temp keyboard");
                    }
                    else {
                        System.out.println("temp file");
                    }
                    break; 
            }

        } while (choiceMenu < 7);
        sc.close(); // close Scanner (input)
    }

    public static int ErHandling(int choice, int a, int b) {
        String RED = "\u001B[31m";
        String RESET = "\u001B[0m";
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
}
