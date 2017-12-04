package storage;

import model.Resume;

import java.util.List;

public interface Storage {

    void clear();
    Resume get(String uuid);
    void save(Resume r);
    void delete(String uuid);
    void update(Resume r);
    List<Resume> getAllSorted();
    int size();
}
