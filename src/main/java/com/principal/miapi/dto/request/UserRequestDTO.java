package com.principal.miapi.dto.request;

import com.principal.miapi.model.Rol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO{

    private String username;

    private String password;

    private Rol rol;
}
