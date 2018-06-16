package paging.android.example.com.pagingsample;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Cheese2 extends RealmObject {
    @PrimaryKey
    String id;

    String name;

    public Cheese2() {
    }

    public Cheese2(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
