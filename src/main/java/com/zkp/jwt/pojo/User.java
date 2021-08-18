package com.zkp.jwt.pojo;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private Integer id;


    private String username;


    private String password;

}
