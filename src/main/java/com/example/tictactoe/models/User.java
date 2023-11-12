package com.example.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// using flyweight here
// User is intrinsic class(which will not change) and HumanPlayer is extrinsic
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String email;
    private String photo;
}
