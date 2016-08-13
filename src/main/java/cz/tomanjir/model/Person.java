package cz.tomanjir.model;

import com.google.common.base.MoreObjects;

public class Person {

    private final long id;

    private String name;

    Person(long id) {
        this(id, null);
    }

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    long getId() {
        return id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id == person.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }
}
