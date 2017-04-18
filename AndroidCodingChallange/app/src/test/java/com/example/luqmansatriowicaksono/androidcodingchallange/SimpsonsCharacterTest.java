package com.example.luqmansatriowicaksono.androidcodingchallange;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by luqmansatriowicaksono on 18.04.17.
 */

public class SimpsonsCharacterTest {

    @Test
    public void ShouldCreateCharacterAndReturnCharacteristics()
    {
        String firstname = "Homer";
        String lastname = "Simpsons";
        String image = "randomnImageURL";

        SimpsonsCharacter Homer = new SimpsonsCharacter(firstname,lastname,image);

        Assert.assertTrue(Homer.getFirstname()== firstname);
        Assert.assertTrue(Homer.getLastName()==lastname);
        Assert.assertTrue(Homer.getImg()== image);
    }
}
