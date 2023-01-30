package hw2;

/**
 * The type Mail item.
 */
public class MailItem {

  private final int width;
  private final int height;
  private final int depth;
  private final Recipient Recipient;

  /**
   * Instantiates a new Mail item.
   *
   * @param width     the width
   * @param height    the height
   * @param depth     the depth
   * @param Recipient the Recipient
   */
  public MailItem(int width, int height, int depth, Recipient Recipient) {

    boolean badInput = width < 1 || height < 1 || depth < 1 || Recipient == null;

    if (badInput) throw new IllegalArgumentException();

    this.width = width;
    this.height = height;
    this.depth = depth;
    this.Recipient = Recipient;
  }

  /**
   * Gets Recipient.
   *
   * @return the Recipient
   */
  public Recipient getRecipient() {
    return Recipient;
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
