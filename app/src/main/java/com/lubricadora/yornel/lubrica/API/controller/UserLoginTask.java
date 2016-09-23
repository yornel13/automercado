package com.lubricadora.yornel.lubrica.API.controller;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lubricadora.yornel.lubrica.API.ApiInterface;
import com.lubricadora.yornel.lubrica.API.api;
import com.lubricadora.yornel.lubrica.Model.Cliente;
import com.lubricadora.yornel.lubrica.utils.Const;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Yornel on 23-sep-16.
 */
public class UserLoginTask extends AsyncTask<Void, Void, Boolean> implements Callback<JsonObject> {

    private Interfaces.OnUserLogin listener;
    private final String mEmail;
    private Call<JsonObject> call;

    public UserLoginTask(String email, Interfaces.OnUserLogin listener) {
        this.listener = listener;
        mEmail = email;
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        ApiInterface apiService = api.getClient().create(ApiInterface.class);

        try {
            Thread.sleep(1000);
            call = apiService.login(mEmail);
            call.enqueue(this);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    protected void onPostExecute(final Boolean success) {
        // Nothing to do;
    }

    public void cancelCall() {
        if (call != null) {
            System.out.println("call cancel");
            call.cancel();
        }
    }

    @Override
    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
        String message = response.body().get(Const.MESSAGE).getAsString();
        if (message.equals(Const.COMPLETADO)) {
            String jsonResponse = response.body().get(Const.RESPONSE).toString();
            listener.onLoginCompleted(jsonResponse);
        } else {
            listener.onLoginFailure(message);
        }
    }

    @Override
    public void onFailure(Call<JsonObject> call, Throwable t) {
        if (t instanceof java.net.SocketTimeoutException) {
            listener.onLoginFailure(Const.TIMED_OUT);
            return;
        }
        listener.onLoginFailure("");
    }
}
