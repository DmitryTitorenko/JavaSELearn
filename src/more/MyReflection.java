package more;

import java.lang.reflect.*;

public class MyReflection {
    public static void main(String[] args) {
        getAndSetPrivateField();
    }

    private static void getAndSetPrivateField() {
        try {
            CPU cpu = new CPU();
            cpu.setCPU(2130);
            Class aClass = cpu.getClass();
            //the class object representing CPU
            Field field = aClass.getDeclaredField("model");
            //the name field of the CPU class
            System.out.println(field);

            field.setAccessible(true);
            //override Java access control
            Object o = field.get(cpu);
            //the value of the model field
            System.out.println(o);

            field.set(cpu, 50);
            System.out.println(cpu.getCPU());

            //can't change final field
            Field field1 = aClass.getDeclaredField("id");
            field1.setAccessible(true);
            field1.set(cpu, 8);
            System.out.println(cpu.getId());

            System.out.println(cpu.getTestBoolean());
            // Can change final field

            // Change private modifier to public
            Field field2 = aClass.getDeclaredField("testBoolean");
            field2.setAccessible(true);

            // Remove final modifier
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field2, field2.getModifiers() & ~Modifier.FINAL);

            // set field value
            field2.set(cpu, true);
            System.out.println(field2.get(cpu));
            System.out.println(cpu.getTestBoolean());
        } catch (Exception e) {
        }
    }

    private static void createClass() {
        Class aClass;
        try {
            //1
            aClass = CPU.class;
            System.out.println(aClass);

            //2
            CPU cpu = new CPU();
            aClass = cpu.getClass();
            System.out.println(aClass);

            //3
            aClass = Class.forName("more.CPU");
            System.out.println(aClass);

            /*
            Create instance of the same class type as cpu
            The .newInstance() method calls the no-argument constructor to initialize the newly created object
             */
            CPU cpu1 = cpu.getClass().newInstance();

        } catch (Exception e) {
        }
    }
}
