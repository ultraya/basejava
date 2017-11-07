package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int MAX_CAPACITY = 10000;
    protected int size = 0;
    protected Resume[] storage = new Resume[MAX_CAPACITY];

    public void save(Resume r) {

        if(r == null){
            System.out.println("Resume == null");
            return;
        }

        int index = getIndex(r.getUuid());

        if(index >= 0){

            System.out.println("Resume already exist");

        }else if(size == MAX_CAPACITY){

            System.out.println("Storage is overflow");
        }else {
            insertResume(r, index);
            size++;
        }
    }

    public void update(Resume r) {
        if(r == null){
            return;
        }
        int index = getIndex(r.getUuid());
        if(index >= 0){
            storage[index] = r;
        }else{
            System.out.println("Resume not found for update");
        }
    }

    public void delete(String uuid) {
        if(uuid == null){
            return;
        }
        if(isEmpty()){
            System.out.println("Storage is empty");
            return;
        }
        int index = getIndex(uuid);
        if( index < 0){
            System.out.println("Resume not found in the storage");
        }else{
            deleteAndReplace(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public void clear(){
        if(isEmpty()){
            return;
        }
        Arrays.fill(storage, 0, size, null);
        size = 0;

    }

    public int size() {
        return size;
    }

    public Resume get(String uuid){
        if(isEmpty()){
            return null;
        }

        int index = getIndex(uuid);

        if(index != -1){
            return storage[index];
        }else{
            System.out.println("Resume not found");
            return null;
        }


    }

    public Resume[] getAll() {

        Resume[] result = new Resume[size];
        System.arraycopy(storage, 0, result, 0, size);
        return result;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void deleteAndReplace(int index);

    protected abstract void insertResume(Resume resume, int index);

    protected boolean isEmpty(){
        if(size == 0){
            System.out.println("Storage is empty");
            return true;
        }
        return false;
    }
}
