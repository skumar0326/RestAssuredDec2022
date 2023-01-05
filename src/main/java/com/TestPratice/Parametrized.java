package com.TestPratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Parametrized {

 /*   @Test(dataProvider= "dataProvider")
    public  void  data(String fName,String lName) {
        System.out.println(fName + " -->  " +   lName );
        Assertions.assertThat(true).isEqualTo(false);
    }*/

  @Test(dataProvider = "dataProvider")
 public void  data(Map<String ,String> data){
      System.out.println(data.get("Username") + " --> " + data.get("Password") + " -->" + data.get("Email"));
 }



  /*  @DataProvider
    public Object[][] dataProvider(){

     return    new Object[][] {
                {"Kalpana" ,"Bandu"},
                {"Shirish" ,"kumar"},
                {"Jyotsna" ,"Boyapally"}
        };
    }*/


   //Alternate way of doing it
   @DataProvider
    public Object[][] dataProvider(){
       //first dim is number of times you want to execute
       //second dim is number of parameters to the method
        Object [][] data = new Object[3][1];

        Map<String,String> map1 = new HashMap<>();
          map1.put("Username" ,"Shirish");
          map1.put("Password" ,"password1");
          map1.put("Email" ,"email1");

        Map<String,String> map2 = new HashMap<>();
        map2.put("Username" ,"Shirish2");
        map2.put("Password" ,"password2");
        map2.put("Email" ,"email2");

        Map<String,String> map3 = new HashMap<>();
        map3.put("Username" ,"Shirish3");
        map3.put("Password" ,"password3");
        map3.put("Email" ,"email3");

        data[0][0] =map1;
        data[1][0] =map2;
        data[2][0] =map3;

        return  data;
    }




}



