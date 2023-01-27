package hw2;

public class Locker {

  private final int maxWidth;
  private final int maxHeight;
  private final int maxDepth;
  private MailItem mailItem;

  public Locker(int maxWidth, int maxHeight, int maxDepth) {

    boolean badInput = maxWidth < 1 || maxHeight < 1 || maxDepth < 1;

    if (badInput) throw new IllegalArgumentException();

    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.mailItem = null;
  }

  public void addMail(MailItem mail) {

    if (this.mailItem != null) return;

    if (mail.getWidth() > this.maxWidth ||
        mail.getHeight() > this.maxHeight ||
        mail.getDepth() > this.maxDepth)
      return;

    this.mailItem = mail;
  }

  public MailItem pickupMail(Recipient recipient) {

    if (this.mailItem == null) return null;

    if (this.mailItem.getRecipient() != recipient) return null;

    MailItem mail = this.mailItem;
    this.mailItem = null;
    return mail;
  }
}
