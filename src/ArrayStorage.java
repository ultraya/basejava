import java.util.Arrays;


public class ArrayStorage {


    private int size = 0;
    private Resume[] storage = new Resume[10000];

    public void clear(){
        if(size == 0){
            System.out.println("Storage is empty");
            return;
        }
        storage = new Resume[10000];
        size = 0;

    }

    public Resume get(String uuid) throws Exception {
        if(size == 0){
            return null;
        }
        for(int i = 0; i < size; i++){
            String uuidCurrent = storage[i].getUuid();
            if (uuidCurrent.equals(uuid)){
                return storage[i];
            }

        }
        return null;
    }

    public void save(Resume r) throws Exception {

        if(r == null){
            throw new Exception("Resume == null");
        }
        if(size == 10000){
            throw new Exception("Storage is full");
        }
        Resume resume = get(r.getUuid());
        if(resume != null){
            System.out.println("Resume exist");
            return;
        }
        storage[size++] = r;
    }

    public void delete(String uuid) throws Exception {
        if(size == 0){
            throw new Exception("Storage is empty");
        }
        for(int i = 0; i < size; i++){
            String uuidCurrent = storage[i].getUuid();
            if (uuidCurrent.equals(uuid)){
               storage[i] = storage[size - 1];
               storage[size - 1] = null;
                size--;
               System.out.println("Resume deleted");
               return;
            }

        }
        throw new Exception("Resume with uuid = "+ uuid + " not found");

    }

    public void update(Resume r) throws Exception{
        Resume resume = get(r.getUuid());
        if(resume == null){
            throw new Exception("Resume not exist");
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

}
