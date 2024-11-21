@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  coupon-mgt-system-webflux startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and COUPON_MGT_SYSTEM_WEBFLUX_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH. 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME% 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\coupon-management-system-plain.jar;%APP_HOME%\lib\spring-boot-starter-web-3.1.0.jar;%APP_HOME%\lib\spring-boot-starter-actuator-3.1.0.jar;%APP_HOME%\lib\spring-boot-starter-validation-3.1.0.jar;%APP_HOME%\lib\spring-boot-starter-webflux-3.1.0.jar;%APP_HOME%\lib\spring-boot-starter-json-3.1.0.jar;%APP_HOME%\lib\spring-boot-actuator-autoconfigure-3.1.0.jar;%APP_HOME%\lib\aws-java-sdk-dynamodb-1.12.529.jar;%APP_HOME%\lib\aws-java-sdk-s3-1.12.529.jar;%APP_HOME%\lib\aws-java-sdk-kms-1.12.529.jar;%APP_HOME%\lib\aws-java-sdk-core-1.12.529.jar;%APP_HOME%\lib\jmespath-java-1.12.529.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.15.0.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.15.0.jar;%APP_HOME%\lib\jackson-dataformat-cbor-2.15.0.jar;%APP_HOME%\lib\springdoc-openapi-starter-webflux-ui-2.2.0.jar;%APP_HOME%\lib\springdoc-openapi-starter-webflux-api-2.2.0.jar;%APP_HOME%\lib\springdoc-openapi-starter-webmvc-ui-2.1.0.jar;%APP_HOME%\lib\springdoc-openapi-starter-webmvc-api-2.1.0.jar;%APP_HOME%\lib\springdoc-openapi-starter-common-2.2.0.jar;%APP_HOME%\lib\swagger-core-jakarta-2.2.15.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.15.0.jar;%APP_HOME%\lib\jackson-databind-2.15.0.jar;%APP_HOME%\lib\swagger-models-jakarta-2.2.15.jar;%APP_HOME%\lib\jackson-annotations-2.15.0.jar;%APP_HOME%\lib\jackson-core-2.15.0.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.15.0.jar;%APP_HOME%\lib\dynamodb-enhanced-2.20.26.jar;%APP_HOME%\lib\dynamodb-2.20.26.jar;%APP_HOME%\lib\spring-webflux-6.0.9.jar;%APP_HOME%\lib\spring-boot-starter-reactor-netty-3.1.0.jar;%APP_HOME%\lib\reactor-netty-http-1.1.7.jar;%APP_HOME%\lib\reactor-netty-core-1.1.7.jar;%APP_HOME%\lib\reactor-core-3.5.6.jar;%APP_HOME%\lib\aws-json-protocol-2.20.26.jar;%APP_HOME%\lib\protocol-core-2.20.26.jar;%APP_HOME%\lib\aws-core-2.20.26.jar;%APP_HOME%\lib\auth-2.20.26.jar;%APP_HOME%\lib\regions-2.20.26.jar;%APP_HOME%\lib\sdk-core-2.20.26.jar;%APP_HOME%\lib\endpoints-spi-2.20.26.jar;%APP_HOME%\lib\profiles-2.20.26.jar;%APP_HOME%\lib\apache-client-2.20.26.jar;%APP_HOME%\lib\netty-nio-client-2.20.26.jar;%APP_HOME%\lib\http-client-spi-2.20.26.jar;%APP_HOME%\lib\metrics-spi-2.20.26.jar;%APP_HOME%\lib\json-utils-2.20.26.jar;%APP_HOME%\lib\utils-2.20.26.jar;%APP_HOME%\lib\annotations-2.20.26.jar;%APP_HOME%\lib\third-party-jackson-core-2.20.26.jar;%APP_HOME%\lib\spring-boot-starter-3.1.0.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-3.1.0.jar;%APP_HOME%\lib\spring-webmvc-6.0.9.jar;%APP_HOME%\lib\spring-web-6.0.9.jar;%APP_HOME%\lib\micrometer-core-1.11.0.jar;%APP_HOME%\lib\micrometer-observation-1.11.0.jar;%APP_HOME%\lib\tomcat-embed-el-10.1.8.jar;%APP_HOME%\lib\hibernate-validator-8.0.0.Final.jar;%APP_HOME%\lib\reactive-streams-1.0.4.jar;%APP_HOME%\lib\swagger-ui-5.2.0.jar;%APP_HOME%\lib\spring-boot-autoconfigure-3.1.0.jar;%APP_HOME%\lib\spring-boot-actuator-3.1.0.jar;%APP_HOME%\lib\spring-boot-3.1.0.jar;%APP_HOME%\lib\spring-boot-starter-logging-3.1.0.jar;%APP_HOME%\lib\jakarta.annotation-api-2.1.1.jar;%APP_HOME%\lib\spring-context-6.0.9.jar;%APP_HOME%\lib\spring-aop-6.0.9.jar;%APP_HOME%\lib\spring-beans-6.0.9.jar;%APP_HOME%\lib\spring-expression-6.0.9.jar;%APP_HOME%\lib\spring-core-6.0.9.jar;%APP_HOME%\lib\snakeyaml-1.33.jar;%APP_HOME%\lib\tomcat-embed-websocket-10.1.8.jar;%APP_HOME%\lib\tomcat-embed-core-10.1.8.jar;%APP_HOME%\lib\micrometer-commons-1.11.0.jar;%APP_HOME%\lib\HdrHistogram-2.1.12.jar;%APP_HOME%\lib\LatencyUtils-2.0.3.jar;%APP_HOME%\lib\jakarta.validation-api-3.0.2.jar;%APP_HOME%\lib\jboss-logging-3.5.0.Final.jar;%APP_HOME%\lib\classmate-1.5.1.jar;%APP_HOME%\lib\fastdoubleparser-0.8.0.jar;%APP_HOME%\lib\httpclient-4.5.13.jar;%APP_HOME%\lib\commons-logging-1.2.jar;%APP_HOME%\lib\commons-codec-1.15.jar;%APP_HOME%\lib\ion-java-1.0.2.jar;%APP_HOME%\lib\joda-time-2.8.1.jar;%APP_HOME%\lib\logback-classic-1.4.7.jar;%APP_HOME%\lib\log4j-to-slf4j-2.20.0.jar;%APP_HOME%\lib\jul-to-slf4j-2.0.7.jar;%APP_HOME%\lib\slf4j-api-2.0.7.jar;%APP_HOME%\lib\eventstream-1.0.1.jar;%APP_HOME%\lib\httpcore-4.4.16.jar;%APP_HOME%\lib\netty-codec-http2-4.1.92.Final.jar;%APP_HOME%\lib\netty-handler-proxy-4.1.92.Final.jar;%APP_HOME%\lib\netty-codec-http-4.1.92.Final.jar;%APP_HOME%\lib\netty-resolver-dns-native-macos-4.1.92.Final-osx-x86_64.jar;%APP_HOME%\lib\netty-resolver-dns-classes-macos-4.1.92.Final.jar;%APP_HOME%\lib\netty-resolver-dns-4.1.92.Final.jar;%APP_HOME%\lib\netty-handler-4.1.92.Final.jar;%APP_HOME%\lib\netty-codec-dns-4.1.92.Final.jar;%APP_HOME%\lib\netty-codec-socks-4.1.92.Final.jar;%APP_HOME%\lib\netty-codec-4.1.92.Final.jar;%APP_HOME%\lib\netty-transport-native-epoll-4.1.92.Final-linux-x86_64.jar;%APP_HOME%\lib\netty-transport-classes-epoll-4.1.92.Final.jar;%APP_HOME%\lib\netty-transport-native-unix-common-4.1.92.Final.jar;%APP_HOME%\lib\netty-transport-4.1.92.Final.jar;%APP_HOME%\lib\netty-buffer-4.1.92.Final.jar;%APP_HOME%\lib\netty-resolver-4.1.92.Final.jar;%APP_HOME%\lib\netty-common-4.1.92.Final.jar;%APP_HOME%\lib\spring-jcl-6.0.9.jar;%APP_HOME%\lib\logback-core-1.4.7.jar;%APP_HOME%\lib\log4j-api-2.20.0.jar;%APP_HOME%\lib\commons-lang3-3.12.0.jar;%APP_HOME%\lib\swagger-annotations-jakarta-2.2.15.jar;%APP_HOME%\lib\jakarta.xml.bind-api-4.0.0.jar;%APP_HOME%\lib\jakarta.activation-api-2.1.2.jar


@rem Execute coupon-mgt-system-webflux
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %COUPON_MGT_SYSTEM_WEBFLUX_OPTS%  -classpath "%CLASSPATH%"  %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable COUPON_MGT_SYSTEM_WEBFLUX_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%COUPON_MGT_SYSTEM_WEBFLUX_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
