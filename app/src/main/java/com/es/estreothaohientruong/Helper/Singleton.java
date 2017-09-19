package com.es.estreothaohientruong.Helper;

import com.es.estreothaohientruong.Data.Entities.ManagementUnitEntity;

import java.util.ArrayList;

/**
 * Created by My_PC on 8/30/2017.
 */

public class Singleton {
    private static final Singleton singleton = new Singleton();
    public String IPAddress;
    public String IdCompany;
    public String userName;
    public String password;
    public String idCustomer;
    public ArrayList<ManagementUnitEntity> managementUnitEntities;

    public static Singleton getInstance() {
        return singleton;
    }

    private Singleton() {
        IPAddress = CurrentPrefers.getInstance().getIP();
    }
}
