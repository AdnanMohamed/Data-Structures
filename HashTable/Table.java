/* This file contains a Table data structure.
   The items of the table are of the generic type
   T. The type's hashCode() is used as the key for each
   item. So it is used to remove any item from the table when
   the key is required.
 */

import java.util.ArrayList;
import java.util.List;

public class Table<T> {

    private static int TABLE_SIZE = 811;

    /** Creates an empty table. */
    public Table() {
        data = new List[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; ++i) {
            data[i] = new ArrayList<>();
        }
    }

    /** Inserts the entry to the table. */
    public void insert(T entry) {
        int h = hash(entry.hashCode());  // gets the hash of this entry.
        data[h].add(entry);
        total_records++;
    }

    /** Returns true if there is an item in the
     *  table with the specified key and it is removed,
     *  otherwise false is returned.
     */
    public Boolean remove(int key) {
        int hash = hash(key);
        List<T> lst = data[hash];
        for (int i = 0; i < lst.size(); ++i) {
            if (lst.get(i).hashCode() == key) {
                lst.remove(i);
                total_records--;
                return true;
            }
        }
        return false;
    }

    /** Returns true if and only if there is
     *  an item in the table with the specified
     *  key. */
    public Boolean is_present(int key) {
        int hash = hash(key);
        List<T> lst = data[hash];
        for (int i = 0; i < lst.size(); ++i) {
            if (lst.get(i).hashCode() == key) {
                return true;
            }
        }
        return false;
    }

    /** Returns the number of records in the table. */
    int size() { return total_records; }


    private List<T>[] data;    // an array of List containing the data.
    private int total_records; // holds the number of records.
 
    // HELPER MEMBER FUNCTION
    private int hash(int key) {
        return key % TABLE_SIZE;
    }

}
