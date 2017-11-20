package more;

/**
 * Created by Dmitry Titorenko on 05.01.2016.
 */
public class CompositionVsAggregating {

    public static void main(String[] args) {
        PC gamepc = new PC();
        gamepc.setCpu(2130);
        System.out.println(gamepc.getCpu());

        Home home = new Home();
        home.table = new Table();
        home.setType(10);
        System.out.println(home.getTable());
    }
}

//Composition
class CPU {
    int model;

    public int getCPU() {
        return model;
    }

    public void setCPU(int model) {
        this.model = model;
    }
}

class PC {
    CPU cpu;

    PC() {
        cpu = new CPU();
    }

    public void setCpu(int model) {
        cpu.setCPU(model);
    }

    public int getCpu() {
        return cpu.getCPU();
    }
}

//Aggregation
class Table {
    int type;

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}

class Home {
    Table table;

    Home() {
    }

    public int getTable() {
        return table.getType();
    }

    public void setType(int type) {
        table.setType(type);
    }
}


