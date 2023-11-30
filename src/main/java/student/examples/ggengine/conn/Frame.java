package student.examples.ggengine.conn;

import student.examples.ggengine.game.Item;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// should be immutable
public class Frame {
    private int id;
    private final Set<Item> items;

    public Frame(int id, Set<Item> items){
        this.id = id;
        this.items = new HashSet<>(items);
    }

    public Set<Item> getItems(){
        return Collections.unmodifiableSet(items);
    }

//    public Set<Item> addItem(Item item){
//        items.add(item);
//        return items;
//    }
}
