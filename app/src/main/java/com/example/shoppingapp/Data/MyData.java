package com.example.shoppingapp.Data;

import com.example.shoppingapp.R;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;

public class MyData {

    public static List<Dictionary<String, String>> s_User = new ArrayList<Dictionary<String, String>>() {{
        add(new Hashtable<String, String>() {{ put("Mail", "Daniel@n-k.org.il"); put("FirstName" , "danie"); put("LastName" , "marko");put("Phone" , "0505555577"); put("Password" , "12345678");}});
        add(new Hashtable<String, String>() {{ put("Mail", "nir@gmail.com"); put("FirstName" , "nir"); put("LastName" , "katz");put("Phone" , "0508421756"); put("Password" , "12345678");}});
        add(new Hashtable<String, String>() {{ put("Mail", "y@g.c"); put("FirstName" , "yossi"); put("LastName" , "mair"); put("Phone" , "0508421756") ; put("Password" , "87654321");}});
    }};

    public static List<Dictionary<String, String>> s_Prodcut = new ArrayList<Dictionary<String, String>>() {{
        add(new Hashtable<String, String>() {{ put("Name", "Ipad"); put("Price" , "100"); put("ImageSRC" ,Integer.toString(R.drawable.ipad));}});
        add(new Hashtable<String, String>() {{ put("Name", "AirPods"); put("Price" , "150"); put("ImageSRC" , Integer.toString(R.drawable.airpods));}});
        add(new Hashtable<String, String>() {{ put("Name", "Air Tag"); put("Price" , "70"); put("ImageSRC" , Integer.toString(R.drawable.airtag));}});
        add(new Hashtable<String, String>() {{ put("Name", "Iphone"); put("Price" , "80"); put("ImageSRC" , Integer.toString(R.drawable.iphone));}});
        add(new Hashtable<String, String>() {{ put("Name", "MacBook"); put("Price" , "750"); put("ImageSRC" , Integer.toString(R.drawable.macbook));}});
        add(new Hashtable<String, String>() {{ put("Name", "Apple Pencil"); put("Price" , "950"); put("ImageSRC" , Integer.toString(R.drawable.apple_pencil));}});
        add(new Hashtable<String, String>() {{ put("Name", "PS5"); put("Price" , "1050"); put("ImageSRC" , Integer.toString(R.drawable.ps5));}});
        add(new Hashtable<String, String>() {{ put("Name", "Samsung S24"); put("100" , "danie"); put("ImageSRC" , Integer.toString(R.drawable.samsung));}});
        add(new Hashtable<String, String>() {{ put("Name", "Pc"); put("Price" , "59.9"); put("ImageSRC" , Integer.toString(R.drawable.pc));}});
        add(new Hashtable<String, String>() {{ put("Name", "XBOX"); put("Price" , "600"); put("ImageSRC" , Integer.toString(R.drawable.xbox));}});
        add(new Hashtable<String, String>() {{ put("Name", "Apple Watch"); put("Price" , "600"); put("ImageSRC" , Integer.toString(R.drawable.watch));}});
        add(new Hashtable<String, String>() {{ put("Name", "AirPods Max"); put("Price" , "600"); put("ImageSRC" , Integer.toString(R.drawable.airpodsmax));}});
    }};
}
