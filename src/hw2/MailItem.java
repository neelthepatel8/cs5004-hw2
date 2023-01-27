package hw2;

public class MailItem {

  private final int width;
  private final int height;
  private final int depth;
  private final Recipient recipient;

  public MailItem(int width, int height, int depth, Recipient recipient) {

    boolean badInput = width < 1 || height < 1 || depth < 1 || recipient == null;

    if (badInput) throw new IllegalArgumentException();

    this.width = width;
    this.height = height;
    this.depth = depth;
    this.recipient = recipient;
  }

  public Recipient getRecipient() {
    return recipient;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getDepth() {
    return depth;
  }
}
