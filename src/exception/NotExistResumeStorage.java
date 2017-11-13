package exception;

public class NotExistResumeStorage extends StorageException {

    public NotExistResumeStorage(String uuid, String message) {
        super(uuid, message);
    }
}
