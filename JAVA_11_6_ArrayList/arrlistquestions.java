import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;

public class arrlistquestions {
    // user class
    static class user {
        String name;
        int age;

        user(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        // Java Collection : ArrayList - Exercises

        // 1. Write a Java program to create a new array list, add some elements
        // (string) and print out the collection
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("Red");
        list1.add("Green");
        list1.add("Blue");
        list1.add("Yellow");
        list1.add("Orange");
        list1.add("Purple");
        list1.add("Black");
        System.out.println(list1);

        // 2. Write a Java program to insert an element into the array list at the first
        // position
        list1.add(0, "White");

        // 3. Write a Java program to remove the fifth element from a array list
        list1.remove(4);

        // 4. Write a Java program to sort a given array list
        Collections.sort(list1);

        // 5. Write a Java program to shuffle elements in a array list
        Collections.shuffle(list1);

        // 6. Write a Java program to increase the size of an array list
        list1.ensureCapacity(10);

        // 7. Write a Java program to reverse elements in a array list
        Collections.reverse(list1);

        // 8. Write a Java program to compare two array lists
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Red");
        list2.add("Green");
        list2.add("Blue");
        list2.add("Yellow");
        list2.add("Orange");
        list2.add("Purple");
        list2.add("Black");
        System.out.println(list1.equals(list2));

        // 9. Write a Java program to swap two elements in an array list
        Collections.swap(list1, 0, 1);
        System.out.println(list1);

        // 10. Write a Java program to join two array lists
        ArrayList<String> list3 = new ArrayList<String>();
        list3.addAll(list1);
        list3.addAll(list2);

        // 11. Write a Java program to empty an array list
        list1.clear();

        // 12. Write a Java program to retrieve an element (at a specified index) from a
        // given array list
        System.out.println(list2.get(2));

        // 13. Write a Java program to update specific array element by given element
        list2.set(2, "Pink");

        // 14. Write a Java program to search an element in a array list
        System.out.println(list2.contains("Pink"));

        // 15. Write a Java program to copy one array list into another
        ArrayList<String> list4 = new ArrayList<String>();
        list4.addAll(list2);
        System.out.println(list4);

        // 16. Write a Java program to extract a portion of a array list
        System.out.println(list4.subList(2, 5));

        // 17. Write a Java program to clone an array list to another array list
        // ArrayList<String> list5 = (ArrayList<String>) list4.clone(); list4.clone() is
        // not present
        ArrayList<String> list5 = new ArrayList<String>(list4);
        System.out.println(list5);

        // 18. Write a Java program to test an array list is empty or not
        System.out.println(list4.isEmpty());

        // 19. Write a Java program to trim the capacity of an array list the current
        // list size
        list4.trimToSize();
        System.out.println(list4);

        // 20. Write a Java program to print all the elements of a Array List using the
        // position of the elements
        for (int i = 0; i < list4.size(); i++) {
            System.out.println(list4.get(i));
        }

        // 21. Write a Java program to Find maximum element in ArrayList
        System.out.println(Collections.max(list4));

        // 22. Write a Java program to Find minimum element in ArrayList
        System.out.println(Collections.min(list4));

        // 23. Write a Java program to ArrayList of user defined objects
        ArrayList<user> list6 = new ArrayList<user>();
        list6.add(new user("John",
                25));
        list6.add(new user("Jane",
                22));
        list6.add(new user("Jack",
                30));

        // 24. Write a Java program to Searching for elements in an ArrayList
        for (user u : list6) {
            if (u.name.equals("John")) {
                System.out.println("Found");
            }
        }

        // 25. Write a Java program how do you find the number of elements present in an
        // ArrayList
        System.out.println(list6.size());

        // 26. Write a Java program how do you decrease the current capacity of an
        // ArrayList to the current size
        list6.trimToSize();

        // 27. Write a Java program how to Convert a ArrayList to HashSet
        ArrayList<String> list7 = new ArrayList<String>();
        list7.add("Red");
        list7.add("Green");
        list7.add("Blue");
        list7.add("Yellow");
        list7.add("Orange");
        list7.add("Purple");
        list7.add("Black");
        System.out.println(list7);
        System.out.println(new ArrayList<String>(list7).hashCode());
        HashSet<String> set = new HashSet<String>(list7);
        System.out.println(set);
        System.out.println(set.hashCode());

        // 28. Write a Java Program to find number of elements in ArrayList
        System.out.println(list7.size());

        // 29. Write a Java program to get SubList from ArrayList
        System.out.println(list7.subList(2, 5));

        // 30. Write a Java program to Remove Duplicates from ArrayList

        ArrayList<String> list8 = new ArrayList<String>();
        list8.add("Red");
        list8.add("Green");
        list8.add("Blue");
        list8.add("Yellow");
        list8.add("Orange");
        list8.add("Purple");
        list8.add("Black");
        list8.add("Red");
        list8.add("Green");
        list8.add("Blue");
        list8.add("Yellow");
        list8.add("Orange");
        list8.add("Purple");
        list8.add("Black");
        System.out.println(list8);
        HashSet<String> set2 = new HashSet<String>(list8);
        list8.clear();
        list8.addAll(set2);
        System.out.println(list8);

        // 31. Write a Java program to Convert an ArrayList to Array
        String[] array = list7.toArray(new String[0]);
        for (String s : array) {
            System.out.println(s);
        }

        // 32. Write a Java program to insert an element at a particular position of an
        // ArrayList
        list7.add(2, "White");

        // 33. Write a Java program to Remove an element from a particular position of
        // an ArrayList
        list7.remove(2);

        // 34. Write a Java program to Remove the given element from an ArrayList
        list7.remove("White");

        // 35. Write a Java program to Remove all elements of an ArrayList at a time
        list7.clear();

        // 36. Write a Java program to Insert more than one element at a particular
        // position of an ArrayList
        list7.add(0, "White");
        list7.add(1, "Black");
        list7.add(2, "Red");
        list7.add(3, "Green");
        list7.add(4, "Blue");
        list7.add(5, "Yellow");
        list7.add(6, "Orange");
        list7.add(7, "Purple");
        System.out.println(list7);
        ArrayList<String> list9 = new ArrayList<String>();
        list9.add("Pink");
        list9.add("Brown");
        list7.addAll(2, list9);
        System.out.println(list7);

        // 37. Write a Java program to Retrieve a portion of an ArrayList
        System.out.println(list7.subList(2, 5));

        // 38. Write a Java program to Replace a particular element in an ArrayList with
        // the given element
        list7.set(2, "Pink");

        // 39. Write a Java program to get the position of a particular element in an
        // ArrayList
        System.out.println(list7.indexOf("Pink"));

        // 40. Write a Java program to check whether the given element is present in an
        // ArrayList or not
        System.out.println(list7.contains("Pink"));

    }
}