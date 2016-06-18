package com.deveignatik.MessageBroker;

import com.deveignatik.MessageBroker.LibKernel.Broker;
import com.deveignatik.MessageBroker.LibKernel.ModelDataApp;
import org.apache.log4j.BasicConfigurator;

/**
 * 12:39 PM.
 */
public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Broker.init();
    }
}
