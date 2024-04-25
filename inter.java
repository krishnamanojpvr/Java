// public What Are Interfaces in Java?
// In Java, an interface is an abstract type that contains a collection of methods and constant variables. 
// It is used to achieve abstraction, polymorphism and multiple inheritances.
// It is also define as a public contract between a class and the user.


class Electronic {
protected boolean isOn; 
public Electronic() { this.isOn = false;}
public void powerOn() {
        if (!isOn) { isOn = true;
System.out.println("Electronic device is now on.");} 
else {   System.out.println("Electronic device is already on.");
        }
    }

    public void powerOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Electronic device is now off.");
        } else {
            System.out.println("Electronic device is already off.");
        }
    }
}


// class Computer extends Electronic {
//     // Additional state specific to computers
//     private String brand;
//     private int storage; // in gigabytes
//     private int ram; // in gigabytes

//     // Constructor to initialize the Computer object
//     public Computer(String brand, int storage, int ram) {
//         super(); // Call the superclass constructor
//         this.brand = brand;
//         this.storage = storage;
//         this.ram = ram;
//     }

//     // Specific behavior for Computer
//     public void upgradeRam(int additionalRam) {
//         this.ram += additionalRam;
//         System.out.println("RAM upgraded. Total RAM: " + ram + " GB.");
//     }

//     // Overriding the display method to include computer specifics
//     public void displaySpecs() {
//         System.out.println("Brand: " + brand);
//         System.out.println("Storage: " + storage + " GB");
//         System.out.println("RAM: " + ram + " GB");
//         System.out.println("Power status: " + (isOn ? "On" : "Off"));
//     }
// }

// Explanation of Methods:
// enableBluetooth(): This method will turn on the Bluetooth functionality of the device.
// disableBluetooth(): This method will turn off the Bluetooth functionality of the device.
// connectToDevice(String deviceName): Attempts to establish a Bluetooth connection with another device identified by deviceName. It returns a boolean indicating success or failure.
// disconnectDevice(): Terminates the Bluetooth connection with the currently connected device.
// sendData(byte[] data): Sends data to the connected device. The data is passed as an array of bytes.
// receiveData(): Returns data received from the connected device as an array of bytes.



interface BluetoothInterface {
    // Method to enable Bluetooth
    void enableBluetooth();

    // Method to disable Bluetooth
    void disableBluetooth();

    // Method to establish a connection with another device
    boolean connectToDevice(String deviceName);

    // Method to disconnect from a connected device
    void disconnectDevice();

    // Method to send data to the connected device
    void sendData(byte[] data);

    // Method to receive data from the connected device
    byte[] receiveData();
}
class Smartphone implements BluetoothInterface {
    private boolean bluetoothEnabled = false;

    @Override
    public void enableBluetooth() {
        bluetoothEnabled = true;
        System.out.println("Bluetooth enabled.");
    }

    @Override
    public void disableBluetooth() {
        bluetoothEnabled = false;
        System.out.println("Bluetooth disabled.");
    }

    @Override
    public boolean connectToDevice(String deviceName) {
        if (bluetoothEnabled) {
            System.out.println("Connecting to " + deviceName + "...");
            // Simulate a successful connection
            return true;
        } else {
            System.out.println("Please enable Bluetooth first.");
            return false;
        }
    }

    @Override
    public void disconnectDevice() {
        if (bluetoothEnabled) {
            System.out.println("Disconnecting from device...");
        } else {
            System.out.println("Bluetooth is not enabled. Cannot disconnect.");
        }
    }

    @Override
    public void sendData(byte[] data) {
        if (bluetoothEnabled) {
            System.out.println("Sending data: " + new String(data));
        } else {
            System.out.println("Bluetooth is not enabled. Cannot send data.");
        }
    }

    @Override
    public byte[] receiveData() {
        if (bluetoothEnabled) {
            System.out.println("Receiving data...");
            // Simulate receiving data
            return "Received data".getBytes();
        } else {
            System.out.println("Bluetooth is not enabled. Cannot receive data.");
            return new byte[0];
        }
    }
}


class Computer extends Electronic implements BluetoothInterface {
    // State specific to computers
    private String brand;
    private int storage; // in gigabytes
    private int ram; // in gigabytes
    private boolean bluetoothEnabled = false;

    // Constructor to initialize the Computer object
    public Computer(String brand, int storage, int ram) {
        super(); // Call the superclass constructor
        this.brand = brand;
        this.storage = storage;
        this.ram = ram;
    }

    // Implementing BluetoothInterface methods

    @Override
    public void enableBluetooth() {
        bluetoothEnabled = true;
        System.out.println("Bluetooth enabled.");
    }

    @Override
    public void disableBluetooth() {
        bluetoothEnabled = false;
        System.out.println("Bluetooth disabled.");
    }

    @Override
    public boolean connectToDevice(String deviceName) {
        if (bluetoothEnabled) {
            System.out.println("Connecting to " + deviceName + "...");
            // Simulate a successful connection
            return true;
        } else {
            System.out.println("Please enable Bluetooth first.");
            return false;
        }
    }

    @Override
    public void disconnectDevice() {
        if (bluetoothEnabled) {
            System.out.println("Disconnecting from device...");
        } else {
            System.out.println("Bluetooth is not enabled. Cannot disconnect.");
        }
    }

    @Override
    public void sendData(byte[] data) {
        if (bluetoothEnabled) {
            System.out.println("Sending data: " + new String(data));
        } else {
            System.out.println("Bluetooth is not enabled. Cannot send data.");
        }
    }

    @Override
    public byte[] receiveData() {
        if (bluetoothEnabled) {
        System.out.println("Receiving data...");
        // Simulate receiving data
        return "Received data".getBytes();
        } else {
            System.out.println("Bluetooth is not enabled. Cannot receive data.");
            return new byte[0];
        }
    }

    // Specific behavior for Computer
    public void upgradeRam(int additionalRam) {
        this.ram += additionalRam;
        System.out.println("RAM upgraded. Total RAM: " + ram + " GB.");
    }

    // Overriding the display method to include computer specifics
    public void displaySpecs() {
        System.out.println("Brand: " + brand);
        System.out.println("Storage: " + storage + " GB");
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Power status: " + (isOn ? "On" : "Off"));
        System.out.println("Bluetooth status: " + (bluetoothEnabled ? "Enabled" : "Disabled"));
    }
}

// Rules for creating an Interface
// In an interface, we’re allowed to use:
// constants variables
// abstract methods
// static methods
// default methods
// We also should remember that:
// we can’t instantiate interfaces directly
// an interface can be empty, with no methods or variables in it
// we can’t use the final word in the interface definition, as it will result in a compiler error
// all interface declarations should have the public or default access modifier; the abstract modifier will be added automatically by the compiler
// an interface method can’t be protected or final
// up until Java 9, interface methods could not be private; however, Java 9 introduced the possibility to define private methods in interfaces
// interface variables are public, static, and final by definition; we’re not allowed to change their visibility inter {
    
// }
