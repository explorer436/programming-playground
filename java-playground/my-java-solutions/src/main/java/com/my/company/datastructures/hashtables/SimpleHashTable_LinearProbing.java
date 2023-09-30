package com.my.company.datastructures.hashtables;

/**
 * https://en.wikipedia.org/wiki/Hash_table
 *
 * <p>https://en.wikipedia.org/wiki/Linear_probing
 */
public class SimpleHashTable_LinearProbing {

  private StoredEmployee[] hashTable;

  public SimpleHashTable_LinearProbing() {
    hashTable = new StoredEmployee[10];
  }

  // hashing function
  private int hashKey(String key) {
    return key.length() % hashTable.length;
  }

  private boolean occupied(int index) {
    return hashTable[index] != null;
  }

  /** https://en.wikipedia.org/wiki/Linear_probing */
  public void put(String key, Employee employee) {
    int hashedKey = hashKey(key);

    if (occupied(hashedKey)) {
      // so that we will not keep looping aroung the array.
      int stopIndex = hashedKey;

      if (hashedKey == hashTable.length - 1) {
        hashedKey = 0;
      } else {
        hashedKey++;
      }

      while (occupied(hashedKey) && hashedKey != stopIndex) {
        hashedKey = (hashedKey + 1) % hashTable.length;
      }
    }

    if (occupied(hashedKey)) {
      System.out.println("Sorry, there is already an employee at position " + hashedKey);
    } else {
      hashTable[hashedKey] = new StoredEmployee(key, employee);
    }
  }

  /** https://en.wikipedia.org/wiki/Linear_probing */
  private int findKey(String key) {
    int hashedKey = hashKey(key);

    if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
      return hashedKey;
    }

    // so that we will not keep looping around the array.
    int stopIndex = hashedKey;

    if (hashedKey == hashTable.length - 1) {
      hashedKey = 0;
    } else {
      hashedKey++;
    }

    while (hashedKey != stopIndex
        && hashTable[hashedKey] != null
        && !hashTable[hashedKey].key.equals(key)) {
      hashedKey = (hashedKey + 1) % hashTable.length;
    }

    if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
      return hashedKey;
    } else {
      return -1;
    }
  }

  public Employee get(String key) {
    int hashedKey = findKey(key);

    if (hashedKey == -1) {
      return null;
    }

    return hashTable[hashedKey].employee;
  }

  public Employee remove(String key) {
    int hashedKey = findKey(key);

    if (hashedKey == -1) {
      return null;
    } else {
      Employee employee = hashTable[hashedKey].employee;
      hashTable[hashedKey] = null;

      StoredEmployee[] oldHashTable = hashTable;
      hashTable = new StoredEmployee[oldHashTable.length];

      for (int i = 0; i < oldHashTable.length; i++) {
        if (oldHashTable[i] != null) {
          put(oldHashTable[i].key, oldHashTable[i].employee);
        }
      }

      return employee;
    }
  }

  public void printHashTable() {
    for (int i = 0; i < hashTable.length; i++) {
      if (hashTable[i] == null) {
        System.out.println("empty");
      } else {
        System.out.println("Position " + i + ": " + hashTable[i].employee);
      }
    }
  }

  public class StoredEmployee {
    public String key;
    public Employee employee;

    public StoredEmployee(String key, Employee employee) {
      super();
      this.key = key;
      this.employee = employee;
    }
  }

  public class Employee {
    private String firstName;
    private String lastName;
    private int id;

    public Employee(String firstName, String lastName, int id) {
      super();
      this.firstName = firstName;
      this.lastName = lastName;
      this.id = id;
    }

    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + "]";
    }
  }
}
