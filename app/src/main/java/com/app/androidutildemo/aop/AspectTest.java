package com.app.androidutildemo.aop;

import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.app.androidutildemo.ui.activity.MainActivity;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.constant.PermissionConstants.Permission;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nick on 2019-09-19.
 */
@Aspect
public class AspectTest {

    private static final String TAG = "nick";



    @Before("execution(* com.app.androidutildemo.ui.activity.MainActivity.doNickBurningPoint(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Object[] args = joinPoint.getArgs();
        MainActivity mainActivity = (MainActivity) joinPoint.getThis();

        Log.e(TAG, "onActivityMethodBefore: " + key);
        Log.e(TAG, "onActivityMethodBefore: " + args.toString());
        Log.e(TAG, "onActivityMethodBefore: " + mainActivity.getClass().getSimpleName());

    }

    @Pointcut("execution(@com.app.androidutildemo.aop.Bury * *(..))")
    public void buryMethod(){}

    @Around("buryMethod()")
    public void doBury(ProceedingJoinPoint joinPoint) throws Throwable{
        Log.e(TAG,"执行埋点代码");
        MainActivity mainActivity = (MainActivity) joinPoint.getThis();
        Log.e(TAG,"当前类:"+mainActivity.getClass().getSimpleName());
        Object[] args = joinPoint.getArgs();
        Log.e(TAG,"参数个数:"+args.length);
        for (Object o: args) {
            Log.e(TAG,"参数值:"+o);
        }
        joinPoint.proceed();
        Log.e(TAG,"AOP结束");
    }

    @Pointcut("execution(@com.app.androidutildemo.aop.NickPermission * *(..))")
//    @Pointcut("execution(* com.app.androidutildemo.ui.activity.MainActivity.initPermission(..))")
    public void permissionMethod(){}

    @Around("permissionMethod() && args(params,..)")
    public void requestPermision(ProceedingJoinPoint joinPoint,String params){
        Log.e(TAG,"参数值:"+params);
        try {
            NickPermission methodAnnotation = getMethodAnnotation(joinPoint, NickPermission.class);
            Log.e(TAG,"获取到注解类");
            @Permission String[] permissionGroup = methodAnnotation.value();

            List<String> permissionList = new ArrayList<>();

            for (String permission : permissionGroup) {
                Log.e(TAG,"获取到注解值>>>"+permission);
                String[] permissions = PermissionConstants.getPermissions(permission);
                permissionList.addAll(Arrays.asList(permissions));
            }
            if (hasPermission(permissionList)){
                joinPoint.proceed();
            }else {
                PermissionUtils.permission(permissionGroup)
                        .request();
            }
        } catch (Throwable throwable) {
            Log.e(TAG,"业务逻辑出错了???"+throwable.getMessage());
        }

    }

    /**
     * 判断是否有指定的权限
     */
    private boolean hasPermission(List<String> permissions) {
        for (String permisson : permissions) {
            if (ContextCompat.checkSelfPermission(Utils.getApp(), permisson)
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    private <T extends Annotation> T getMethodAnnotation(ProceedingJoinPoint joinPoint, Class<T> clazz) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        return method.getAnnotation(clazz);
    }


}
