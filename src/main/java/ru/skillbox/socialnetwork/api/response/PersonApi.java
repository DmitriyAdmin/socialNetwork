package ru.skillbox.socialnetwork.api.response;

public class PersonApi implements AbstractResponse {

  private int id;
  private String firstName;
  private String lastName;
  private long regDate;
  private long birthDate;
  private String email;
  private String phone;
  private String photo;
  private String about;
  private int town;
  private int country_id;
  private messages_permissions messagesPermission;
  private long lastOnlineTime;
  private boolean isBlocked;

  public enum messages_permissions {ALL, FRIENDS}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirst_name() {
    return firstName;
  }

  public void setFirst_name(String first_name) {
    this.firstName = first_name;
  }

  public String getLast_name() {
    return lastName;
  }

  public void setLast_name(String last_name) {
    this.lastName = last_name;
  }

  public long getReg_date() {
    return regDate;
  }

  public void setReg_date(long reg_date) {
    this.regDate = reg_date;
  }

  public long getBirth_date() {
    return birthDate;
  }

  public void setBirth_date(long birth_date) {
    this.birthDate = birth_date;
  }

  public int getTown_id() {
    return town;
  }

  public long getLast_online_time() {
    return lastOnlineTime;
  }

  public void setLast_online_time(long last_online_time) {
    this.lastOnlineTime = last_online_time;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getAbout() {
    return about;
  }

  public void setAbout(String about) {
    this.about = about;
  }


  public messages_permissions getMessages_permission() {
    return messagesPermission;
  }

  public void setMessages_permission(messages_permissions messages_permission) {
    this.messagesPermission = messages_permission;
  }


  public void setTown_id(int town_id) {
    this.town = town_id;
  }

  public int getCountry_id() {
    return country_id;
  }

  public void setCountry_id(int country_id) {
    this.country_id = country_id;
  }

  public boolean isIs_blocked() {
    return isBlocked;
  }

  public void setIs_blocked(boolean is_blocked) {
    this.isBlocked = is_blocked;
  }
}
