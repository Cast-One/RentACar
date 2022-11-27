package com.castillo.rentacar.Tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class RentCarTools {
    private final Context context;
    public RentCarTools(Context context) {
        this.context = context;
    }

    public void nextActivity(Class nextActivity){
        try {
            Activity activity = (Activity)context;
            Intent intent = new Intent(context, nextActivity);
            activity.startActivity(intent);
        }catch(Exception ignored){}
    }

    public void nextActivityFinish(Class nextActivity){
        try {
            Activity activity = (Activity) context;
            Intent intent = new Intent(context, nextActivity);
            activity.startActivity(intent);
            activity.finish();
        }catch(Exception ignored){}
    }

    public boolean emptyField(EditText editText){
        if (editText.getText().toString().isEmpty()){
            InputMethodManager inputMethodManager = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInputFromWindow(editText.getApplicationWindowToken(), InputMethodManager.SHOW_FORCED, 0);
            editText.requestFocus();
            return true;
        }

        return false;
    }


    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
