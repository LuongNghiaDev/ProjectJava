package Cautruc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class SetandMap {

    private static class Student{
        public int id;
        public String name;
        public Student(int id,String name){
            this.id=id;
            this.name=name;
        }

        @Override
        public int hashCode() {
            return (this.id +"-"+this.name).hashCode();
        }//ra hash giống nhau

        @Override
        public boolean equals(Object obj) {
            Student other = (Student) obj;
            return this.id==other.id && this.name.equals(other.name);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Set<Student> setMap = new HashSet<>();
        Student s1 = new Student(1,"nghia");
        Student s2 = new Student(3,"hien");
        Student s3 = new Student(1,"nghia");

        setMap.add(s1);
        setMap.add(s2);
        setMap.add(s3);

        for(Student j : setMap){
            System.out.println(j);
        }

        System.out.println("s1.equals(s3): "+s1.equals(s3));
        System.out.println("code s1: "+s1.hashCode());
        System.out.println("code s3: "+s3.hashCode());

    }
}
class SetandHashSet{
    public boolean contain(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int n : nums) {
            if (s.contains(n) == true) {
                return true;
            } else {
                s.add(n);
            }
        }
        return false;
    }
}
class MapandHashMap{
    public static void main(String[] args) {
        int[] ar = {1,2,3,1,1,2};
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i : ar){
            if(myMap.containsKey(i)==false){
                myMap.put(i,1);
            }else{
                int count=myMap.get(i);
                count++;
                myMap.put(i,count);
            }
        }

        for (Map.Entry entry : myMap.entrySet()){
            System.out.println(entry.getKey()+"xuát hiện: "+entry.getValue());
        }
    }
}
class testt{
    public int first(String s){
        Map<Character,Integer> myMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(myMap.containsKey(c)==false){
                myMap.put(c,1);
            }else{
                myMap.put(c,myMap.get(c)+1);
            }
        }
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(myMap.get(c)==1){
                return i;
            }
        }
        return -1;

    }

}
