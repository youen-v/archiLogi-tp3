package com.jad;

import com.jad.datamanagement.DataManager;
import com.jad.mastersensorhub.Application;
import com.jad.reportgeneration.ReportGenerator;
import com.jad.sensordata.SensorFactory;
import com.jad.userinterface.UserInterface;

public enum Main {
    ;

    public static void main(String[] args) {
        Application application = new Application();
        application.setDataManager(new DataManager());
        application.setSensorFactory(new SensorFactory());
        application.setReportGenerator(new ReportGenerator());
        application.setUserInterface(new UserInterface(application));
        application.start();
    }
}