package bookLibrary.model;

public class Person {
    private String fullName;
    private boolean isTeacher;
    private boolean isJuniorStudent;
    private boolean isSeniorStudent;

    public Person(String fullName, boolean isTeacher, boolean isJuniorStudent, boolean isSeniorStudent) {
        this.fullName = fullName;
        this.isTeacher = isTeacher;
        this.isJuniorStudent = isJuniorStudent;
        this.isSeniorStudent = isSeniorStudent;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public boolean isJuniorStudent() {
        return isJuniorStudent;
    }

    public void setJuniorStudent(boolean juniorStudent) {
        isJuniorStudent = juniorStudent;
    }

    public boolean isSeniorStudent() {
        return isSeniorStudent;
    }

    public void setSeniorStudent(boolean seniorStudent) {
        isSeniorStudent = seniorStudent;
    }

    @Override
    public String toString(){
        return fullName;
    }
}
