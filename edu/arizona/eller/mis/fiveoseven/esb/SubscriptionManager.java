package edu.arizona.eller.mis.fiveoseven.esb;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import edu.arizona.eller.mis.fiveoseven.dto.Game;
import edu.arizona.eller.mis.fiveoseven.stubs.Deliverers;
import edu.arizona.eller.mis.fiveoseven.subscribers.Subscriber;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 8/29/13
 * Time: 9:27 PM
 *
 * This class is the core of the client-side Observer pattern. It is used to register Subscribers,
 * notify/update them and remove them per the pattern's requirements.
 */
public class SubscriptionManager {
    ListMultimap<Deliverers, Subscriber> subscribers;

    /**
     * Default constructor.
     * Notice that it creates an instance of a Guava ArrayListMap that will accept multiple
     * entries of the same Key in a Key,Value pair.
     */
    public SubscriptionManager(){
        subscribers = ArrayListMultimap.create();
    }

    /**
     * This method is used to add Subscribers to the service via an instance of this class.
     * This method is one of the required methods of an Observer.
     * @param subscriber
     * @param scoreService
     */
    public void addSubscribers(Subscriber subscriber, ScoreService scoreService){
        //call to factory for correct DelivererProxy here

        subscriber.setDelivererProxy(DelivererFactory.getDeliverer(subscriber.getPreferredMethod()));
        subscribers.put(subscriber.getPreferredMethod(), subscriber);
    }

    /**
     * This method is part of the Observer pattern. It is used to notify all Subscribers of updates
     * to the scores.
     * @param games
     */
    public void updateScores(List<Game> games){
        for(Subscriber subscriber: subscribers.values()){
            subscriber.getDelivererProxy().updateScores(games);
        }
    }

    /**
     * This method is a requirement of the Observer pattern. It allows Subscribers to remove themselves from
     * this Publisher/Subject.
     * @param subscriber
     */
    public void removeSubscriber(Subscriber subscriber){
        subscribers.remove(subscriber.getDelivererProxy(), subscriber);
    }

}
