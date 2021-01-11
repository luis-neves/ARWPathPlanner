// ------------------------------------------------------------------------------
//  <autogenerated>
//      This code was generated by jni4net. See http://jni4net.sourceforge.net/ 
// 
//      Changes to this file may cause incorrect behavior and will be lost if 
//      the code is regenerated.
//  </autogenerated>
// ------------------------------------------------------------------------------

package classlib;

@net.sf.jni4net.attributes.ClrType
public class CommunicationManager extends system.Object {
    
    //<generated-proxy>
    private static system.Type staticType;
    
    protected CommunicationManager(net.sf.jni4net.inj.INJEnv __env, long __handle) {
            super(__env, __handle);
    }
    
    @net.sf.jni4net.attributes.ClrConstructor("(LSystem/String;LClassLib/TopicsConfiguration;LClassLib/ICommunicationManagerCallbacks;)V")
    public CommunicationManager(java.lang.String serviceBusClientId, classlib.TopicsConfiguration topicsConfiguration, classlib.ICommunicationManagerCallbacks callbacksInterface) {
            super(((net.sf.jni4net.inj.INJEnv)(null)), 0);
        classlib.CommunicationManager.__ctorCommunicationManager0(this, serviceBusClientId, topicsConfiguration, callbacksInterface);
    }
    
    @net.sf.jni4net.attributes.ClrMethod("(Ljava/lang/String;Lclasslib/TopicsConfiguration;Lclasslib/ICommunicationManagerCallbacks;)V")
    private native static void __ctorCommunicationManager0(net.sf.jni4net.inj.IClrProxy thiz, java.lang.String serviceBusClientId, classlib.TopicsConfiguration topicsConfiguration, classlib.ICommunicationManagerCallbacks callbacksInterface);
    
    @net.sf.jni4net.attributes.ClrMethod("()LClassLib/ClientTopicsInfo;")
    public native classlib.ClientTopicsInfo getClientInfo();
    
    @net.sf.jni4net.attributes.ClrMethod("()LClassLib/TopicsConfiguration;")
    public native classlib.TopicsConfiguration getConfigurations();
    
    @net.sf.jni4net.attributes.ClrMethod("()LSystem/Threading/Tasks/Task;")
    public native system.Object InitializeAsync();
    
    @net.sf.jni4net.attributes.ClrMethod("(LSystem/String;LSystem/String;LSystem/String;LSystem/String;LSystem/String;LSystem/String;LSystem/String;)LSystem/Threading/Tasks/Task;")
    public native system.Object SendMessageAsync(java.lang.String messageId, java.lang.String messageType, java.lang.String infoIdentifier, java.lang.String toID, java.lang.String dataFormat, java.lang.String content, java.lang.String priority);
    
    @net.sf.jni4net.attributes.ClrMethod("(LSystem/String;LSystem/String;LSystem/String;LSystem/String;)LSystem/Threading/Tasks/Task;")
    public native system.Object SendStreamMessageAsync(java.lang.String contentIdentification, java.lang.String dataFormat, java.lang.String msgContent, java.lang.String priority);
    
    @net.sf.jni4net.attributes.ClrMethod("(LSystem/String;LSystem/String;)LSystem/Threading/Tasks/Task;")
    public native system.Object SubscribeContentAsync(java.lang.String contentIndentification, java.lang.String streamerID);
    
    @net.sf.jni4net.attributes.ClrMethod("(LSystem/String;LSystem/String;)LSystem/Threading/Tasks/Task;")
    public native system.Object UnsubscribeContentAsync(java.lang.String contentIndentification, java.lang.String streamerID);
    
    @net.sf.jni4net.attributes.ClrMethod("(LSystem/String;LSystem/String;)V")
    public native void AddNewSubscriptionClient(java.lang.String priorityId, java.lang.String subscriptionName);
    
    @net.sf.jni4net.attributes.ClrMethod("(LSystem/String;LSystem/String;)LSystem/Threading/Tasks/Task;")
    public native system.Object RemoveStreamingSubscriptionClientAsync(java.lang.String contentIdentification, java.lang.String streamerTopicName);
    
    @net.sf.jni4net.attributes.ClrMethod("()V")
    public native void InitLogSystem();
    
    @net.sf.jni4net.attributes.ClrMethod("(LSystem/String;)V")
    public native void InitLogSystem(java.lang.String path);
    
    @net.sf.jni4net.attributes.ClrMethod("(LSystem/String;)LSystem/String;")
    public native static java.lang.String BaseTopicToId(java.lang.String topicName);
    
    public static system.Type typeof() {
        return classlib.CommunicationManager.staticType;
    }
    
    private static void InitJNI(net.sf.jni4net.inj.INJEnv env, system.Type staticType) {
        classlib.CommunicationManager.staticType = staticType;
    }
    //</generated-proxy>
}