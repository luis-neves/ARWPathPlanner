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
public class InvalidPriorityException extends system.Exception {
    
    //<generated-proxy>
    private static system.Type staticType;
    
    protected InvalidPriorityException(net.sf.jni4net.inj.INJEnv __env, long __handle) {
            super(__env, __handle);
    }
    
    @net.sf.jni4net.attributes.ClrConstructor("()V")
    public InvalidPriorityException() {
            super(((net.sf.jni4net.inj.INJEnv)(null)), 0);
        classlib.InvalidPriorityException.__ctorInvalidPriorityException0(this);
    }
    
    @net.sf.jni4net.attributes.ClrConstructor("(LSystem/String;)V")
    public InvalidPriorityException(java.lang.String priority) {
            super(((net.sf.jni4net.inj.INJEnv)(null)), 0);
        classlib.InvalidPriorityException.__ctorInvalidPriorityException1(this, priority);
    }
    
    @net.sf.jni4net.attributes.ClrMethod("()V")
    private native static void __ctorInvalidPriorityException0(net.sf.jni4net.inj.IClrProxy thiz);
    
    @net.sf.jni4net.attributes.ClrMethod("(Ljava/lang/String;)V")
    private native static void __ctorInvalidPriorityException1(net.sf.jni4net.inj.IClrProxy thiz, java.lang.String priority);
    
    public static system.Type typeof() {
        return classlib.InvalidPriorityException.staticType;
    }
    
    private static void InitJNI(net.sf.jni4net.inj.INJEnv env, system.Type staticType) {
        classlib.InvalidPriorityException.staticType = staticType;
    }
    //</generated-proxy>
}