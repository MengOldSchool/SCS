package systemEnum;

/*
 * Enum - Activity Table
 */

public enum ActTypeEnum {
	ActClrPL ("Cleaning plain land"),
    ActVisCldLd ("Visting any land that has already been cleard"),
    ActClrRL ("Clearning rocky land"),
	ActClrTree ("Clearning land containg a tree");

    public final String value;
    
    private ActTypeEnum(String s) {
        this.value = s;
    }

}
