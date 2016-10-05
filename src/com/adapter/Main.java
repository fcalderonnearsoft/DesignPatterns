package com.adapter;

public class Main {
    public static void main(String[] args) {
        SocketAdapter sockAdapter = new SocketAdapterImp();
        Volt v3 = getVolt(sockAdapter,3);
        Volt v12 = getVolt(sockAdapter,12);
        Volt v120 = getVolt(sockAdapter,120);
        System.out.println("v3 volts usando la clase adaptador="+v3.getVolts());
        System.out.println("v12 volts usando la clase adaptado="+v12.getVolts());
        System.out.println("v120 volts usando la clase adaptado="+v120.getVolts());
    }

    private static Volt getVolt(SocketAdapter sockAdapter, int i) {
        switch (i){
            case 3: return sockAdapter.get3Volt();
            case 12: return sockAdapter.get12Volt();
            case 120: return sockAdapter.get120Volt();
            default: return sockAdapter.get120Volt();
        }
    }
}
