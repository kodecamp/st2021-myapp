package in.kodecamp.innerclasses;

/**
 * AnonymousClassExample
 */
public class AnonymousClassExample {

  static public void main(String args[]) {
    var i = 10;
    var name = "Sunil";
    // anonymous inner class
    Person p1 = () -> {
        return 100;
    };


    // lambda expression
    Person p2 = ()  -> { return 200; };

    // when there is only one method in the interface
    Comparable<Person> myComparable = (Person o) -> {
			return 0;
		};

    doSomething(myComparable);

    Z1 z = (int x, int y) -> x + y;

    compute(z ,10, 20); // 30

    z = (int x, int y) -> x * y;

    compute(z ,10, 20); //

    z = (int x, int y) ->  x / y ;

    compute(z ,10, 20); //

    X x = () -> Math.random();



  }

  // 1. What are functional interfaces => only one method
  // How many types of functional interfaces
  static void doSomething(Comparable<Person> comprable) {

  }

  static void compute(Z1 z, int x, int y) {
    int result = z.id(x,y);
    System.out.println(result);
  }

  static void generator(X z) {
    double result = z.id();
    System.out.println(result);
  }


}

interface Person {
  // generator or supplier
  int id();
}

interface X {
  // takes nothing but returns some value => generator
  double id();
}

interface Y {

  // takes an integer but returns nothing => consumer
  void id(int x);
}

interface Z {
  // takes integer and returns integer => mapper
  int id(int x);
}

interface Z1 {
  // takes integer and returns integer => reducer
  int id(int x ,int y);
}




class PersonImpl implements Person {

	@Override
	public int id() {
		// TODO Auto-generated method stub
		return 0;
	}

}


