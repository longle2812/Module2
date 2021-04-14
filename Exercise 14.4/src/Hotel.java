public class Hotel {
    private int rentDay;
    private String typeOfRoom;
    private long priceOfRoom;
    private Person person;


    public Hotel(int rentDay, String typeOfRoom, long priceOfRoom, Person person) {
        this.rentDay = rentDay;
        this.typeOfRoom = typeOfRoom;
        this.priceOfRoom = priceOfRoom;
        this.person = person;
    }

    public Hotel() {
    }

    public int getRentDay() {
        return rentDay;
    }

    public void setRentDay(int rentDay) {
        this.rentDay = rentDay;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public long getPriceOfRoom() {
        return priceOfRoom;
    }

    public Person getHuman() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "numberInLodging=" + rentDay +
                ", typeOfRoom='" + typeOfRoom + '\'' +
                ", priceOfRoom=" + priceOfRoom +
                ", person=" + person +
                '}';
    }

    public void setPriceOfRoom(long priceOfRoom) {
        this.priceOfRoom = priceOfRoom;
    }


}
