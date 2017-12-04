package storage;

import exception.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Test;

public class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow(){
        try {
            for (int i = 3; i < AbstractArrayStorage.MAX_CAPACITY; i++) {
                storage.save(new Resume("Name" + i));
            }
        }catch (StorageException e){
            Assert.fail();
        }
        storage.save(new Resume("Name"));

    }

}
