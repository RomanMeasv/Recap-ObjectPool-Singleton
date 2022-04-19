package dk.easv;

public class Main {

    public static void main(String[] args) {
        try {
            ObjectPool pool = ObjectPool.getInstance();

            SlowObject o1 = pool.acquireReusable();
            SlowObject o2 = pool.acquireReusable();
            SlowObject o3 = pool.acquireReusable();

            System.out.println(o1.toString());
            System.out.println(o2.toString());
            System.out.println(o3.toString());

            pool.releaseReusable(o1);
            pool.releaseReusable(o2);
            pool.releaseReusable(o3);

            Thread.sleep(500);

            SlowObject o = pool.acquireReusable();

            System.out.println(o.toString());

        } catch (Exception e){

        }
    }
}
