package jcanon;

/**
* jcanon/CorbaGameHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/vpc/xprojects/gaming/canon/src/tn/rnu/enit/ateliercorba/jcanon/jcanon.idl
* lundi 15 octobre 2007 19 h 43 CEST
*/

public final class CorbaGameHolder implements org.omg.CORBA.portable.Streamable
{
  public jcanon.CorbaGame value = null;

  public CorbaGameHolder ()
  {
  }

  public CorbaGameHolder (jcanon.CorbaGame initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = jcanon.CorbaGameHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    jcanon.CorbaGameHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return jcanon.CorbaGameHelper.type ();
  }

}