import java.util.Arrays;


public class ArrayStorage {


    private int size = 0;
    private Resume[] storage = new Resume[10000];

    public void clear(){
        if(isEmpty()){
            return;
        }
        storage = new Resume[10000];
        size = 0;

    }

    public Resume get(String uuid){
        if(isEmpty()){
            return null;
        }

        int index = searchByUuid(uuid);

        if(index != -1){
            return storage[index];
        }else{
            System.out.println("Resume not found");
            return null;
        }


    }

    public void save(Resume r) {

        if(r == null){
            System.out.println("Resume == null");
            return;
        }
        if(size == 10000){
            System.out.println("Storage is full");
            return;
        }

        Resume resume = get(r.getUuid());
        if(resume != null){
            System.out.println("Resume exist");
            return;
        }
        storage[size++] = r;
    }

    public void delete(String uuid){
        if(isEmpty()){
            return;
        }
        int index = searchByUuid(uuid);
        if(index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            System.out.println("Resume deleted");
            return;
        }else {
            System.out.println("Resume with uuid = " + uuid + " not found");
        }

    }

    public void update(Resume r){
        Resume resume = get(r.getUuid());
        if(resume == null){
            System.out.println("Resume not exist");
            return;
        }
        delete(resume.getUuid());
        save(r);
    }

    public Resume[] getAll() {

        Resume[] result = new Resume[size];
        System.arraycopy(storage, 0, result, 0, size);
        return result;
    }

    public int size() {
        return size;
    }

    private int searchByUuid(String uuid) {
        for(int i = 0; i < size; i++){
            String uuidCurrent = storage[i].getUuid();
            if(uuidCurrent.equals(uuid)){
                return i;
            }
        }
        return -1;
    }

    private boolean isEmpty(){
        if(size == 0){
            System.out.println("Storage is empty");
            return true;
        }
        return false;
    }

}
