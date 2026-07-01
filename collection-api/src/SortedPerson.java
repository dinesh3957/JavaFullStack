import java.util.Comparator;
import java.util.TreeSet;

public class SortedPerson {

	public static void main(String[] args) {
		Comparator<Person>ageComp=(p1,p2)->p1.getAge()-p2.getAge();
		Comparator<Person>nameComp=(p1,p2)->p1.getName().compareTo(p2.getName());
	TreeSet<Person>people=new TreeSet<Person>(nameComp);//Just chnge the ageComp for age sorting 
	people.add(new Person("polo",24));
	people.add(new Person("mona",31));
	people.add(new Person("jack",28));
	
	people.forEach(System.out::println);
	}

}
