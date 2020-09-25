package fife.ly.entity;


import javax.persistence.*;

@Entity
public class Shoes {
    private int id;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String name;

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private int size;

    @Column
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    private int version;

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", version=" + version +
                '}';
    }
}
