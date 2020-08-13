# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#1.基本指令区
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers
-dontpreverify
-verbose
#-ignorewarning
-printmapping proguardMapping.txt
-optimizations !code/simplification/cast,!field/*,!class/merging/*
-keepattributes *Annotation*,InnerClasses
-keepattributes Signature
-keepattributes SourceFile,LineNumberTable

#2.默认保留区
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
-keep public class com.android.vending.licensing.ILicensingService
-keep class android.support.** {*;}

-keepclasseswithmembernames class * {
    native <methods>;
}
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
-keep class **.R$* {
 *;
}
-keepclassmembers class * {
    void *(**On*Event);
}

#3.webview
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.webViewClient {
    public void *(android.webkit.webView, jav.lang.String);
}

 -keepclasseswithmembers class android.app.Notification {*;}

 -keepattributes Exceptions,InnerClasses,Signature
 -keepattributes SourceFile,LineNumberTable

 #start eventbus
 -keep class java.lang.reflect.** { *; }

 # onEvent**方法不混淆
 -keepclassmembers class ** {
     public void onEvent*(**);
     public void onEventMainThread*(**);
 }

 -keepattributes *Annotation*
 -keepclassmembers class ** {
     @org.greenrobot.eventbus.Subscribe <methods>;
 }
 -keep enum org.greenrobot.eventbus.ThreadMode { *; }

 -keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
     <init>(java.lang.Throwable);
 }
 #end eventbus

 #start ButterKnife
 -keep class butterknife.** { *; }
 -dontwarn butterknife.internal.**
 -keep class **$$ViewBinder { *; }

 -keepclasseswithmembernames class * {
 @butterknife.* <fields>;
 }

 -keepclasseswithmembernames class * {
 @butterknife.* <methods>;
 }
 #end ButterKnife

 #start ucrop
-dontwarn com.yalantis.ucrop**
-keep class com.yalantis.ucrop** { *; }
-keep interface com.yalantis.ucrop** { *; }
 #end ucrop

 #------ 工程代码 begin -------------------------------------
 #不混淆资源
 -keep class **.R
 -keep class **.R$* {
     <fields>;
 }


 #native方法不混淆
 -keepclasseswithmembernames class * {
     native <methods>;
 }


 -keepattributes Exceptions,InnerClasses,Signature
 -keepattributes *Annotation*

 #------ 工程代码 end ------

 #------ 过滤第三方依赖 -----------------------------
 #------ 过滤谷歌官方support SART------
 -keep class android.support.v4.**
 -keep class android.support.v7.**
 -keep class android.support.design.**
 -keep class android.support.annotations.**
 #------ 过滤谷歌官方support END ------


-keep public class com.google.gson.**
-keep public class com.google.gson.** {public private protected *;}

-keepattributes Signature
-keepattributes *Annotation*
-keep public class com.project.mocha_patient.login.SignResponseData { private *; }

 -keep class de.greenrobot.event.**
 #-keep class com.iflytek.**{*;}
 -keep class com.squareup.okhttp.**
 -keep class net.sqlcipher.** {*;}

 #不混淆org.apache.http.legacy.jar
 -keep class org.apache.http.**
 -dontwarn android.net.compatibility.**
 -dontwarn android.net.http.**
 -dontwarn com.android.internal.http.multipart.**
 -dontwarn org.apache.commons.**
 -dontwarn org.apache.http.**
 -keep class android.net.compatibility.**{*;}
 -keep class android.net.http.**{*;}
 -keep class com.android.internal.http.multipart.**{*;}
 -keep class org.apache.commons.**{*;}
 -keep class org.apache.http.**{*;}

 #----- photoview START ------
 -dontwarn uk.co.senab.photoview.**
 -keep class uk.co.senab.photoview.** { *;}
 #----- photoview END ------

 #------ 过滤图片加载库 SART------

 -keep class com.bumptech.glide.**
 -keep public class * implements com.bumptech.glide.module.GlideModule
 -keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
       **[] $VALUES;
       public *;
     }

 -keep class com.linkever.xinga.component.IProgressLiveAidlInterface { *; }

 -keep class okhttp3.** {*;}
 -keep class pl.droidsonroids.gif.** { *; }

 -dontwarn javax.annotation.**
 -dontwarn javax.inject.**
 # OkHttp3
 -dontwarn okhttp3.logging.**
 -keep class okhttp3.internal.**{*;}
 -dontwarn okio.**
 # Retrofit
 -dontwarn retrofit2.**
 -keep class retrofit2.** { *; }
 -keepattributes Signature
 -keepattributes Exceptions
 # RxJava RxAndroid
 -dontwarn sun.misc.**
 -keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
     long producerIndex;
     long consumerIndex;
 }
 -keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
     rx.internal.util.atomic.LinkedQueueNode producerNode;
 }
 -keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
     rx.internal.util.atomic.LinkedQueueNode consumerNode;
 }


 -keep class com.hwangjr.** { *; }

 # Gson
 -keep class com.google.gson.stream.** { *; }
 -keepattributes EnclosingMethod

-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}
-keep class android.support.**{*;}
-keep class android.support.**{*;}

-keep public class com.alibaba.android.arouter.routes.**{*;}
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}

-dontwarn com.amap.api.**
-dontwarn com.autonavi.**
-keep class com.amap.api.**{*;}
-keep class com.autonavi.**{*;}
# 地图服务
-dontwarn com.amap.api.services.**
-keep class com.map.api.services.** {*;}
# 3D地图
-dontwarn com.amap.api.mapcore.**
-dontwarn com.amap.api.maps.**
-dontwarn com.autonavi.amap.mapcore.**
-keep class com.amap.api.mapcore.**{*;}
-keep class com.amap.api.maps.**{*;}
-keep class com.autonavi.amap.mapcore.**{*;}
# 定位
-dontwarn com.amap.api.location.**
-dontwarn com.aps.**
-keep class com.amap.api.location.**{*;}
-keep class com.aps.**{*;}

-keep class * extends com.raizlabs.android.dbflow.config.DatabaseHolder { *; }

#mine module包下混淆
-keep class com.linkever.xinga.mine.model.** { *; }

#contact module包下混淆
-keep class com.linkever.xinga.contact.data.** { *; }
-keep class com.chad.library.adapter.** {
*;
}
-keep public class * extends com.chad.library.adapter.base.BaseQuickAdapter
-keep public class * extends com.chad.library.adapter.base.BaseViewHolder
-keepclassmembers  class **$** extends com.chad.library.adapter.base.BaseViewHolder {
     <init>(...);
}


#im module包下混淆
-keep class com.linkever.xinga.im.model.bean.** { *; }
-keep class com.linkever.xinga.im.common.widget.** { *; }

#login module包下混淆
-keep class com.linkever.xinga.login.model.** { *; }

#main module包下混淆
-keep class com.linkever.xinga.main.model.** { *; }

#task module包下混淆
-keep class com.linkever.xinga.task.data.entity.** { *; }

#work module包下混淆
-keep class com.linkever.xinga.work.mvp.model.** { *; }
-keep class com.linkever.xinga.work.injector.module.** { *; }

#common module包下混淆
-keep class com.linkever.xinga.common.model.** { *; }
-keep class com.linkever.xinga.common.injector.module.** { *; }
-keep class com.linkever.xinga.common.sharepreferemces.** { *; }
-keep class net.lucode.hackware.magicindicator.** { *; }
-keep class com.linkever.xinga.common.network.ResponseWrapper { *; }
-keep class com.linkever.xinga.common.network.ResponseWrapperList { *; }
#-libraryjars ../common/libs/magicindicator.jar
#-libraryjars ../common/libs/Msc.jar
#-libraryjars ../common/libs/Sunflower.jar
#-libraryjars ../common/src/main/jniLibs/arm64-v8a/libencrypt.so
#-libraryjars ../common/src/main/jniLibs/armeabi/libencrypt.so
#-libraryjars ../common/src/main/jniLibs/armeabi-v7a/libencrypt.so
#-libraryjars ../common/src/main/jniLibs/mips/libencrypt.so
#-libraryjars ../common/src/main/jniLibs/mips64/libencrypt.so
#-libraryjars ../common/src/main/jniLibs/x86/libencrypt.so
#-libraryjars ../common/src/main/jniLibs/x86_64/libencrypt.so

#component module包下混淆
#-libraryjars ../component/libs/jxmpp-core-0.5.0.jar
#-libraryjars ../component/libs/jxmpp-jid-0.5.0.jar
#-libraryjars ../component/libs/jxmpp-util-cache-0.5.0.jar
#-libraryjars ../component/libs/pinyin4j-2.5.0.jar
#-libraryjars ../component/libs/smack-android-4.2.1.jar
#-libraryjars ../component/libs/smack-android-extensions-4.2.1.jar
#-libraryjars ../component/libs/smack-bosh-4.2.1.jar
#-libraryjars ../component/libs/smack-core-4.2.1.jar
#-libraryjars ../component/libs/smack-experimental-4.2.1.jar
#-libraryjars ../component/libs/smack-extensions-4.2.1.jar
#-libraryjars ../component/libs/smack-im-4.2.1.jar
#-libraryjars ../component/libs/smack-legacy-4.2.1.jar
#-libraryjars ../component/libs/smack-omemo-4.2.1.jar
#-libraryjars ../component/libs/smack-omemo-signal-4.2.1.jar
#-libraryjars ../component/libs/smack-resolver-minidns-4.2.1.jar
#-libraryjars ../component/libs/smack-sasl-provided-4.2.1.jar
#-libraryjars ../component/libs/smack-tcp-4.2.1.jar
#-libraryjars ../component/libs/sun.misc.BASE64Decoder.jar

-keep class com.linkever.xinga.component.entity.** { *; }
-keep class com.linkever.xinga.component.xmpp.model.** { *; }
-keep class com.linkever.xinga.component.factory.** { *; }
-keep class com.linkever.xinga.component.media.** { *; }
-keep class com.linkever.xinga.component.selectContact.** { *; }
-keep class org.jxmpp.** { *; }
-keep class com.hp.hpl.sparta.** { *; }
-keep class org.jivesoftware.** { *; }

-keep class com.linkever.xinga.common.view.** { *; }
-keep class com.linkever.xinga.common.widget.** { *; }
-keep class com.linkever.xinga.component.xmpp.view.** { *; }
-keep class com.linkever.xinga.common.file.uploadFile.NewContractPhotoModel { *; }
-keep class com.linkever.xinga.component.imagereview.RemarkImage {*;}
-keep class com.linkever.xinga.component.imagereview.RemarkList {*;}
-keep class com.linkever.xinga.contact.widget.** { *; }
-keep class com.linkever.xinga.im.widget.** { *; }
-keep class  com.linkever.xinga.login.ScaleCircleNavigator { *; }
-keep class  ru.bartwell.exfilepicker.ui.view.** { *; }
-keep class  com.linkever.xinga.mine.view.** { *; }
-keep class com.linkever.xinga.task.behavior.** { *; }
-keep class  com.linkever.xinga.work.ui.layout.** { *; }
#讯飞aiui
-keep class com.iflytek.**{*;}
-keepattributes Signature