#include <jni.h>
#include <stdlib.h>

extern "C"
JNIEXPORT jint JNICALL
Java_id_ac_ui_cs_mobileprogramming_yama_caloriemeter_MainActivity_randomAdd(JNIEnv *env,
                                                                            jobject thiz,
                                                                            jint counter) {
    int random = rand() % 100;
    return counter+random;
}