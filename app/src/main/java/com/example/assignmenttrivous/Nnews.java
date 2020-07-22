package com.example.assignmenttrivous;

public class Nnews {
    private String Nname;
    private String Ndescription;
    private String Ntitle;
    private String NpublishedAt;
    private String Nimageurl;

    public Nnews()
    {}

    public Nnews(String nname, String ndescription, String ntitle, String npublishedAt, String nimageurl) {
        Nname = nname;
        Ndescription = ndescription;
        Ntitle = ntitle;
        NpublishedAt = npublishedAt;
        Nimageurl = nimageurl;
    }

    public String getNname() {
        return Nname;
    }

    public void setNname(String nname) {
        Nname = nname;
    }

    public String getNdescription() {
        return Ndescription;
    }

    public void setNdescription(String ndescription) {
        Ndescription = ndescription;
    }

    public String getNtitle() {
        return Ntitle;
    }

    public void setNtitle(String ntitle) {
        Ntitle = ntitle;
    }

    public String getNpublishedAt() {
        return NpublishedAt;
    }

    public void setNpublishedAt(String npublishedAt) {
        NpublishedAt = npublishedAt;
    }

    public String getNimageurl() {
        return Nimageurl;
    }

    public void setNimageurl(String nimageurl) {
        Nimageurl = nimageurl;
    }
}
