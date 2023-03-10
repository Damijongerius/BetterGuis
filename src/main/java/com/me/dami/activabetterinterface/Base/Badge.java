package com.me.dami.activabetterinterface.Base;

import java.util.Date;

public class Badge {
    private String Name;
    private Date UnlockDate;
    private String Description;
    private type Type;

    private enum type{
        PLAYER,
        KINGDOM,
    }
}
