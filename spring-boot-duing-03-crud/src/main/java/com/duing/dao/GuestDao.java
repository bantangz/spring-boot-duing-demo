package com.duing.dao;

import com.duing.bean.Guest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestDao {
    private static List<Guest> guestList = new ArrayList<>();

    static{
        guestList.add( new Guest("高启强","卖鱼"));
        guestList.add( new Guest("高启盛","卖手机"));
        guestList.add( new Guest("高启兰","学生"));
        guestList.add( new Guest("安欣","警察"));
        guestList.add( new Guest("陈舒婷","大嫂"));
        guestList.add( new Guest("老默","卖鱼"));
    }

    public List<Guest> findAllList(){
        return guestList;
    }

    public boolean addGuest(Guest guest){
        for (Guest g:
             guestList) {
            if (g.getName().equalsIgnoreCase(guest.getName())){
                return false;
            }
        }
        guestList.add(guest);
        return true;
    }

    public void updateGuest(Guest guest){
        for (Guest g:
                guestList) {
            if (g.getName().equalsIgnoreCase(guest.getName())){
                g.setRole(guest.getRole());
                return;
            }
        }
    }

    public void deleteGuest(String name){
        for(int i = 0;i < guestList.size(); i++){
            if (guestList.get(i).getName().equalsIgnoreCase(name)){
                guestList.remove(i);
                break;
            }
        }
    }

    public Guest findGuest(String name){
        for(int i = 0;i < guestList.size(); i++){
            if (guestList.get(i).getName().equalsIgnoreCase(name)){
               return guestList.get(i);
            }
        }
        return null;
    }
}
