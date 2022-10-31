package exceptions;

import containers.Container;

public class IrresponsibleSenderWithDangerousGoods extends Exception {
    public IrresponsibleSenderWithDangerousGoods() {
        super("Irresponsible sender with dangerous goods!");
    }
}
