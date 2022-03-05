public class WorldState {
    private String roomMonkeyIn;
    private String roomBoxIn;
    private String roomBananasIn;
    private String monkeyHeight;
    private boolean monkeyHasBananas;

    public String lastOp;

    public static final String ROOM_A = "A";
    public static final String ROOM_B = "B";
    public static final String ROOM_C = "C";
    public static final String HEIGHT_LOW = "Low";
    public static final String HEIGHT_HIGH = "High";

    public static String rooms = "ABC";

    public WorldState(String roomMonkeyIn, String roomBoxIn, String roomBananasIn, String monkeyHeight, boolean monkeyHasBananas, String lastOperation){
        this.roomMonkeyIn = roomMonkeyIn;
        this.roomBoxIn = roomBoxIn;
        this.roomBananasIn = roomBananasIn;
        this.monkeyHeight = monkeyHeight;
        this.monkeyHasBananas = monkeyHasBananas;
        this.lastOp = lastOperation;
    }
    // public WorldState(){
        
    // }

    public String getRoomMonkeyIn(){
        return this.roomMonkeyIn;
    }
    public String getRoomBoxIn(){
        return this.roomBoxIn;
    }
    public String getroomBananasIn(){
        return this.roomBananasIn;
    }
    public String getMonkeyHeight(){
        return this.monkeyHeight;
    }
    public boolean getMonkeyHasBananas(){
        return this.monkeyHasBananas;
    }

    public boolean isMonkeyAt(String room) {
        return this.roomMonkeyIn.equalsIgnoreCase(room);
    }
    public boolean isBoxAt(String room) {
        return this.roomBoxIn.equalsIgnoreCase(room);
    }
    public boolean isMonkeyHeight(String height) {
        return this.monkeyHeight.equalsIgnoreCase(height);
    }

    public void printState(){
        System.out.println("Monke: "+ roomMonkeyIn + " " + "Box: "+ roomBoxIn + " " +"Banans: "+ roomBananasIn+ " " + "Height: "+ monkeyHeight+" " + "Has: " + monkeyHasBananas);
    }

}


