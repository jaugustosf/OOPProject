import utilities.ManagerHouses;


import java.util.Scanner;

public class MainMenu{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Linhas abaixo apenas para declarar casas previamente.
        ManagerHouses.preAdd("Leticia Alcântara","Raimundo Felipe", 12, 199, true);
        ManagerHouses.preAdd("Nicolas Silva","Inacio Never", 13, 188, false);
        ManagerHouses.preAdd("Victor Gomes","Estevao Ribeito", 14, 177, true);
        ManagerHouses.preAdd("João Augusto","Teodorio Nascimento", 17, 666, false);

        int option = 0;

        while (option != 6) {
            exibirMenu();
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\nListar todas as casas:");
                    ManagerHouses.listAll();
                    break;

                case 2:
                    System.out.println("\nCasas não alocadas:");
                    ManagerHouses.listFreeHouses();
                    break;

                case 3:
                    System.out.println("\nCadastrar uma casa:");
                    ManagerHouses.addHouse();
                    break;

                case 4:
                    System.out.println("\nAlugar uma casa:");
                    ManagerHouses.allocateHouse();
                    break;

                case 5:
                    System.out.println("\nRemover casa: ");
                    ManagerHouses.removeHouse();
                    break;

                case 6:
                    System.out.println("\nSaindo do programa!");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
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
        System.out.println("5. Remover uma casa");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }
}
