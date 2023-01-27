package hw2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.util.Random;

public class RoomTest {

  private double getRandomPrice(boolean bad) {
    Random random = new Random();
    if (!bad) {
      return random.nextDouble(0.1, 100000);
    }
    return random.nextDouble(-10, 0);
  }

  private int getRandomNumber(int start, int end) {
    return new Random().nextInt(start, end);
  }

  private RoomType getRandomRoomType() {
    RoomType[] allTypes = RoomType.values();
    Random random = new Random();
    return allTypes[random.nextInt(0, allTypes.length)];
  }

  public void testGoodConstructor() {
    double price;
    RoomType roomType;
    Room room;

    for (int i = 0; i <= 100; i++) {
      price = getRandomPrice(false);
      roomType = getRandomRoomType();
      room = new Room(roomType, price);
      assertEquals(0, room.getNumberOfGuests());
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadConstructor() {
    double price;
    RoomType roomType;
    Room room;

    for (int i = 0; i <= 100; i++) {
      price = getRandomPrice(true);
      roomType = getRandomRoomType();
      room = new Room(roomType, price);
    }
  }

  @Test
  public void isAvailable() {

  }

  @Test
  public void testGoodBookRoomSingle() {
    Room singleRoom = new Room(RoomType.SINGLE, 100);
    singleRoom.bookRoom(1);
    assertEquals(1, singleRoom.getNumberOfGuests());
  }

  @Test
  public void testBadBookRoomSingle() {

    int numberOfPeople;

    for (int i = 0; i <= 100; i++) {
      Room singleRoom = new Room(RoomType.SINGLE, 100);
      numberOfPeople = getRandomNumber(-10, 0);
      singleRoom.bookRoom(numberOfPeople);
      assertEquals(0, singleRoom.getNumberOfGuests());
    }
  }

  @Test
  public void testGoodBookRoomDouble() {

    int numberOfPeople;

    for (int i = 0; i <= 100; i++) {
      Room doubleRoom = new Room(RoomType.DOUBLE, 100);
      numberOfPeople = getRandomNumber(1, 2);
      doubleRoom.bookRoom(numberOfPeople);
      assertEquals(numberOfPeople, doubleRoom.getNumberOfGuests());
    }
  }

  @Test
  public void testBadBookRoomDouble() {

    int numberOfPeople;

    for (int i = 0; i <= 100; i++) {
      Room doubleRoom = new Room(RoomType.DOUBLE, 100);
      numberOfPeople = getRandomNumber(-10, 0);
      doubleRoom.bookRoom(numberOfPeople);
      assertEquals(0, doubleRoom.getNumberOfGuests());
    }
  }

  @Test
  public void testGoodBookRoomFamily() {

    int numberOfPeople;

    for (int i = 0; i <= 100; i++) {
      Room familyRoom = new Room(RoomType.FAMILY, 100);
      numberOfPeople = getRandomNumber(1, 4);
      familyRoom.bookRoom(numberOfPeople);
      assertEquals(numberOfPeople, familyRoom.getNumberOfGuests());
    }
  }

  @Test
  public void testBadBookRoomFamily() {

    int numberOfPeople;

    for (int i = 0; i <= 100; i++) {
      Room familyRoom = new Room(RoomType.FAMILY, 100);
      numberOfPeople = getRandomNumber(-10, 0);
      familyRoom.bookRoom(numberOfPeople);
      assertEquals(0, familyRoom.getNumberOfGuests());
    }
  }

  @Test
  public void testBookRoomMultipleTimes() {
    Room room = new Room(RoomType.FAMILY, 100);

    // Book first time
    room.bookRoom(3);
    assertEquals(3, room.getNumberOfGuests());

    // Book again
    room.bookRoom(4);
    assertEquals(3, room.getNumberOfGuests());
  }

  @Test
  public void testAvailabilityBeforeBooking() {
    Room room = new Room(RoomType.SINGLE, 100);
    assertTrue(room.isAvailable());
  }

  @Test
  public void testAvailabilityAfterBooking() {
    Room room = new Room(RoomType.SINGLE, 100);
    room.bookRoom(1);
    assertFalse(room.isAvailable());
  }
}