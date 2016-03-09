package com.hummingbird.app.features.customobjects;

import com.hummingbird.cocoatouch.foundation.NSMutableArray;
import com.hummingbird.cocoatouch.foundation.NSObject;


public class GOTCharacter extends NSObject
{
    public String name;
    public int age;
    public NSMutableArray<GOTCharacter> friends = new NSMutableArray<>();

    public GOTCharacter(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public void addFriend(GOTCharacter friend)
    {
        this.friends.addObject(friend);
    }

    public static String[] allCharacters()
    {
        return new String[]{"Daenerys Targaryen", "Jon Snow", "Arya Stark", "Tyrion Lannister", "Cersei Lannister"};
    }
}
