// ------------------------------------------------------------------------------
//  <autogenerated>
//      This code was generated by jni4net. See http://jni4net.sourceforge.net/ 
// 
//      Changes to this file may cause incorrect behavior and will be lost if 
//      the code is regenerated.
//  </autogenerated>
// ------------------------------------------------------------------------------

package classlib;

@net.sf.jni4net.attributes.ClrInterface
public interface ICommunicationManagerCallbacks {
    
    //<generated-interface>
    @net.sf.jni4net.attributes.ClrMethod("()LClassLib/CommunicationManager;")
    classlib.CommunicationManager getCommunicator();
    
    @net.sf.jni4net.attributes.ClrMethod("(LClassLib/CommunicationManager;)V")
    void SetCommunicationManager(classlib.CommunicationManager communicationManager);
    
    @net.sf.jni4net.attributes.ClrMethod("(Z)V")
    void InitializationDoneEvent(boolean isSuccess);
    
    @net.sf.jni4net.attributes.ClrMethod("(ZLSystem/String;)V")
    void MessageSentEvent(boolean wasSent, java.lang.String messageId);
    
    @net.sf.jni4net.attributes.ClrMethod("(ZLSystem/String;LSystem/String;)V")
    void StreamMessageSentEvent(boolean wasSent, java.lang.String messageId, java.lang.String contentIndentification);
    
    @net.sf.jni4net.attributes.ClrMethod("(ZLSystem/String;LSystem/String;)V")
    void ContentSubscribedEvent(boolean isSuccess, java.lang.String contentIndentification, java.lang.String streamerID);
    
    @net.sf.jni4net.attributes.ClrMethod("(ZLSystem/String;LSystem/String;)V")
    void ContentUnsubscribedEvent(boolean isSuccess, java.lang.String contentIndentification, java.lang.String streamerID);
    
    @net.sf.jni4net.attributes.ClrMethod("(LClassLib/BusMessage;)V")
    void MessageToProcessEvent(classlib.BusMessage message);
    //</generated-interface>
}
