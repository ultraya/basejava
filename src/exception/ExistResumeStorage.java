package exception;

public class ExistResumeStorage extends StorageException {

    public ExistResumeStorage(String uuid, String message) {
        super(uuid, message);
    }
}
