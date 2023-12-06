package entities;

public class House {
    private String nameOwner;
    private String address;
    private double price;
    private int number;
    private boolean paymentStatus;
    private boolean allocationStatus;

    public House(String nameOwner, String address, double price, int number, boolean allocationStatus) {
        this.nameOwner = nameOwner;
        this.address = address;
        this.price = price;
        this.number = number;
        this.allocationStatus = allocationStatus;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public boolean isAllocationStatus() {
        return allocationStatus;
    }

    public void setAllocationStatus(boolean allocationStatus) {
        this.allocationStatus = allocationStatus;
    }

}