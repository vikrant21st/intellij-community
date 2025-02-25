package com.intellij.codeInspection.tests.logging

import com.intellij.codeInspection.tests.UastInspectionTestBase

abstract class LoggingInspectionTestBase : UastInspectionTestBase() {

  override fun setUp() {
    super.setUp()
    myFixture.addClass("""
      package org.slf4j.spi;
      public interface LoggingEventBuilder {
         void log(String format, Object... arguments);
      }
    """.trimIndent())
    myFixture.addClass("""
      package org.slf4j; 
      import org.slf4j.spi.LoggingEventBuilder; 
      public class LoggerFactory { 
      public static Logger getLogger(Class clazz) { return null; }
      public static Logger getLogger() { return null; }
      }
      public interface Logger { 
         void info(String format, Object... arguments); 
         LoggingEventBuilder atInfo(); 
         LoggingEventBuilder atError(); 
      }
    """.trimIndent())
    myFixture.addClass("""
      package org.apache.logging.log4j;
      import org.apache.logging.log4j.util.Supplier;
      public interface Logger {
        void info(String message, Object... params);
        void info(String message);
        void fatal(String message, Object... params);
        void error(Supplier<?> var1, Throwable var2);
        void info(String message, Supplier<?>... params);
        LogBuilder atInfo();
        LogBuilder atFatal();
        LogBuilder atError();
      }
    """.trimIndent())
    myFixture.addClass("""
      package org.apache.logging.log4j;
      public class LogManager {
        public static Logger getLogger() {
          return null;
        }
        public static Logger getFormatterLogger() {
          return null;
        }
      }
    """.trimIndent())
    myFixture.addClass("""
      package org.apache.logging.log4j.util;
      public interface Supplier<T> {
          T get();
      }
    """.trimIndent())
    myFixture.addClass("""
      package org.apache.logging.log4j;
      import org.apache.logging.log4j.util.Supplier;
      public interface LogBuilder {
        void log(String format);
        void log(String format, Object p0);
        void log(String format, Object... params);
        void log(String format, Supplier<?>... params);
      }
    """.trimIndent())
  }
}