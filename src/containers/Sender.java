package containers;

import exceptions.IrresponsibleSenderWithDangerousGoods;

public class Sender{
    private String name;
    private String address;
    private String PESEL;

    public Sender(String name, String address, String PESEL) throws IrresponsibleSenderWithDangerousGoods {
        this.name = name;
        this.address = address;
        this.PESEL = PESEL;
    }


    public void peselToDOB(String pesel) {
        int birthYear = 0;
        switch (PESEL.charAt(2)) {
            case '0' -> birthYear = 1900;
            case '2' -> birthYear = 2000;
            case '4' -> birthYear = 2100;
            case '6' -> birthYear = 2200;
        }
        birthYear += 10 * PESEL.charAt(0);
        birthYear += PESEL.charAt(1);
    }

    public String getPESEL() {
        return PESEL;
    }

    @Override
    public String toString() {
        return "Sender " + name;
    }
}
