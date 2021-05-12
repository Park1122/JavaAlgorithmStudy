package study.datastructure;

import java.util.HashMap;

public class MyHashLinearProbing {
    public Slot[] hashTable;

    public MyHashLinearProbing(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currentAddress = address + 1;
                while (this.hashTable[currentAddress] != null) {
                    if (this.hashTable[currentAddress].key == key) {
                        this.hashTable[currentAddress].value = value;
                        return true;
                    } else {
                        currentAddress++;
                        if (currentAddress >= this.hashTable.length) { // 주소가 커지다가 배열보다 커지는 경우
                            return false;
                        }
                    }
                }
                this.hashTable[currentAddress] = new Slot(key, value); // 인덱스 하나씩 추가하다가 비어있는 자리를 만난 경우, 슬롯 추가
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Integer currentAddress = address + 1;
                while (this.hashTable[currentAddress] != null) {
                    if (this.hashTable[currentAddress].key == key) {
                        return this.hashTable[currentAddress].value;
                    } else {
                        currentAddress++;
                        if (currentAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHashLinearProbing table = new MyHashLinearProbing(20);
        table.saveData("Park", "01011112222");
        table.saveData("Lee", "01022223333");
        table.saveData("ParkJ", "01033334444");
        table.saveData("ParkT", "01044445555");

        System.out.println(table.getData("Park"));
        System.out.println(table.getData("ParkJ"));
        System.out.println(table.getData("ParkT"));

        System.out.println("================================");

        // Java 에서는 HashMap 등을 이용하여 사용함.
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "사과");
        map.put(2, "바나나");
        map.put(3, "포도");

        System.out.println(map.get(2));
    }
}
