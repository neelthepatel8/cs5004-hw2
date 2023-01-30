package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * The type Locker test.
 */
public class LockerTest {

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
   * The Bad mail.
   */
  MailItem badMail;
  /**
   * The Locker.
   */
  Locker locker;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    recipient = new Recipient("Neel", "Patel",
            "xxx@yyy.com");
    mail = new MailItem(2, 2, 2, recipient);
    mail2 = new MailItem(2, 2, 2, recipient);
    badMail = new MailItem(11, 12, 2, recipient);
    locker = new Locker(10, 10, 10);
  }

  /**
   * Test good constructor.
   */
  @Test
  public void testGoodConstructor() {
    locker = new Locker(10, 10, 10);
    assertEquals(locker, locker);

    locker = new Locker(2, 1000, 173);
    assertEquals(locker, locker);

  }

  /**
   * Test bad constructor dimensions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadConstructorDimensions() {
    new Locker(0, 10, 10);
    new Locker(0, 0, 10);
    new Locker(0, 0, 0);
    new Locker(0, -10, 0);
  }

  /**
   * Test add one mail.
   */
  @Test
  public void testAddOneMail() {
    locker.addMail(mail);
    assertEquals(mail, locker.getMailItem());
  }

  /**
   * Test add multiple mails.
   */
  @Test
  public void testAddMultipleMails() {
    locker.addMail(mail);
    locker.addMail(mail2);
    assertEquals(mail, locker.getMailItem());
  }

  /**
   * Test add bad mail.
   */
  @Test
  public void testAddBadMail() {
    locker.addMail(badMail);
    assertEquals(null, locker.getMailItem());
  }

  /**
   * Test pickup mail.
   */
  @Test
  public void testPickupMail() {
    locker.addMail(mail);
    assertEquals(mail, locker.pickupMail(recipient));
  }

  /**
   * Test storage after pickup mail.
   */
  @Test
  public void testStorageAfterPickupMail() {
    locker.addMail(mail);
    locker.pickupMail(recipient);
    assertEquals(null, locker.getMailItem());
  }

  /**
   * Test pickup null mail.
   */
  @Test
  public void testPickupNullMail() {
    assertEquals(null, locker.pickupMail(recipient));
  }

  /**
   * Test pickup mail wrong recipient.
   */
  @Test
  public void testPickupMailWrongRecipient() {
    locker.addMail(mail);
    MailItem returned = locker.pickupMail(new Recipient("Not Neel",
            "Patel", "xyxy@xyxy.com"));
    assertEquals(null, returned);
  }
}