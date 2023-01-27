package hw2;

public class Recipient {

  private final String firstName;
  private final String lastName;
  private final String email;

  public Recipient(String firstName, String lastName, String email) {

    boolean badInput = isBadString(firstName)
                    || isBadString(lastName)
                    || isBadString(email);

    if (badInput)
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
    return String.format("%s %s Email: %s", this.firstName, this.lastName, this.email);
  }
}
