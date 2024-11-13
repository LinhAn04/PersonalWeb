package Ch06.ex2;

import java.io.Serializable;

public class EmailUserCh06ex2 implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String email;
    private String heardfrom;
    private String update;
    private String contactvia;

    public EmailUserCh06ex2(){
        firstName = "";
        lastName = "";
        email = "";
        heardfrom = "";
        update = "";
        contactvia = "";
    }

    public EmailUserCh06ex2(String firstName, String lastName, String email,
                            String heardfrom, String update, String contactvia) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.heardfrom = heardfrom;
        this.update = update;
        this.contactvia = contactvia;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeardfrom() { return heardfrom; }

    public void setHeardfrom(String heardfrom) { this.heardfrom = heardfrom; }

    public String getUpdate() { return update; }

    public void setUpdate(String update) { this.update = update; }

    public String getContactvia() { return contactvia; }

    public void setContactvia(String contactvia) { this.contactvia = contactvia; }
}
