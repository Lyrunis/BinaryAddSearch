package sortedList;

import java.util.ArrayList;

public class SortedList {
    private final ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String item) {
        int index = findInsertPosition(item);
        list.add(index, item);
    }

    public int findInsertPosition(String item) { // Binary Search Alg Implementation for insertion
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = list.get(mid).compareTo(item);

            if (comparison == 0) {
                return mid; // Exact match found
            } else if (comparison < 0) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return low; // Best insert position
    }

    public int search(String item) { // Binary Search Alg Implementation for index return
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = list.get(mid).compareTo(item);

            if (comparison == 0) {
                return mid; // Element found
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -low - 1; // Return negative index if not found
    }

    public ArrayList<String> getList() {
        return new ArrayList<>(list); // Return a copy
    }
}
