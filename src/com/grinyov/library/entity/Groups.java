package com.grinyov.library.entity;

/**
 *
 */
public class Groups  implements java.io.Serializable {


     private String groupid;

    public Groups() {
    }

    public Groups(String groupid) {
       this.groupid = groupid;
    }
   
    public String getGroupid() {
        return this.groupid;
    }
    
    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }




}


