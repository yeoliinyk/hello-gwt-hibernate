package com.yevgenoliinykov.HelloGWTHibernate.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.yevgenoliinykov.HelloGWTHibernate.client.AppController;

@GinModules(value = GinModule.class)
public interface AppGin extends Ginjector {
    AppController getAppController();
}
