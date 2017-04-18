package com.example.luqmansatriowicaksono.androidcodingchallange;

/**
 * Created by luqmansatriowicaksono on 17.04.17.
 */

public class SimpsonsCharacter {

    private String firstname;
    private String lastname;
    private String img;

    public SimpsonsCharacter(String FirstName, String LastName, String Img)
    {
        firstname = FirstName;
        lastname = LastName;
        img = Img;


    }

    // Since the image will be displayed with picasso, only the image URL will be stored
    public String getImg(){return img;}

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastName()
    {
        return lastname;
    }

}
}
