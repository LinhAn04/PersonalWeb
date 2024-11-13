package Survey.business;

import java.io.Serializable;

public class User implements Serializable {
    public String firstName;
    public String lastName;
    public String email;
    public String dateOfBirth;
    public String hearInfor;
    public String receiveInfor;
    public String contact;

    public User(){

    }


    public User(String firstName, String lastName, String email, String dateOfBirth,
                String hearInfor, String receiveInfor, String contact){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.hearInfor = hearInfor;
        this.receiveInfor = receiveInfor;
        this.contact = contact;
    }

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getDateOfBirth() {return dateOfBirth;}

    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public String getHearInfor() {return hearInfor;}

    public void getHearInfor(String hearInfor) {this.hearInfor = hearInfor;}

    public void setHearInfor(String hearInfor) {
        this.hearInfor = hearInfor;
    }

    public String getReceiveInfor() {
        return receiveInfor;
    }

    public void setReceiveInfor(String receiveInfor) {
        this.receiveInfor = receiveInfor;
    }

    public String getContact() {return contact;}

    public void setContact(String contact) {this.contact = contact;}
}
