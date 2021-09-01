package in.kodecamp.entities;

/**
 * PersonImpl
 */
public class PersonImpl implements Person {

  private String uuid;
  private String name;
  private String address;
  /**
   *
   */
  public PersonImpl(String uuid, String name, String address) {
    this.uuid = uuid;
    this.name = name;
    this.address = address;
  }


  @Override
  public String address() {
    return this.address;
  }

  @Override
  public String changeAddress(String newAddress) {
    this.address = newAddress;
    return this.address;
  }

  @Override
  public String name() {
    return this.name;
  }

  @Override
  public String uuid() {
    return this.uuid;
  }


}
