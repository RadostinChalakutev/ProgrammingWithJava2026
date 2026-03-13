package P02;

class Building{
    private double area;

    Building(double area){
        this.area=area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

}
class Room extends Building{
    private double roomArea;
    private String buildingName;

    Room(double roomArea,String buildingName,double area){
        super(area);
        this.roomArea=roomArea;
        this.buildingName=buildingName;
    }

    public double getRoomArea() {
        return roomArea;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public void setRoomArea(double roomArea) {
        this.roomArea = roomArea;
    }
    @Override
    public String toString(){
        return "Name of building: "+buildingName+" with area "+roomArea;

    }
}