package repositories;

import data.interfaces.IDB;
import entities.Medicine;
import repositories.interfaces.IMedicineRepositories;

import javax.inject.Inject;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MedicineRepository implements IMedicineRepositories {
    @Inject
    private IDB db;

    @Override
    public boolean createMedicine(Medicine med) {

        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(id, name, price, expiration_date, manufacturer) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, med.getId());
            st.setString(2, med.getName());
            st.setInt(3, med.getPrice());
            st.setString(4, med.getExpiration_date());
            st.setString(5, med.getManufacturer());

            st.execute();
            return true;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Medicine getMedicine(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, price, expiration_date, manufacturer FROM users WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Medicine med = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("expiration_date"),
                        rs.getString("manufacturer"));

                return med;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public List<Medicine> getAllMedicine() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, price, expiration_date, manufacturer FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Medicine> meds = new LinkedList<>();
            while (rs.next()) {
                Medicine med = new Medicine(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("expiration_date"),
                        rs.getString("manufacturer"));

                meds.add(med);
            }

            return meds;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}