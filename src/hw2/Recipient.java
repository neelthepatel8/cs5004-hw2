package hw2;

/**
 * The type Recipient.
 */
public class Recipient {

  private String firstName;
  private String lastName;
  private String email;

  /**
   * Instantiates a new Recipient.
   *
   * @param firstName the first name
   * @param lastName  the last name
   * @param email     the email
   */
  public Recipient(String firstName, String lastName, String email) {

    boolean nullInput = firstName == null || lastName == null || email == null;
    boolean badInput = isBadString(firstName)
            || isBadString(lastName)
            || isBadString(email);

    if (badInput || nullInput)
      throw new IllegalArgumentException();

    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  private boolean isBadString(String str) {
    return str.isEmpty() || str.isBlank();
  }

  @Override
  public String toString() {
    return String.format("%s %s Email:%s", this.firstName, this.lastName, this.email);
  }
}
