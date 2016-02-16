;This file will be executed next to the application bundle image
;I.e. current directory will contain folder shitchoffer-1.0 with application files
[Setup]
AppId={{com.testdev.main}}
AppName=shitchoffer-1.0
AppVersion=1.0
AppVerName=shitchoffer-1.0 1.0
AppPublisher=Oleg Krupenya
AppComments=shitchoffer-1.0
AppCopyright=Copyright (C) 2016
;AppPublisherURL=http://java.com/
;AppSupportURL=http://java.com/
;AppUpdatesURL=http://java.com/
DefaultDirName={localappdata}\shitchoffer-1.0
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
OutputBaseFilename=shitchoffer-1.0-1.0
Compression=lzma
SolidCompression=yes
PrivilegesRequired=lowest
SetupIconFile=shitchoffer-1.0\shitchoffer-1.0.ico
UninstallDisplayIcon={app}\shitchoffer-1.0.ico
UninstallDisplayName=shitchoffer-1.0
WizardImageStretch=No
WizardSmallImageFile=shitchoffer-1.0-setup-icon.bmp   
ArchitecturesInstallIn64BitMode=x64


[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Files]
Source: "shitchoffer-1.0\shitchoffer-1.0.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "shitchoffer-1.0\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\shitchoffer-1.0"; Filename: "{app}\shitchoffer-1.0.exe"; IconFilename: "{app}\shitchoffer-1.0.ico"; Check: returnTrue()
Name: "{commondesktop}\shitchoffer-1.0"; Filename: "{app}\shitchoffer-1.0.exe";  IconFilename: "{app}\shitchoffer-1.0.ico"; Check: returnFalse()


[Run]
Filename: "{app}\shitchoffer-1.0.exe"; Parameters: "-Xappcds:generatecache"; Check: returnFalse()
Filename: "{app}\shitchoffer-1.0.exe"; Description: "{cm:LaunchProgram,shitchoffer-1.0}"; Flags: nowait postinstall skipifsilent; Check: returnTrue()
Filename: "{app}\shitchoffer-1.0.exe"; Parameters: "-install -svcName ""shitchoffer-1.0"" -svcDesc ""shitchoffer-1.0"" -mainExe ""shitchoffer-1.0.exe""  "; Check: returnFalse()

[UninstallRun]
Filename: "{app}\shitchoffer-1.0.exe "; Parameters: "-uninstall -svcName shitchoffer-1.0 -stopOnUninstall"; Check: returnFalse()

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
