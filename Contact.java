package java2assign2;

public class Contact {
    private String name;
    private String number;
    private String email;
    
    public Contact(){
        name = "";
        number = "";
        email = "";
    }

    public Contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    } //constructor

    public String getName() {
        return name;
    }//getName method end

    public String getNumber() {
        return number;
    }//getNumber method end
    
    public String getEmail() {
        return email;
    }//getEmail method end
    
    public void setName(String name) {
        this.name = name;
    }//setName method end

    public void setNumber(String number) {
        this.number = number;
    }//setNumber method end

    public void setEmail(String email) {
        this.email = email;
    }//setEmail method end
    
}
