package com.matthewyao.work;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by yaokuan on 2017/11/6.
 */
public class SrpingBeanUtils {
    static class FromClass {
        int cityId;

        public FromClass() {
        }

        public FromClass(int cityId) {
            this.cityId = cityId;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        @Override
        public String toString() {
            return "FromClass{" +
                    "cityId=" + cityId +
                    '}';
        }
    }

    static class ToClass {
        Short cityId;

        public ToClass() {
        }

        public ToClass(Short cityId) {
            this.cityId = cityId;
        }

        public int getCityId() {
            return cityId.intValue();
        }

        public void setCityId(int cityId) {
            this.cityId = new Short(String.valueOf(cityId));
        }

        @Override
        public String toString() {
            return "ToClass{" +
                    "cityId=" + cityId +
                    '}';
        }
    }

    static void testSpringBeanUtils() {
        FromClass from = new FromClass(24);
        ToClass to = new ToClass();
        BeanUtils.copyProperties(from, to);
        System.out.println(to);
    }

    static void testSpringBeanUtils1() {
        ToClass to = new ToClass(new Short("1"));
        FromClass from = new FromClass();
        BeanUtils.copyProperties(to, from);
        System.out.println(from);
    }

    static void testApacheBeanUtils() {
        FromClass from = new FromClass(24);
        ToClass to = new ToClass();
        try {
            org.apache.commons.beanutils.BeanUtils.copyProperties(from, to);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(to);
    }

    public static void main(String[] args) {
        testSpringBeanUtils();
//        testApacheBeanUtils();
    }
}
