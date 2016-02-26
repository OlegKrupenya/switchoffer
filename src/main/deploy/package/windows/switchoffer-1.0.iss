;This file will be executed next to the application bundle image
;I.e. current directory will contain folder switchoffer-1.0 with application files
[Setup]
AppId={{com.testdev.main}}
AppName=Switchoffer
AppVersion=1.0
AppVerName=Switchoffer 1.0
AppPublisher=Oleg Krupenya
AppComments=Application that shuts down the computer by timer.
AppCopyright=Copyright (C) 2016
;AppPublisherURL=http://java.com/
;AppSupportURL=http://java.com/
;AppUpdatesURL=http://java.com/
DefaultDirName={localappdata}\Switchoffer
DisableStartupPrompt=Yes
DisableDirPage=No
DisableProgramGroupPage=Yes
DisableReadyPage=Yes
DisableFinishedPage=Yes
DisableWelcomePage=Yes
DefaultGroupName=Oleg Krupenya
;Optional License
LicenseFile=
;WinXP or above
MinVersion=0,5.1 
OutputBaseFilename=switchoffer-1.0-installer
Compression=lzma
SolidCompression=yes
PrivilegesRequired=lowest
SetupIconFile=switchoffer-1.0\switchoffer-1.0.ico
UninstallDisplayIcon={app}\switchoffer-1.0.ico
UninstallDisplayName=Switchoffer
WizardImageStretch=No
WizardSmallImageFile=switchoffer-1.0-setup-icon.bmp
ArchitecturesInstallIn64BitMode=x64


[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Files]
Source: "switchoffer-1.0\switchoffer-1.0.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "switchoffer-1.0\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\switchoffer-1.0"; Filename: "{app}\switchoffer-1.0.exe"; IconFilename: "{app}\switchoffer-1.0.ico"; Check: returnTrue()
Name: "{commondesktop}\switchoffer-1.0"; Filename: "{app}\switchoffer-1.0.exe";  IconFilename: "{app}\switchoffer-1.0.ico"; Check: returnFalse()


[Run]
Filename: "{app}\switchoffer-1.0.exe"; Parameters: "-Xappcds:generatecache"; Check: returnFalse()
Filename: "{app}\switchoffer-1.0.exe"; Description: "{cm:LaunchProgram,switchoffer-1.0}"; Flags: nowait postinstall skipifsilent; Check: returnTrue()
Filename: "{app}\switchoffer-1.0.exe"; Parameters: "-install -svcName ""switchoffer-1.0"" -svcDesc ""switchoffer-1.0"" -mainExe ""switchoffer-1.0.exe""  "; Check: returnFalse()

[UninstallRun]
Filename: "{app}\switchoffer-1.0.exe "; Parameters: "-uninstall -svcName switchoffer-1.0 -stopOnUninstall"; Check: returnFalse()

[Code]
function returnTrue(): Boolean;
begin
  Result := True;
end;

function returnFalse(): Boolean;
begin
  Result := False;
end;

function InitializeSetup(): Boolean;
begin
// Possible future improvements:
//   if version less or same => just launch app
//   if upgrade => check if same app is running and wait for it to exit
//   Add pack200/unpack200 support? 
  Result := True;
end;  
