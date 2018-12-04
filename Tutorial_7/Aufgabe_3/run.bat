@echo off
javac -cp ".;%MPJ_HOME%/lib/mpj.jar" Program.java
%MPJ_HOME%/bin/mpjrun.bat -np 4 Program