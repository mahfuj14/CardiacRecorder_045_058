package com.example.sqlitecrud;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

@RunWith(RobolectricTestRunner.class)
public class Unit_test {

    @Test
    public  void testadd()
    {
       dbmanager mg=new dbmanager(RuntimeEnvironment.getApplication());
       String systo="120";
       String dis="85";
       String pul="70";
       String com="Good";

       long id=mg.addrecord(systo,dis,pul,com);
       assertTrue(id>0);
       mg.close();
    }

}
