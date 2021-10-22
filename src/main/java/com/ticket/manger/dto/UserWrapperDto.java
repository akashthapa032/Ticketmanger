package com.ticket.manger.dto;


import java.util.List;

//to get the all the userlist
public class UserWrapperDto {

    private List<UserDto> data ;

    public UserWrapperDto() {
    }

    public UserWrapperDto(List<UserDto> data) {
        this.data = data;
    }

    public List<UserDto> getData() {
        return data;
    }

    public void setData(List<UserDto> data) {
        this.data = data;
    }
}
