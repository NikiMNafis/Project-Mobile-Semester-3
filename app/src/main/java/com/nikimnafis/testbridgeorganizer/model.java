package com.nikimnafis.testbridgeorganizer;

public class model {

    String email, nama, notelp, gurl, status;

    public model() {

    }

    public model(String email, String nama, String notelp, String gurl, String status) {
        this.email = email;
        this.nama = nama;
        this.notelp = notelp;
        this.gurl = gurl;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getGurl() {
        return gurl;
    }

    public void setGurl(String gurl) {
        this.gurl = gurl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
