import java.util.Scanner;

public class MainMenu{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;

        while (option != 5) {
            exibirMenu();
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Listar todas as casas");
                    break;

                case 2:
                    System.out.println("Casas não alocadas");
                    break;

                case 3:
                    System.out.println("Cadastrar uma casa");
                    break;

                case 4:
                    System.out.println("Alugar uma casa");
                    break;

                case 5:
                    System.out.println("Saindo do programa");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        sc.close();
    }

    public static void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Listar todas as casas");
        System.out.println("2. Casas não alocadas");
        System.out.println("3. Cadastrar uma casa");
        System.out.println("4. Alugar uma casa");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }
}
