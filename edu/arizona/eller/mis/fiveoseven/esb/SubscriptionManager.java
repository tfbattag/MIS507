package edu.arizona.eller.mis.fiveoseven.esb;

import edu.arizona.eller.mis.fiveoseven.subscribers.Subscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 8/29/13
 * Time: 9:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubscriptionManager {
    List<Subscriber> subscribers;

    public SubscriptionManager(){
        subscribers = new ArrayList<Subscriber>();
    }

    public void addSubscribers(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    private void updateScores(){
        for(Subscriber s:subscribers){

        }
    }

}
