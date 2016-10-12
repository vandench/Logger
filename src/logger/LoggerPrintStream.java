package logger;

import java.io.PrintStream;

public class LoggerPrintStream extends PrintStream
{
    protected final boolean isOut;

    public LoggerPrintStream(PrintStream original, boolean isOut)
    {
        super(original);
        this.isOut = isOut;
    }

    protected void println0(String s) { super.println(s); }

    @Override
    public void println(String s)
    {
        ++Log.ClassGetter.TMP;
        if(isOut) { Log.out(s); }
        else { Log.err(s); }
    }

    @Override
    public void println(Object o)
    {
        ++Log.ClassGetter.TMP;
        println(o.toString());
    }
}
