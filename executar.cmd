@echo off
setlocal
pushd "%~dp0"

where javac >nul 2>nul
if errorlevel 1 goto sem_java
where java >nul 2>nul
if errorlevel 1 goto sem_java

javac --release 17 -encoding UTF-8 -d out src\Main.java src\Denuncia.java
if errorlevel 1 goto falha
java -cp out Main
if errorlevel 1 goto falha

popd
exit /b 0

:sem_java
echo Instale um JDK 17 ou superior e coloque java e javac no PATH.
:falha
echo Nao foi possivel compilar ou executar o programa.
popd
exit /b 1
