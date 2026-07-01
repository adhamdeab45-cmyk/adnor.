# ADNOR V79 — Android Secure Browser Build Fix

هذه النسخة تصلح فشل GitHub Actions في خطوة `checkDebugAarMetadata`.

## سبب الإصلاح
نسخة V78 كانت تستخدم مكتبة `androidx.browser:browser:1.8.0`، وعلى GitHub Actions ظهر تعارض AAR Metadata.
في V79 ثبتنا المكتبة على نسخة أكثر استقرارًا: `androidx.browser:browser:1.7.0`.

## طريقة الرفع
1. أنشئ Repository جديد باسم مثلًا: `adnor-android-v79`.
2. فك ضغط ZIP.
3. افتح مجلد `adnor_v79_android`.
4. ارفع محتويات المجلد فقط، وليس المجلد نفسه:
   - app
   - .github
   - build.gradle
   - settings.gradle
   - README_AR.md
5. افتح Actions.
6. شغّل `Build ADNOR APK`.
7. بعد نجاح البناء، حمّل Artifacts باسم `ADNOR-APK`.

## ملاحظة
هذه النسخة تفتح موقع ADNOR عبر Chrome Custom Tabs حتى يعمل تسجيل الدخول عبر Google بدون خطأ WebView.
