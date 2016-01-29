package com.stan.meetapp.services.common.api

import akka.actor.ActorContext
import akka.actor.Props
import akka.actor.ActorRef
import akka.actor.Actor

/**
 * 
 * Exposes methods for actor creation
 * 
 * @author Stanislav Zhurich
 * 
 */
trait ActorCreationSupport { this:Actor => 
  
  def context:ActorContext
  
  /**
   * method for creating an actor.
   *
   * @param 	props  properties to be used for new actor
   * @param		name   of the actor 
   * @return       the newly created actor.
   */
  def createChild(props:Props, name:String):ActorRef = context.actorOf(props, name)
  
 /**
   * method for creating an actor.
   *
   * @param 	class  actor class to be created
   * @param		name   of the actor 
   * @param		args   optional list of the arguments to be passed in actor constructor
   * @return       the newly created actor.
   */
  def createChild(clazz:Class[_], name:String, args:Any*):ActorRef = {
    val props = Props.apply(clazz, args)
    context.actorOf(props, name)
  }
  
}