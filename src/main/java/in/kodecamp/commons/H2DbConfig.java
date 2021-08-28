package in.kodecamp.commons;

public final class H2DbConfig extends DbConfig {

  public H2DbConfig() {
  }

  /**
   *
   */
  @Override
  public String url() {
    return System.getenv("DB_URL");
  }

  @Override
  public String username() {
    return System.getenv("DB_USERNAME");
  }

  @Override
  public String password() {
    return System.getenv("DB_PASSWORD");
  }

}
