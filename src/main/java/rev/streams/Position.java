package rev.streams;

/** Position enumeration with level */
public enum Position {
  INTERN(1),
  JUNIOR(2),
  SENIOR(3),
  LEAD(4),
  MANAGER(5),
  DIRECTOR(6),
  VP(7),
  C_LEVEL(8);

  private final int level;

  Position(int level) {
    this.level = level;
  }

  public int level() {
    return level;
  }

  public boolean isLeadership() {
    return level >= 4;
  }
}
