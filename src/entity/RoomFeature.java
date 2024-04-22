package entity;

public class RoomFeature {
    private int roomID;
    private String featureName;

    public RoomFeature(int roomID, String featureName) {
        this.roomID = roomID;
        this.featureName = featureName;
    }

    public int getRoomID() {
        return roomID;
    }


    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
}
