package storage;

import model.Resume;

public interface Storage {

    void clear();
    Resume get(String uuid);
    void save(Resume r);
    void delete(String uuid);
    void update(Resume r);
    Resume[] getAll();
    int size();
}
