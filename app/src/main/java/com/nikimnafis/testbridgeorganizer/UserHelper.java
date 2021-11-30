package com.nikimnafis.testbridgeorganizer;

public class UserHelper {

    String nama, noTelp, email, password;

    public UserHelper() {

    }

    public UserHelper(String nama, String noTelp, String email, String password) {
        this.nama = nama;
        this.noTelp = noTelp;
        this.email = email;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
