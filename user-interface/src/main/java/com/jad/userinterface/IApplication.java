package com.jad.userinterface;

import com.jad.datamanagement.IDataManager;

public interface IApplication {
    void manageOrder(UserAction userAction);

    IDataManager getDataManager();
}
