package Main;
import java.util.Scanner;

public class Main {
    // public static void ErSubMenu(int choiceSub) {
    //     choiceSub = sc.nextInt();  
    //     while (choiceSub < 1 || choiceSub > 4) {
    //         System.out.println("Pilihan tidak tersedia, mohon ulangi.");
    //         System.out.print("Masukan pilihan submenu: ");
    //         choiceSub = sc.nextInt();  
    //     }
    //     System.out.println();
    // }

    public static void main(String[] args) {
        // TEXT COLOR
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String WHITE_BG = "\u001B[47m";
        
        // NECESSARY STRING
        String pilMenu = """
                1. Sistem Persamaaan Linier
                    a. Metode eliminasi Gauss
                    b. Metode eliminasi Gauss-Jordan
                    c. Metode matriks balikan
                    d. Kaidah Cramer                 
                2. Determinan
                    a. Metode eliminasi Gauss (Reduksi Baris)?
                    b. Metode ekspansi kofaktor
                3. Matriks balikan
                    a. Metode eliminasi Gauss-Jordan
                    b. Metode adjoint
                4. Interpolasi Polinom
                5. Interpolasi Bicubic Spline
                6. Regresi linier berganda
                7. Keluar
                """;
                
        String subMenu = """
            
                1. Metode eliminasi Gauss
                2. Metode eliminasi Gauss-Jordan
                3. Metode matriks balikan
                4. Kaidah Cramer                 
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
        int choiceMenu;
        System.out.print(kelompok2);

        do {
            // INPUT MENU
            System.out.println("\n" + YELLOW + WHITE_BG + " MENU: " + RESET);
            System.out.println(YELLOW + pilMenu + RESET);

            System.out.print("Masukan pilihan menu: ");
            
            choiceMenu = sc.nextInt();  
            while (choiceMenu < 1 || choiceMenu > 7) {
                System.out.println("Pilihan tidak tersedia, mohon ulangi.");
                System.out.print("Masukan pilihan menu: ");
                choiceMenu = sc.nextInt();  
            }
            System.out.println();

            if(choiceMenu == 7) {
                System.out.println("Keluar dari program...");
            }
            
            
            // MENU
            switch (choiceMenu) {
                case 1:
                    System.out.println("== SISTEM PERSAMAAN LINEAR ==");
                    // INPUT SUBMENU
                    System.out.println(subMenu);
                    System.out.print("Masukan pilihan submenu: ");
                    int choiceSub;
                    choiceSub = sc.nextInt();  
                    while (choiceSub < 1 || choiceSub > 4) {
                        System.out.println("Pilihan tidak tersedia, mohon ulangi.");
                        System.out.print("Masukan pilihan submenu: ");
                        choiceSub = sc.nextInt();  
                    }
                    System.out.println();
                    
                    switch (choiceSub) {
                        case 1:
                            System.out.println("-- Metode eliminasi Gauss --");
                            // INPUT CARA MASUKAN
                            System.out.println(input);
                            System.out.print("Masukan pilihan input: ");
                            int choiceInput;
                            choiceInput = sc.nextInt();  
                            while (choiceInput < 1 || choiceInput > 2) {
                                System.out.println("Pilihan tidak tersedia, mohon ulangi.");
                                System.out.print("Masukan pilihan input: ");
                                choiceInput = sc.nextInt();  
                            }
                            System.out.println();
                            if(choiceInput == 1) {
                                System.out.println("temp keyboard");
                            }
                            else {
                                System.out.println("temp file");
                            }
                            break;
                        case 2:
                            System.out.println("-- Metode eliminasi Gauss-Jordan --");
                            break;
                        case 3:
                            System.out.println("-- Metode matriks balikan --");
                            break;
                        case 4:
                            System.out.println("-- Kaidah Cramer --");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("== DETERMINAN ==");
                    break;
                case 3:
                    System.out.println("== MATRIKS BALIKAN ==");
                    break;
                case 4:
                    System.out.println("== INTERPOLASI POLINOM ==");
                    break;
                case 5:
                    System.out.println("== INTERPOLASI BICUBIC SPLINE ==");
                    break;
                case 6:
                    System.out.println("== REGRESI LINEAR BERGANDA ==");
                    break; 
            }

        } while (choiceMenu < 7);
        sc.close(); // close Scanner (input)
    }
}
