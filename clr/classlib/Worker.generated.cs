//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by jni4net. See http://jni4net.sourceforge.net/ 
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace ClassLib {
    
    
    #region Component Designer generated code 
    public partial class Worker_ {
        
        public static global::java.lang.Class _class {
            get {
                return global::ClassLib.@__Worker.staticClass;
            }
        }
    }
    #endregion
    
    #region Component Designer generated code 
    [global::net.sf.jni4net.attributes.JavaProxyAttribute(typeof(global::ClassLib.Worker), typeof(global::ClassLib.Worker_))]
    [global::net.sf.jni4net.attributes.ClrWrapperAttribute(typeof(global::ClassLib.Worker), typeof(global::ClassLib.Worker_))]
    internal sealed partial class @__Worker : global::java.lang.Object {
        
        internal new static global::java.lang.Class staticClass;
        
        private @__Worker(global::net.sf.jni4net.jni.JNIEnv @__env) : 
                base(@__env) {
        }
        
        private static void InitJNI(global::net.sf.jni4net.jni.JNIEnv @__env, java.lang.Class @__class) {
            global::ClassLib.@__Worker.staticClass = @__class;
        }
        
        private static global::System.Collections.Generic.List<global::net.sf.jni4net.jni.JNINativeMethod> @__Init(global::net.sf.jni4net.jni.JNIEnv @__env, global::java.lang.Class @__class) {
            global::System.Type @__type = typeof(__Worker);
            global::System.Collections.Generic.List<global::net.sf.jni4net.jni.JNINativeMethod> methods = new global::System.Collections.Generic.List<global::net.sf.jni4net.jni.JNINativeMethod>();
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "Start", "Start0", "(Lsystem/MulticastDelegate;)V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "Pause", "Pause1", "()V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "Resume", "Resume2", "()V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "Stop", "Stop3", "()V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "IsPaused", "IsPaused4", "()Z"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "DoWork", "DoWork5", "()V"));
            methods.Add(global::net.sf.jni4net.jni.JNINativeMethod.Create(@__type, "__ctorWorker0", "__ctorWorker0", "(Lnet/sf/jni4net/inj/IClrProxy;)V"));
            return methods;
        }
        
        private static void Start0(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj, global::net.sf.jni4net.utils.JniLocalHandle threadStart) {
            // (Lsystem/MulticastDelegate;)V
            // (LSystem/Threading/ThreadStart;)V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::ClassLib.Worker @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::ClassLib.Worker>(@__env, @__obj);
            @__real.Start(global::net.sf.jni4net.utils.Convertor.StrongJ2CpDelegate<global::System.Threading.ThreadStart>(@__env, threadStart));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static void Pause1(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()V
            // ()V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::ClassLib.Worker @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::ClassLib.Worker>(@__env, @__obj);
            @__real.Pause();
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static void Resume2(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()V
            // ()V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::ClassLib.Worker @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::ClassLib.Worker>(@__env, @__obj);
            @__real.Resume();
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static void Stop3(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()V
            // ()V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::ClassLib.Worker @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::ClassLib.Worker>(@__env, @__obj);
            @__real.Stop();
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static bool IsPaused4(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()Z
            // ()Z
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            bool @__return = default(bool);
            try {
            global::ClassLib.Worker @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::ClassLib.Worker>(@__env, @__obj);
            @__return = ((bool)(@__real.IsPaused()));
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
            return @__return;
        }
        
        private static void DoWork5(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()V
            // ()V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::ClassLib.Worker @__real = global::net.sf.jni4net.utils.Convertor.StrongJp2C<global::ClassLib.Worker>(@__env, @__obj);
            @__real.DoWork();
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        private static void @__ctorWorker0(global::System.IntPtr @__envp, global::net.sf.jni4net.utils.JniLocalHandle @__class, global::net.sf.jni4net.utils.JniLocalHandle @__obj) {
            // ()V
            // ()V
            global::net.sf.jni4net.jni.JNIEnv @__env = global::net.sf.jni4net.jni.JNIEnv.Wrap(@__envp);
            try {
            global::ClassLib.Worker @__real = new global::ClassLib.Worker();
            global::net.sf.jni4net.utils.Convertor.InitProxy(@__env, @__obj, @__real);
            }catch (global::System.Exception __ex){@__env.ThrowExisting(__ex);}
        }
        
        new internal sealed class ContructionHelper : global::net.sf.jni4net.utils.IConstructionHelper {
            
            public global::net.sf.jni4net.jni.IJvmProxy CreateProxy(global::net.sf.jni4net.jni.JNIEnv @__env) {
                return new global::ClassLib.@__Worker(@__env);
            }
        }
    }
    #endregion
}