package co.com.sofka.questions.model;

public class UserDTO {

    private String id;
    private String name;
    private String lastName;
    private String email;

    public UserDTO() {
    }

    public UserDTO(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public UserDTO(String id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
