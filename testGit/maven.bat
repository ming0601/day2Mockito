@echo off

set "HOME_DIR=%cd%"
set "PROJECT_NAME=day2Mockito"
set "REPO_URL=https://github.com/ming0601/%PROJECT_NAME%"

rem Supprime le projet et les .jar/.war déjà éxistants
DEL /F/Q/S "%PROJECT_NAME%" > NUL
RMDIR /Q/S "%PROJECT_NAME%"
DEL /F/Q/S "%HOME_DIR%\*.*ar" > NUL
RMDIR /Q/S "%HOME_DIR%\*.*ar"

git clone %REPO_URL%

cd "%PROJECT_NAME%"

powershell "mvn install | tee %HOME_DIR%\log.txt"

xcopy /Y %HOME_DIR%\%PROJECT_NAME%\target\*.*ar %HOME_DIR%