package utilities;

import entities.House;

import java.util.ArrayList;
import java.util.Scanner;

import static utilities.FileWriter.*;
import static utilities.WordsChecker.*;

public class ManagerHouses{
    static ArrayList<House> housesList = new ArrayList<>();
    public static void addHouse() {
        Scanner sc = new Scanner(System.in);
        char controler = ' ';

        do {
            System.out.println("Digite o nome do dono da casa: ");
            String nameOwner = sc.nextLine();

            System.out.println("Digite o endereço da casa: ");
            String address = sc.nextLine();

            if (!wordsVerify(address)) {
                System.out.println("\nDigite apenas letras.\n");
                continue;
            }

            System.out.println("Digite o número da casa: ");
            int number = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite o preço da casa: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.print("A casa está livre? (Digite 'S' para Sim, 'N' para Não): ");
            String allocationStatus = sc.nextLine();
            boolean allocatedStatus = allocationStatus.equalsIgnoreCase("S");

            House newHouse = new House(nameOwner, address, price, number, allocatedStatus);
            housesList.add(newHouse);

            System.out.println("Casa cadastrada com sucesso!\n\nSe desejar cadastrar uma nova casa, digite 'S' ou 'N'");
            controler = sc.next().toUpperCase().charAt(0);
            sc.nextLine();

        }while(controler == 'S');
    }

    public static void preAdd(String nameOwner,String address, double price, int number, boolean allocatedStatus){
        House newHouse = new House(nameOwner ,address, price, number, allocatedStatus);
        housesList.add(newHouse);
    }

    public static void listAll(){
        int counter = 1;
        if (housesList.isEmpty()){
            System.out.println("A lista está vazia!");
        }
        for (House house: housesList) {
            System.out.printf("Casa: %d\nEndereço: %s\nNúmero: %d\nPreço: %.2f\nEstado de alocação: %s\n\n",counter,
                                                                                                            house.getAddress(),
                                                                                                            house.getNumber(),
                                                                                                            house.getPrice(),
                                                                                                            house.isAllocationStatus() ? "Livre" : "Ocupado");
            counter++;
        }
    }

    public static void listFreeHouses(){
        int counter = 1;
        if (housesList.isEmpty()){
            System.out.println("A lista está vazia!");
        }
        for (House house: housesList) {
            if(house.isAllocationStatus())
                System.out.printf("Casa: %d\nEndereço: %s\nNúmero: %d\nPreço: %.2f\nEstado de alocação: %s\n\n",counter,
                                                                                                                house.getAddress(),
                                                                                                                house.getNumber(),
                                                                                                                house.getPrice(),
                                                                                                                house.isAllocationStatus() ? "Livre" : "Ocupado");
            counter++;
        }
    }

    public static void allocateHouse(){
        Scanner sc = new Scanner(System.in);

        listFreeHouses();

        System.out.print("Indique o numero da casa que deseja alugar: ");
        int houseNumber = sc.nextInt();

        House selected = housesList.stream().filter(x -> x.getNumber() == houseNumber).findFirst().orElse(null);

        sc.nextLine();
        System.out.print("Digite o seu nome: ");
        String nameClient = sc.nextLine();

        System.out.print("Digite o endereço onde reside: ");
        String addressClient = sc.nextLine();

        if(selected == null){
            System.out.println("Essa casa não existe.\n");
            return;
        }

        sendContract(selected.getNameOwner(), selected.getAddress(), nameClient, addressClient, selected.getPrice());

        System.out.println("\nA casa foi alugada com sucesso, seja bem vindo!\n");
        selected.setAllocationStatus(false);
    }

    public static void removeHouse(){
        Scanner num = new Scanner(System.in);
        listAll();

        System.out.print("Digite o número da casa que deseja remover: ");
        int numberRemover = num.nextInt();
        for (House house: housesList){
            if (house.getNumber() == numberRemover) {
                if (house.isAllocationStatus()) {
                    housesList.remove(house);
                    System.out.println("Casas removida!");
                    break;
                } else {
                    System.out.println("Esta casa está alugada por uma pessoa, não é possível remover do sistema agora.\n");
                }
            }
        }
    }
}
