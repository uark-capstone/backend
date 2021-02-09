package com.example.CapstoneBackend.DTO;



public class AWSDTO {
    String id;
    String ts; 
    String base64String; 

    public AWSDTO(){};

    @Override
    public String toString() {
        return "{" +
            " id='" + getID() + "'" +
            ", ts='" + getTs() + "'" +
            ", base64String='" + getBase64String() + "'" +
            "}";
    }

    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getTs() {
        return this.ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getBase64String() {
        return this.base64String;
    }

    public void setBase64String(String base64String) {
        this.base64String = base64String;
    }
    
}

// {
//     user_id: 01,
//   timestamp: blah,
//   photos: [base64 data]
// }