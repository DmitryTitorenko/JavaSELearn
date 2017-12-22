package more;

/*
The type bound <T extends Comparable<T>> may be read as “for every type T
that can be compared to itself,” which corresponds more or less exactly to the
notion of mutual comparability.
 */
public class RecursiveBounds {
    public static void main(String[] args) {

        SubClassR1 subClassR1 = new SubClassR1();
        SubClassR1 subClassR11 = new SubClassR1();

        SubClassR2 subClassR2 = new SubClassR2();

        System.out.println(subClassR1.compareTo(subClassR11)); // correct -> can comparable
        //System.out.println(subClassR1.compareTo(subClassR2)); // correct -> can't comparable
    }
}

// Using a recursive type bound to express mutual comparability
class SuperR<T extends SuperR<T>> implements Comparable<T> {
    private int id;

    @Override
    public int compareTo(T o) {
        return Integer.compare(this.id, o.getId());
    }

    public int getId() {
        return this.id;
    }
}

class SubClassR1 extends SuperR<SubClassR1> {
}

class SubClassR2 extends SuperR<SubClassR2> {
}
