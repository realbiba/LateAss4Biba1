package repositories.interfaces;

import entities.Medicine;

import java.util.List;

public interface IMedicineRepositories {

    boolean createMedicine(Medicine med);
    Medicine getMedicine(int id);
    List<Medicine> getAllMedicine();
}