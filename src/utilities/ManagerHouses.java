package utilities;

import entities.House;
import utilities.WordsChecker;

import java.util.ArrayList;
import java.util.Scanner;

import static utilities.WordsChecker.*;

public class ManagerHouses{
    static ArrayList<House> housesList = new ArrayList<>();
    public static void addHouse() {
        Scanner sc = new Scanner(System.in);
        char controler = ' ';

        do {
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

            House newHouse = new House(address, price, number, allocatedStatus);
            housesList.add(newHouse);

            System.out.println("Casa cadastrada com sucesso!\n\nSe desejar cadastrar uma nova casa, digite 'S' ou 'N'");
            controler = sc.next().toUpperCase().charAt(0);
            sc.nextLine();

        }while(controler == 'S');
    }

    public static void preAdd(String address, double price, int number, boolean allocatedStatus){
        House newHouse = new House(address, price, number, allocatedStatus);
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

        if(selected == null){
            System.out.println("Essa casa não existe.");
        }else{
            System.out.println("\nA casa foi alugada com sucesso, seja bem vindo!\n");
            selected.setAllocationStatus(false);
        }

    }

}
