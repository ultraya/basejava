package storage;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapStorageTest extends AbstractStorageTest{

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Test
    @Override
    public void saveOverflow() {
        super.saveOverflow();
    }
}