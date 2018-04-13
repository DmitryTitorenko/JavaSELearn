package more.object;

import java.util.Arrays;

/**
 * @author Dmitry Titorenko on 19.03.2018
 */
public class CloneRun {
    public static void main(String[] args) throws CloneNotSupportedException {
        CPU cpu = new CPU(1, "2130", new int[]{5, 8});
        System.out.println(cpu);
        CPU cpu1 = cpu.clone();
        System.out.println(cpu1);
    }
}

class CPU implements Cloneable {// if we didn't implement - throw CloneNotSupportedException
    private int id;
    private String model;
    private int array[];

    CPU(int id, String model, int array[]) {
        this.id = id;
        this.model = model;
        this.array = array;
    }

    @Override
    public String toString() {
        return "id: " + id + " model: " + model + "array: " + Arrays.toString(array);
    }

    @Override
    public CPU clone() throws CloneNotSupportedException {
        CPU cpu = (CPU) super.clone();
        cpu.array.clone();
        return cpu;
    }
}
