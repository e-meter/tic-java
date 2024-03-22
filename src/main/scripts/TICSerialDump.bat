@echo off

REM Get script directory
set SCRIPT_DIRECTORY=%~dp0

REM Get library directory
set LIBRARY_DIRECTORY=%SCRIPT_DIRECTORY%\..\lib

REM Run executable
java -cp "%LIBRARY_DIRECTORY%\*" emeter.tic.cmd.TICSerialDump %*