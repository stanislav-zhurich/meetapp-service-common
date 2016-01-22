package com.stan.meetapp.services.common.api

import akka.actor.ActorContext
import akka.actor.Props

/**
 * 
 * @author Stanislav Zhurich
 */
trait ActorCreationSupport {
  
  def context:ActorContext
  
  def createChild(props:Props, name:String) = context.actorOf(props, name)
}