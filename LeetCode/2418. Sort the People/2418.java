class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // Pair the names and heights together in an array of pairs
        int n = names.length;
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(names[i], heights[i]);
        }

        // Sort the array of pairs based on height in descending order
        Arrays.sort(people, (a, b) -> b.height - a.height);

        // Extract the names from the sorted array
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people[i].name;
        }

        return sortedNames;
    }

    // Helper class to store name and height together
    static class Person {
        String name;
        int height;

        Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}