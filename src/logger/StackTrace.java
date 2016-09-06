package logger;

import java.lang.reflect.Method;

public class StackTrace
{
    protected StackTrace() {}

    private static boolean useLogger = System.getProperty("StackTraceLoggerActive") != null;
    private static Class cls = null;
    private static Method method = null;

    public static void printStackTrace(Exception e)
    {
        if(!useLogger) { e.printStackTrace(); }
        else
        {
            try
            {
                if(cls == null) { cls = Class.forName("logger.Log"); }
                if(method == null) { method = cls.getDeclaredMethod("trace", Exception.class); }
                method.invoke(null, e);
            } catch(Exception ex) { useLogger = false; e.printStackTrace(); }
        }
    }
}