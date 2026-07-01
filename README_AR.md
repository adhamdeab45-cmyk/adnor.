# ADNOR V80 Android APK - Secure Browser No Library Fix

هذه النسخة لا تستخدم WebView ولا مكتبة androidx.browser، لذلك تتجنب خطأ Google disallowed_useragent وتتجنب خطأ بناء androidx.browser.

طريقة العمل:
- التطبيق يظهر باسم ADNOR وبأيقونة ADNOR.
- عند فتح التطبيق يفتح موقع ADNOR في Chrome/المتصفح الآمن.
- تسجيل الدخول باستخدام Google يعمل عبر متصفح آمن بدل WebView.

طريقة الرفع:
1. أنشئ Repository جديد ونظيف باسم adnor-android-v80.
2. ارفع محتويات مجلد adnor_v80_android فقط، وليس المجلد نفسه.
3. يجب أن تظهر في الجذر:
   - .github
   - app
   - build.gradle
   - settings.gradle
   - README_AR.md
4. افتح Actions ثم شغل Build ADNOR APK.
5. بعد نجاح البناء، حمل Artifact باسم ADNOR-APK.
