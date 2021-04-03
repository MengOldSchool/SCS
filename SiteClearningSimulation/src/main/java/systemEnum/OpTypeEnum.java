package systemEnum;

/*
 * Enum: Operation (Item) Table
 */
public enum OpTypeEnum {
	OpComm ("communication overhead"),
    OpFuel ("fuel usage"),
    OpUncldLd ("unclear squares"),
	OpDesResTree ("destruciton of protected tree"),
	OpRepDmg ("paint damagee to builldozer");

    public final String value;
    
    private OpTypeEnum(String s) {
        this.value = s;
    }

}
