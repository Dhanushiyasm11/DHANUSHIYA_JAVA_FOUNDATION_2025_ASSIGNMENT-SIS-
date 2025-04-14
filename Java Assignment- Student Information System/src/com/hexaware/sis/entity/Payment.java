package com.hexaware.sis.entity;

public class Payment {

    private int paymentId;
    private Student student;
    private double amount;
    private String paymentDate;
    
   
    public Payment() {
    }

    
    public Payment(int paymentId, Student student, double amount, String paymentDate) {
        this.paymentId = paymentId;
        this.student = student;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    // Method to retrieve the student associated with this payment
    public Student retrieveStudent() {
        return this.student;
    }

    // Method to retrieve the payment amount
    public double getPaymentAmount() {
        return this.amount;
    }

    // Method to retrieve the payment date
    public String getPaymentDate1() {
        return this.paymentDate;
    }

    // Method to display the payment information
    public void displayPaymentInfo() {
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Amount: " + amount);
        System.out.println("Payment Date: " + paymentDate);
    }

    @Override
    public String toString() {
        return "Payment [paymentId=" + paymentId + ", student=" + student + ", amount=" + amount + ", paymentDate=" + paymentDate + "]";
    }
}

