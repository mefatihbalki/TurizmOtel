package entity;

public class HotelFeature {
    private int id;
    private String featureName;

    public HotelFeature(int id, String feature_name) {
        this.id = id;
        this.featureName = feature_name;
    }

    public int getId() {
        return id;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeature_name(String feature_name) {
        this.featureName = feature_name;
    }

    public String toString(){
        return this.featureName;
    }
}
