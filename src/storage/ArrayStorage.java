package storage;

import model.Resume;

import java.util.Arrays;


public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deleteAndReplace(int index) {
        storage[index] = storage[size - 1];
    }


    @Override
    protected void insertResume(Resume resume, int index) {
        storage[size] = resume;
    }

    protected int getIndex(String uuid) {
        for(int i = 0; i < size; i++){
            String uuidCurrent = storage[i].getUuid();
            if(uuidCurrent.equals(uuid)){
                return i;
            }
        }
        return -1;
    }



}
