package pl.edu.wszib.yourtravel.model.view;

public class PassModel {
    private String oldPass;
    private String newPass;
    private String newPass2;

    public PassModel() {
    }

    public PassModel(String oldPass, String newPass, String newPass2) {
        this.oldPass = oldPass;
        this.newPass = newPass;
        this.newPass2 = newPass2;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public String getNewPass2() {
        return newPass2;
    }

    public void setNewPass2(String newPass2) {
        this.newPass2 = newPass2;
    }
}
