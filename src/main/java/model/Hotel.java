package model;

public class Hotel {
    private int id;
    private String nameGuest;
    private String phone;
    private String date;
    private int typePayment;
    private String note;

    public Hotel(int id, String nameGuest, String phone, String date, int typePayment, String note) {
        this.id = id;
        this.nameGuest = nameGuest;
        this.phone = phone;
        this.date = date;
        this.typePayment = typePayment;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGuest() {
        return nameGuest;
    }

    public void setNameGuest(String nameGuest) {
        this.nameGuest = nameGuest;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(int typePayment) {
        this.typePayment = typePayment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
