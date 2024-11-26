package DemergingUsingQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DemergingProcessor {
    private Queue<Person> female;
    private Queue<Person> male;

    public DemergingProcessor() {
        female = new LinkedList<>();
        male = new LinkedList<>();
    }

    public void process(List<Person> records) {
        for (Person p :records) {
            if (p.getGender().equalsIgnoreCase("female")) {
                female.add(p);
            } else if (p.getGender().equalsIgnoreCase("male")) {
                male.add(p);
            }
        }
    }

    public List<Person> getSortedData() {
        List<Person> sortedList = new ArrayList<>();

        while (!female.isEmpty()) {
            sortedList.add(female.poll());
        }
        while (!male.isEmpty()) {
            sortedList.add(male.poll());
        }
        return sortedList;
    }
}
