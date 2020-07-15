package lut.day25;

public class BuilderTest {
    public static void main(String[] args) {
        Computer lenoveComputer = null;
        computerBuilder lenoveComputerBuilder = new LenvonComputerBuilder();
        Director director = new Director(lenoveComputerBuilder);
        director.construct();
        lenoveComputer = lenoveComputerBuilder.buileComputer();
        System.out.println(lenoveComputer);
    }
}

//CPU种类
interface CPU<T>{
    T cpu();
}
class interCPU implements  CPU<String>{
    @Override
    public String cpu() {
        return "Interner CPU";
    }
}
class AMDCPU implements CPU<String>{
    @Override
    public String cpu() {
        return null;
    }
}
interface Memory<T>{
    T memory();
}
//金士顿内存
class KingstonMemory implements Memory<String>{
    @Override
    public String memory() {
        return "金士顿内存";
    }
}
//三星内存
class SamsungMemory implements Memory<String>{
    @Override
    public String memory() {
        return null;
    }
}

//主板内存
 interface Mainboard <T>{
    T mainboard();
}
//华硕主板
class AsusMainboard implements Mainboard<String>{
    @Override
    public String mainboard() {
        return "华硕主板";
    }
}
//技嘉主板
class GaMainboard implements Mainboard{
    @Override
    public Object mainboard() {
        return null;
    }
}
class Computer{
    private CPU<String> cpu;
    private Memory<String> memory;
    private Mainboard<String> mainboard;

    public CPU<String> getCpu() {
        return cpu;
    }

    public void setCpu(CPU<String> cpu) {
        this.cpu = cpu;
    }

    public Memory<String> getMemory() {
        return memory;
    }

    public void setMemory(Memory<String> memory) {
        this.memory = memory;
    }

    public Mainboard<String> getMainboard() {
        return mainboard;
    }

    public void setMainboard(Mainboard<String> mainboard) {
        this.mainboard = mainboard;
    }
}
interface computerBuilder{
    void builderCPU();
    void buildMemory();
    void buildMainboard();
    Computer buileComputer();
}
//组装电脑
class LenvonComputerBuilder implements computerBuilder{
    Computer computer;

    public LenvonComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void builderCPU() {
        interCPU interCPU = new interCPU();
        computer.setCpu(interCPU);
        System.out.println(interCPU.cpu());
    }

    @Override
    public void buildMemory() {
        KingstonMemory kingstonMemory = new KingstonMemory();
        computer.setMemory(kingstonMemory);
        System.out.println(kingstonMemory.memory());
    }

    @Override
    public void buildMainboard() {
        AsusMainboard asusMainboard = new AsusMainboard();
        computer.setMainboard(asusMainboard);
        System.out.println(asusMainboard.mainboard());
    }

    @Override
    public Computer buileComputer() {
        return computer;
    }
}
//Director类(导演)
//指导如何具体的创造电脑
class Director {
    private computerBuilder builder;
    public Director(computerBuilder builder) {
        this.builder = builder;
    }
    //用户自定义的自造顺序
    // 具体指导各种builder如何创建电脑，，创建何种电脑
    public void construct() {
        builder.builderCPU();
        builder.buildMemory();
        builder.buildMainboard();
    }
}