package model;

import com.sun.istack.internal.NotNull;

import java.util.UUID;

public class Resume implements Comparable<Resume> {


    private final String uuid;
    private final String fullName;

    public Resume(@NotNull final String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(@NotNull final String uuid,@NotNull final String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }


    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(o.getUuid());

    }
}
