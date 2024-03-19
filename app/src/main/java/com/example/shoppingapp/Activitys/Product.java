package com.example.shoppingapp.Activitys;

public class Product {
    private String m_Name;
    private String m_Price;
    private Integer m_Image;

    private Integer m_CountCart;

    public  Product(String i_Name , String i_Price , Integer i_Image)
    {
        this.m_Name = i_Name;
        this.m_Price = i_Price;
        this.m_Image = i_Image;
        this.m_CountCart = 0;
    }

    public  String GetName()
    {
        return this.m_Name;
    }
    public  String GetPrice()
    {
        return this.m_Price;
    }
    public  Integer GetImage() {
        return this.m_Image;
    }
    public  Integer GetCountCart() {
        return this.m_CountCart;
    }
    public void SetCountCart(Integer i_Count){this.m_CountCart += i_Count;}
}
