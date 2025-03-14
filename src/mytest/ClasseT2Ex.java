package mytest;

import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;

public class ClasseT2Ex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
     
        int[] senha = new int[4];
        for (int i = 0; i < 4; i++) {
            senha[i] = random.nextInt(6) + 1; 
        }
        
        System.out.println("Bem-vindo ao Jogo da Senha!");
        System.out.println("Tente adivinhar a senha de quatro dígitos composta por números de 1 a 6.");
        System.out.println("Você tem 10 tentativas. Boa sorte!");

        boolean venceu = false;
        
        for (int tentativa = 1; tentativa <= 10; tentativa++) {
            System.out.println("\nTentativa " + tentativa + ": ");
            
          
            int[] tentativaJogador = new int[4];
            for (int i = 0; i < 4; i++) {
                System.out.print("Digite o número para a posição " + (i + 1) + ": ");
                tentativaJogador[i] = scanner.nextInt();
            }
            
          
            int corretos = 0;
            int deslocados = 0;
            
            boolean[] senhaUtilizada = new boolean[4]; 
            boolean[] tentativaUtilizada = new boolean[4];
            
          
            for (int i = 0; i < 4; i++) {
                if (tentativaJogador[i] == senha[i]) {
                    corretos++;
                    senhaUtilizada[i] = true;
                    tentativaUtilizada[i] = true;
                }
            }
            
           
            for (int i = 0; i < 4; i++) {
                if (!tentativaUtilizada[i]) {
                    for (int j = 0; j < 4; j++) {
                        if (!senhaUtilizada[j] && tentativaJogador[i] == senha[j]) {
                            deslocados++;
                            senhaUtilizada[j] = true;
                            break;
                        }
                    }
                }
            }
            
        
            System.out.println("Dígitos corretos: " + corretos);
            System.out.println("Dígitos deslocados: " + deslocados);
            
      
            if (corretos == 4) {
                venceu = true;
                System.out.println("Parabéns! Você acertou a senha!");
                break;
            }
        }
        
        if (!venceu) {
            System.out.println("\nSuas tentativas acabaram. O computador venceu.");
            System.out.print("A senha correta era: ");
            for (int num : senha) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
