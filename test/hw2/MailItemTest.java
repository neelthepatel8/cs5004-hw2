package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * The type Mail item test.
 */
public class MailItemTest {

  /**
   * The Recipient.
   */
  Recipient recipient;
  /**
   * The Mail.
   */
  MailItem mail;
  /**
   * The Mail 2.
   */
  MailItem mail2;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    recipient = new Recipient("Neel", "Patel", "xxx@yyy.com");
    mail = new MailItem(2, 2, 2, recipient);
    mail2 = new MailItem(10, 100, 1000, recipient);
  }

  /**
   * Test good constructor.
   */
  @Test
  public void testGoodConstructor() {
    assertEquals(10, mail2.getWidth());
    assertEquals(100, mail2.getHeight());
    assertEquals(1000, mail2.getDepth());
    assertEquals(recipient, mail2.getRecipient());
  }

  /**
   * Test bad constructor dimensions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadConstructorDimensions() {
    new MailItem(0, 10, 10, recipient);
    new MailItem(0, 0, 10, recipient);
    new MailItem(0, 0, 0, recipient);
  }

  /**
   * Test bad constructor recipient.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadConstructorRecipient() {
    new MailItem(0, 10, 10, null);
  }
}