package com.example.shoppingapp.Activitys;

import com.example.shoppingapp.Data.MyData;

import java.util.Dictionary;
import java.util.Hashtable;

public class User {

    private String m_UserMail;
    private String m_UserLastName;
    private String m_UserFirstName;
    private String m_Password;

    private String m_Phone;

    public User(String i_FirstName , String i_LastName, String i_Phone , String i_Mail , String i_Password)
    {
        this.m_UserLastName = i_LastName;
        this.m_UserFirstName = i_FirstName;
        this.m_UserMail = i_Mail;
        this.m_Password = i_Password;
        this.m_Phone = i_Phone;
    }

    public String GetFullName(){
        return this.m_UserFirstName + " " + this.m_UserLastName;
    }

    public String GetFirstName(){ return this.m_UserFirstName;}
    public String GetLastName(){ return this.m_UserLastName;}
    public String GetPhoneName(){ return this.m_Phone;}
    public String GetPassword(){
        return m_Password;
    }

    public String GetMail(){
        return m_UserMail;
    }
    public static User CheckValidUser(String i_Mail, String i_Password) {
        User isValidUser = null;
        for (Dictionary<String, String> user : MyData.s_User) {
            String userMail = user.get("Mail");
            String userPassword = user.get("Password");
            if (userMail != null && userPassword != null && userMail.equals(i_Mail) && userPassword.equals(i_Password)) {
                isValidUser = new User((String)user.get("FirstName") , (String)user.get("LastName"),(String)user.get("Phone"),  i_Mail , i_Password);
                break;
            }
        }
        return isValidUser;
    }
}
