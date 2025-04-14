package com.hexaware.sis.dao;

import com.hexaware.sis.entity.Payment;
import com.hexaware.sis.util.DBConnUtil;

import java.sql.*;
import java.util.List;

public class PaymentDAOImpl implements IPaymentDAO {

    @Override
    public void addPayment(Payment payment) throws Exception {
        String sql = "INSERT INTO payments (student_id, amount, payment_date) VALUES (?, ?, ?)";
        try (Connection con = DBConnUtil.getConnection("db.properties");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, payment.getStudent().getStudentId());
            ps.setDouble(2, payment.getAmount());
            ps.setString(3, payment.getPaymentDate());

            ps.executeUpdate();  
        }
    }

    @Override
    public Payment getPaymentById(int paymentId) throws Exception {
        String sql = "SELECT * FROM payments WHERE payment_id = ?";
        try (Connection con = DBConnUtil.getConnection("db.properties");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, paymentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Payment(
                        rs.getInt("payment_id"),
                        new StudentDAOImpl().getStudentById(rs.getInt("student_id")),
                        rs.getDouble("amount"),
                        rs.getString("payment_date")
                );
            }
        }
        return null;
    }

	@Override
	public List<Payment> getPaymentsByStudentId(int studentId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}


