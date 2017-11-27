package storage;


import exception.ExistResumeStorage;
import exception.NotExistResumeStorage;
import exception.StorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {


    public Resume get(String uuid){
        Resume key = new Resume(uuid);
        int index = getIndex(key);
        if(index >= 0){

            return getElement(index, uuid);

        }else{
            throw new NotExistResumeStorage(uuid, "Resume notFound");
        }

    }

    public void save(Resume r){
        int index = getIndex(r);
        if(index >= 0){
            throw new ExistResumeStorage(r.getUuid(), "Resume already exist");
        }else{
            insertResume(r, index);
        }

    }


    public void delete(String uuid){
        Resume key = new Resume(uuid);
        int index = getIndex(key);
        if( index < 0){
            throw new NotExistResumeStorage(uuid, "Resume notFound");
        }else{
            deleteFromStorage(index, uuid);

        }
    }

    public void update(Resume r){
        int index = getIndex(r);
        if(index >= 0){
            updateResume(r, index);
        }else{
            throw new NotExistResumeStorage(r.getUuid(), "Resume notFound");
        }
    }

    public Resume[] getAll(){
        Resume[] result = new Resume[size()];
        return getResumeArray(result);
    }


    protected abstract int getIndex(Resume r);
    protected abstract void insertResume(Resume r, int index);
    protected abstract Resume getElement(int index, String uuid);
    protected abstract void deleteFromStorage(int index, String uuid);
    protected abstract void updateResume(Resume r, int index);
    protected abstract Resume[] getResumeArray(Resume[] result);
}
