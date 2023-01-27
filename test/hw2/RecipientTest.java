package hw2;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class RecipientTest {

  @Test(expected = IllegalArgumentException.class)
  public void testBadInput() {
    String first = "";
    String last = "";
    String email = "";
    new Recipient(first, last, email);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testBadInputNull() {
    String first = null;
    String last = null;
    String email = null;
    new Recipient(first, last, email);
  }
}