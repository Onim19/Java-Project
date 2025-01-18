package add.details;

public class RoomDetails {
    private String roomNumber,Status,Cleaning_Status,BedType;
    private double price;
    public void setRoomDetails(String roomNumber,String Status,String Cleaning_Status,
                               double price,String BedType){
        this.roomNumber=roomNumber;
        this.Status=Status;
        this.Cleaning_Status=Cleaning_Status;
        this.price=price;
        this.BedType=BedType;
    }
    public String getRoomNumber(){return this.roomNumber;}
    public String getStatus(){return this.Status;}
    public String getCleaning_Status(){return this.Cleaning_Status;}
    public double getPrice(){return this.price;}
    public String getBedType(){return this.BedType;}

    public static void main(String[] args) {
        new RoomDetails();
    }
}
