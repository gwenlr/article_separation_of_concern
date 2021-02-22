package tech.article.soc.model;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notNull;

public class Client {

    private final String name;
    private final String address;
    private final String phoneNumber;

    public Client(String name, String address, String phoneNumber) {
        this.name = notNull( name, "name argument shall not be null nor empty");
        this.address = notNull( address, "address argument shall not be null nor empty");
        this.phoneNumber = notNull( phoneNumber, "phoneNumber argument shall not be null nor empty");
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return name.equals(client.name) &&
                address.equals(client.address) &&
                phoneNumber.equals(client.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
