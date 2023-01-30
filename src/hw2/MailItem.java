package hw2;

/**
 * The type Mail item.
 */
public class MailItem {

  private final int width;
  private final int height;
  private final int depth;
  private final Recipient recipient;

  /**
   * Instantiates a new Mail item.
   *
   * @param width     the width
   * @param height    the height
   * @param depth     the depth
   * @param recipient the recipient
   */
  public MailItem(int width, int height, int depth, Recipient recipient) {

    boolean badInput = width < 1 || height < 1 || depth < 1 || recipient == null;

    if (badInput) throw new IllegalArgumentException();

    this.width = width;
    this.height = height;
    this.depth = depth;
    this.recipient = recipient;
  }

  /**
   * Gets recipient.
   *
   * @return the recipient
   */
  public Recipient getRecipient() {
    return recipient;
  }

  /**
   * Gets width.
   *
   * @return the width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Gets height.
   *
   * @return the height
   */
  public int getHeight() {
    return height;
  }

  /**
   * Gets depth.
   *
   * @return the depth
   */
  public int getDepth() {
    return depth;
  }
}
