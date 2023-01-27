package hw2;

public class Room {

  private int maxOccupancy;
  private double price;
  private int numberOfGuests;

  public Room(RoomType roomType, double price) {
    if (price >= 0) this.price = price;
    else throw new IllegalArgumentException();

    this.maxOccupancy = getOccupancy(roomType);
    this.numberOfGuests = 0;

  }

  public int getOccupancy(RoomType type) {
    return switch (type) {
      case SINGLE -> 1;
      case DOUBLE -> 2;
      case FAMILY -> 4;
    };
  }

  public boolean isAvailable() {
    return this.numberOfGuests == 0;
  }

  public void bookRoom(int numberOfGuests) {
    if (this.isAvailable()
            && numberOfGuests > 0
            && numberOfGuests <= this.maxOccupancy) {
        this.numberOfGuests = numberOfGuests;
    }
  }

  public int getNumberOfGuests() {
    return numberOfGuests;
  }
}
