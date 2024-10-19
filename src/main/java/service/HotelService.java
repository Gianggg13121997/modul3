package service;

import database.DatabaseConnection;
import model.Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelService {
    private List<Hotel> hotels;

    public HotelService() {
        hotels = new ArrayList<>();
        hotels.add(new Hotel(1, "giang", "01-01-2024", "month", 1, "dep trai"));
        // Thêm các phòng khác nếu cần
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public List<Hotel> getAll() {
        return hotels;
    }

    public int findIndexById(int id) {
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Hotel findHotelById(int id) {
        int index = this.findIndexById(id);
        return index != -1 ? hotels.get(index) : null;
    }

    public void deleteHotel(int id) {
        int index = this.findIndexById(id);
        if (index != -1) {
            hotels.remove(index);
        }
    }

    public void updateHotel(Hotel updatedHotel) {
        int index = findIndexById(updatedHotel.getId());
        if (index != -1) {
            hotels.set(index, updatedHotel);
        }
    }

    public List<Hotel> searchById(int id) {
        List<Hotel> result = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getId() == id) {
                result.add(hotel);
            }
        }
        return result;
    }
}

