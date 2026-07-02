package practice.facadeDesignPattern;

public class Facade {
    private OS os;
    private CPU cpu;
    private Memory memory;
    private HardDisk hardDisk;
    public Facade() {
        this.os = new OS();
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDisk = new HardDisk();
    }

    public void startSystem() {
        os.start();
        cpu.execute();
        memory.load();
        hardDisk.spin();
    }
}
