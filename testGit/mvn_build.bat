set "projectName=day2Mockito"
git clone https://github.com/ming0601/%projectName%.git
cd C:\Users\Adminl\Desktop\testGit\%projectName%
powershell "mvn clean package | tee package_output.txt"
