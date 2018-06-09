package com.matthewyao.designpattern.Facade;

/**
 * Created by yaokuan on 2018/5/27.
 */
public class Computer {
    private CPU cpu;
    private Disk disk;
    private Memory memory;

    public Computer() {
        this.cpu = new CPU();
        this.disk = new Disk();
        this.memory = new Memory();
    }

    public void startComputer() {
        System.out.println("Starting computer...");
        cpu.startCPU();
        disk.startDisk();
        memory.startMemory();
        System.out.println("Computer is started");
    }

    public void shutdownComputer() {
        System.out.println("Shutdown computer...");
        cpu.shutdownCPU();
        disk.shutdownDisk();
        memory.shutdownMemory();
        System.out.println("Computer is shutdown");
    }
}
