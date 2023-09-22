package com.example.spring20230920.domain;

public class MyDto1 {
    //property명: get/set 없애고 소문자로 시작

    // name property
    // homeAddress property 앞은 소문자, 뒤는 대문자
    //MYHOME처럼 대문자가 연속으로 있으면 대문자 자체가 property명임

    private String name;
    private String homeAddress;
    private String MYHOME;
    private Boolean married; //Boolean타입은 getMarried나 isMarried 둘다 가능
    //기본타입 boolean은 is로 나오고 참조타입 boolean은 get으로 나옴. set메소드에서는 안됨.
    private boolean checked;

    public boolean isChecked() { //기본타입 boolean은 get메소드 만들면 is로 나옴
        return checked;
    }

    public void setChecked(boolean checked) { //set은 값을 입력해야되니까 parameter가 있음
        this.checked = checked;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public String getMYHOME() { //대문자가 연속으로 있으면 대문자 자체가 property명임
        return MYHOME;
    }

    public void setMYHOME(String MYHOME) {
        this.MYHOME = MYHOME;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
