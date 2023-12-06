package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Contract {
    private String nameOwner;
    private String addressOwner;
    private String nameClient;
    private String addressClient;
    private String addressHouse;
    private double priceHouse;
    private double securiteDeposit;

    public Contract(String nameOwner, String addressOwner, String nameClient, String addressClient, String addressHouse, double priceHouse, double securiteDeposit) {
        this.nameOwner = nameOwner;
        this.addressOwner = addressOwner;
        this.nameClient = nameClient;
        this.addressClient = addressClient;
        this.addressHouse = addressHouse;
        this.priceHouse = priceHouse;
        this.securiteDeposit = securiteDeposit;
    }
}
