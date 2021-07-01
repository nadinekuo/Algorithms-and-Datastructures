import java.util.Objects;

class House {

    private int houseNumber;

    private String owner;

    public House(int houseNumber, String owner) {
        this.houseNumber = houseNumber;
        this.owner = owner;
    }

    public String toString() {
        return this.houseNumber + ": " + owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        House house = (House) o;
        return houseNumber == house.houseNumber && Objects.equals(owner, house.owner);
    }
}