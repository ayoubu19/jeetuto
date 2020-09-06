package models;

public class User {
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String post;
    private Integer age;
    private Integer holidayCounter;

    public User(String nom, String prenom, String username, String password, String post, Integer age, Integer holidayCounter) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.post = post;
        this.age = age;
        this.holidayCounter = holidayCounter;
    }

    public User(String username,String nom, String prenom, String post, Integer age) {
        this.username=username;
        this.nom = nom;
        this.prenom = prenom;
        this.post = post;
        this.age = age;
    }

    public void setHolidayCounter(Integer holidayCounter) {
        this.holidayCounter = holidayCounter;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPost() {
        return post;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getHolidayCounter() {
        return holidayCounter;
    }
}
