package Exceptii;

public class CNPInvalidException extends RuntimeException {

    private long CNP;

    public CNPInvalidException(String s) {
        super(s);
    }

    public CNPInvalidException(long CNP) {
        this.CNP = CNP;
    }

    public long getCNP() {
        return CNP;
    }

}
