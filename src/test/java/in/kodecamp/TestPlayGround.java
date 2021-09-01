package in.kodecamp;

import static in.kodecamp.commons.Logger.log;

import in.kodecamp.entities.Person;
import in.kodecamp.entities.PersonImpl;/**
 * Unit test for simple App.
 */
public class TestPlayGround {


    public void testPerson() {
        log("start: TestPlayGround : ", "testPerson");

        // person object
        Person p = fetchPersonFromService("uu100");

        String uuid = p.uuid();
        log("uuid", uuid);
        String name = p.name();
        String address = p.address();

        assert uuid.equals("uu100"): "Actual uuid does not match to expected uuid";
        assert name.equals("Golu"): "Actual name does not match to expected name";
        assert address.equals("Kanpur"): "Actual address does not match to expected address";

        log("end  : TestPlayGround : ", "testPerson");
    }

    private Person fetchPersonFromService(String uuid) {
        Person p = new PersonImpl(uuid, "Golu", "Kanpur");
        return p;
    }

    public void testStudent() {

    }

    public void testCollege() {
        // CollegeImpl is a College
        // College college = new CollegeImpl();
    }

    public void testStatic() {
    }



}
