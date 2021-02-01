package com.example.CapstoneBackend.DTO;



public class UserDTO  {

    /*
    As you can see we are missing many elements of User. That is why we are using DTOs. 
    We don't want to share all the info on the User- thus only include what the frontend may need.
    Frontend would not need to see password.
    We could possibly need all values in the future but for now i just wanted to demonstrate 
    how we could use DTOs to our advantage
    */

    int id; 
    String name;

    public UserDTO(){}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
