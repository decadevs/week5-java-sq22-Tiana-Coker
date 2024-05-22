package bookLibrary.model;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if(p1.isTeacher() && !p2.isTeacher()){
            return -1;
        } else if (!p1.isTeacher() && p2.isTeacher()){
            return 1;
        }else if (p1.isSeniorStudent() && !p2.isSeniorStudent()){
            return -1;
        }else if (!p1.isSeniorStudent() && p2.isSeniorStudent()){
            return 1;
        }else if (p1.isJuniorStudent() && !p2.isJuniorStudent()){
            return -1;
        }else if (!p1.isJuniorStudent() && p2.isJuniorStudent()){
            return 1;
        } else
            return 0;
    }

}
