package org.example;

public class EmployeeDTO {
    private long empId;
    private String name;
    private String birth;
    private String gender;
    private String hireAt;
    private String fireAt;
    private long supId;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHireAt() {
        return hireAt;
    }

    public void setHireAt(String hireAt) {
        this.hireAt = hireAt;
    }

    public String getFireAt() {
        return fireAt;
    }

    public void setFireAt(String fireAt) {
        this.fireAt = fireAt;
    }

    public long getSupId() {
        return supId;
    }

    public void setSupId(long supId) {
        this.supId = supId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }
}
