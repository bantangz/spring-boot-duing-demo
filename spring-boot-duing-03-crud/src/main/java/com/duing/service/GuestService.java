package com.duing.service;

import com.duing.bean.Guest;
import com.duing.dao.GuestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestDao guestDao;

    public List<Guest> findList(){
        return guestDao.findAllList();
    }

    public void add(Guest guest){
        guestDao.addGuest(guest);
    }

    public void update(Guest guest){
        guestDao.updateGuest(guest);
    }

    public void delete(String name){
        guestDao.deleteGuest(name);
    }

    public Guest findGuestByName(String name){
        return guestDao.findGuest(name);
    }
}
