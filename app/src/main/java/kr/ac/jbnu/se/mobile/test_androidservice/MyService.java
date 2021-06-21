package kr.ac.jbnu.se.mobile.test_androidservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyService extends Service {

    //쓰레드 안에서 생성된 핸들러로는 UI 처리 불가
    Handler mainHandler;

    public MyService(Handler mainHandler){
        this.mainHandler = mainHandler;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //시작될 때 작업?
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread locationThread = new Thread(mRun);
        locationThread.start();

        return super.onStartCommand(intent, flags, startId);
    }

    Runnable mRun = new Runnable() {
        @Override
        public void run() {
            //UI 수정 불가
            
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    //UI 수정 가능
                }
            });
        }
    };

    //종료될 때 작업

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
