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
public class Worker extends system.Object {
    
    //<generated-proxy>
    private static system.Type staticType;
    
    protected Worker(net.sf.jni4net.inj.INJEnv __env, long __handle) {
            super(__env, __handle);
    }
    
    @net.sf.jni4net.attributes.ClrConstructor("()V")
    public Worker() {
            super(((net.sf.jni4net.inj.INJEnv)(null)), 0);
        classlib.Worker.__ctorWorker0(this);
    }
    
    @net.sf.jni4net.attributes.ClrMethod("()V")
    private native static void __ctorWorker0(net.sf.jni4net.inj.IClrProxy thiz);
    
    @net.sf.jni4net.attributes.ClrMethod("(LSystem/Threading/ThreadStart;)V")
    public native void Start(system.MulticastDelegate threadStart);
    
    @net.sf.jni4net.attributes.ClrMethod("()V")
    public native void Pause();
    
    @net.sf.jni4net.attributes.ClrMethod("()V")
    public native void Resume();
    
    @net.sf.jni4net.attributes.ClrMethod("()V")
    public native void Stop();
    
    @net.sf.jni4net.attributes.ClrMethod("()Z")
    public native boolean IsPaused();
    
    @net.sf.jni4net.attributes.ClrMethod("()V")
    public native void DoWork();
    
    public static system.Type typeof() {
        return classlib.Worker.staticType;
    }
    
    private static void InitJNI(net.sf.jni4net.inj.INJEnv env, system.Type staticType) {
        classlib.Worker.staticType = staticType;
    }
    //</generated-proxy>
}