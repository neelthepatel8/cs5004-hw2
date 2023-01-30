package hw2;

/**
 * The type Room.
 */
public class Room {

  private final int maxOccupancy;
  private double price;
  private int numberOfGuests;

  /**
   * Instantiates a new Room.
   *
   * @param roomType the room type
   * @param price    the price
   */
  public Room(RoomType roomType, double price) {
    if (price >= 0) this.price = price;
    else throw new IllegalArgumentException();

    this.maxOccupancy = getOccupancy(roomType);
    this.numberOfGuests = 0;

  }

  /**
   * Gets occupancy.
   *
   * @param type the type
   * @return the occupancy
   */
  public int getOccupancy(RoomType type) {
    return switch (type) {
      case SINGLE -> 1;
      case DOUBLE -> 2;
      case FAMILY -> 4;
    };
  }

  /**
   * Is available boolean.
   *
   * @return the boolean
   */
  public boolean isAvailable() {
    return this.numberOfGuests == 0;
  }

  /**
   * Book room.
   *
   * @param numberOfGuests the number of guests
   */
  public void bookRoom(int numberOfGuests) {
    if (this.isAvailable()
            && numberOfGuests > 0
            && numberOfGuests <= this.maxOccupancy) {
      this.numberOfGuests = numberOfGuests;
    }
  }

  /**
   * Gets number of guests.
   *
   * @return the number of guests
   */
  public int getNumberOfGuests() {
    return numberOfGuests;
  }
}