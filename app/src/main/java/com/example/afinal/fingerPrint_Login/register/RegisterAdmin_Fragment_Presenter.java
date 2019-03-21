package com.example.afinal.fingerPrint_Login.register;

import java.util.Observable;

public class RegisterAdmin_Fragment_Presenter extends Observable {

    // https://www.youtube.com/watch?v=Asc4hU1iSTU&list=PLOzDKCBkR50Set8l8vzp4sWSumCy6Z6Nf&index=35&t=652s

    private OurView ourView;

    private boolean check;

    private RegisterAdmin_Fragment_FireStoreModel modelFireStore;

    public RegisterAdmin_Fragment_Presenter(OurView ourView) {

        this.ourView = ourView;

    }

    public boolean checkEmpty(String name, String phone){

        if(!name.isEmpty()&& !phone.isEmpty()){

            return true;
        }

        return false;
    }

    public boolean checkAdminFromFirebase(String name,String phone){

        modelFireStore = RegisterAdmin_Fragment_FireStoreModel.getInstance(name,phone);

        //check need to be an observer
        check = modelFireStore.getFromFireStore();

        //check before changed. always checking.
        setChanged();
        notifyObservers();
        if(check){
            //allow to log in
            return true;
        }

        return false;
    }

    public boolean isCheck() {
        return check;
    }
}
