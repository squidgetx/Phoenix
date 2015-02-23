@echo off
cd %0\..
rabbitsign -r %1 -o %1
echo Signing Complete!
pause