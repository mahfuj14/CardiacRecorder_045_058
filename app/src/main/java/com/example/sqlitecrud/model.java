package com.example.sqlitecrud;

public class model
{
  int id;
  String sys,dias,hr,comment,date,time;

  public model(int id, String sys, String dias, String hr, String comment, String date, String time) {
    this.id = id;
    this.sys = sys;
    this.dias = dias;
    this.hr = hr;
    this.comment = comment;
    this.date = date;
    this.time = time;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSys() {
    return sys;
  }

  public void setSys(String sys) {
    this.sys = sys;
  }

  public String getDias() {
    return dias;
  }

  public void setDias(String dias) {
    this.dias = dias;
  }

  public String getHr() {
    return hr;
  }

  public void setHr(String hr) {
    this.hr = hr;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }
}
