package dk.easv;

import java.util.LinkedList;
import java.util.Queue;

public class ObjectPool {
    private static ObjectPool instance;
    private Queue<SlowObject> reusables = new LinkedList<>();

    private ObjectPool(){

    }

    public static ObjectPool getInstance() {
        return instance == null ? instance = new ObjectPool() : instance;
    }

    public SlowObject acquireReusable() {
        if(reusables.peek() == null){
            reusables.add(new SlowObject());
        }
        return reusables.poll();
    }

    public void releaseReusable(SlowObject connection){
        reusables.add(connection);
    }
}
