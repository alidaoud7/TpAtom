package net.thevpc.gaming.atom.examples.pong.main.shared.dal.corba.generated;

/**
 * tn/edu/eniso/pong/main/shared/dal/corba/generated/ClientOperationsCorbaHolder.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from DalCorba.idl
 * Tuesday, December 20, 2011 11:10:02 PM CET
 */

public final class ClientOperationsCorbaHolder implements org.omg.CORBA.portable.Streamable {
    public ClientOperationsCorba value = null;

    public ClientOperationsCorbaHolder() {
    }

    public ClientOperationsCorbaHolder(ClientOperationsCorba initialValue) {
        value = initialValue;
    }

    public void _read(org.omg.CORBA.portable.InputStream i) {
        value = ClientOperationsCorbaHelper.read(i);
    }

    public void _write(org.omg.CORBA.portable.OutputStream o) {
        ClientOperationsCorbaHelper.write(o, value);
    }

    public org.omg.CORBA.TypeCode _type() {
        return ClientOperationsCorbaHelper.type();
    }

}
