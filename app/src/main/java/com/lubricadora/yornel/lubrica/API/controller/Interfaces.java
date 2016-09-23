package com.lubricadora.yornel.lubrica.API.controller;

import com.lubricadora.yornel.lubrica.Model.Cliente;

/**
 * Created by Yornel on 23-sep-16.
 */
public class Interfaces {

    public interface OnUserLogin {

        void onLoginCompleted(String jsonCliente);

        void onLoginFailure(String message);
    }
}
