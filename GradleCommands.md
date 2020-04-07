Go to the EAR folder in command prompt:
C:\XXXXXXXXXXXXXEAR
And use this command to build EAR.

gradle clean ear --info
gradle clean testall --info
gradle clean testAll ear –-info

From folder :      C:\XXXXXXXXXXEAR\build\distributions
To folder :        C:\WASLP_dev\tools\WASLP8559\wlp\usr\servers\default\dropins
Windows command to copy the EAR from a source folder to a destination folder:
xcopy C:\XXXXXXXXXXXXXXEAR\build\distributions C:\WASLP_dev\tools\WASLP8559\wlp\usr\servers\default\dropins

From folder :      C:\WASLP_dev\workspaces\CommerceWay\PiAcordSalesMediationServiceEAR\build\distributions
From folder :      C:\Users\n0281526\Documents\services-property-insurance-partner-exchange\PiAcordSalesMediationServiceEAR
To folder :        C:\WASLP_dev\tools\WASLP8559\wlp\usr\servers\default\dropins
Windows command to copy the EAR from a source folder to a destination folder:
xcopy C:\WASLP_dev\workspaces\git_repo\services-property-insurance-partner-exchange\PiAcordSalesMediationServiceEAR\build\distributions C:\WASLP_dev\tools\WASLP8559\wlp\usr\servers\default\dropins

---------------------------------------------------------------------------
To exclude a few tasks from the build process : 
./gradlew build -x checkstyleMain -x findbugsMain -x test -x jacocoTestCoverageVerification -x pmdMain
