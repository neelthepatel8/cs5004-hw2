package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The type Recipient test.
 */
public class RecipientTest {

  /**
   * Test empty input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyInput() {
    String first = "";
    String last = "";
    String email = "";
    new Recipient(first, last, email);
  }

  /**
   * Test null input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullInput() {
    String first = null;
    String last = null;
    String email = null;
    new Recipient(first, last, email);
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    String first = "Neel";
    String last = "Patel";
    String email = "neel@patel.com";

    assertEquals("Neel Patel neel@patel.com", new Recipient(first, last, email).toString());
  }
}