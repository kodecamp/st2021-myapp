package in.kodecamp.entities;


// Every teachingstaff is a person
public interface TeachingStaff extends Person {

  public String specialization();
  public double salary();
  public String designation();

}
