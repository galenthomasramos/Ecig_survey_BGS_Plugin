/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\Galen\\Desktop\\cordova 3.3\\ecigcordova3_3\\platforms\\android\\src\\com\\red_folder\\phonegap\\plugin\\backgroundservice\\BackgroundServiceApi.aidl
 */
package com.red_folder.phonegap.plugin.backgroundservice;
public interface BackgroundServiceApi extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceApi
{
private static final java.lang.String DESCRIPTOR = "com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceApi";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceApi interface,
 * generating a proxy if needed.
 */
public static com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceApi asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceApi))) {
return ((com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceApi)iin);
}
return new com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceApi.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getLatestResult:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getLatestResult();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_addListener:
{
data.enforceInterface(DESCRIPTOR);
com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceListener _arg0;
_arg0 = com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceListener.Stub.asInterface(data.readStrongBinder());
this.addListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeListener:
{
data.enforceInterface(DESCRIPTOR);
com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceListener _arg0;
_arg0 = com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceListener.Stub.asInterface(data.readStrongBinder());
this.removeListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_isTimerEnabled:
{
data.enforceInterface(DESCRIPTOR);
boolean _result = this.isTimerEnabled();
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_enableTimer:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.enableTimer(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_disableTimer:
{
data.enforceInterface(DESCRIPTOR);
this.disableTimer();
reply.writeNoException();
return true;
}
case TRANSACTION_getConfiguration:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getConfiguration();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_setConfiguration:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setConfiguration(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getTimerMilliseconds:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getTimerMilliseconds();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_run:
{
data.enforceInterface(DESCRIPTOR);
this.run();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceApi
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String getLatestResult() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLatestResult, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void addListener(com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void removeListener(com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public boolean isTimerEnabled() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_isTimerEnabled, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void enableTimer(int milliseconds) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(milliseconds);
mRemote.transact(Stub.TRANSACTION_enableTimer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void disableTimer() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_disableTimer, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public java.lang.String getConfiguration() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getConfiguration, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void setConfiguration(java.lang.String configuration) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(configuration);
mRemote.transact(Stub.TRANSACTION_setConfiguration, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getTimerMilliseconds() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getTimerMilliseconds, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public void run() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_run, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_getLatestResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_addListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_removeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_isTimerEnabled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_enableTimer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_disableTimer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_getConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_setConfiguration = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_getTimerMilliseconds = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_run = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
}
public java.lang.String getLatestResult() throws android.os.RemoteException;
public void addListener(com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceListener listener) throws android.os.RemoteException;
public void removeListener(com.red_folder.phonegap.plugin.backgroundservice.BackgroundServiceListener listener) throws android.os.RemoteException;
public boolean isTimerEnabled() throws android.os.RemoteException;
public void enableTimer(int milliseconds) throws android.os.RemoteException;
public void disableTimer() throws android.os.RemoteException;
public java.lang.String getConfiguration() throws android.os.RemoteException;
public void setConfiguration(java.lang.String configuration) throws android.os.RemoteException;
public int getTimerMilliseconds() throws android.os.RemoteException;
public void run() throws android.os.RemoteException;
}
