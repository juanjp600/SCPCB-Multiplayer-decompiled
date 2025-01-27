Function setlanguage%(arg0$, arg1%)
    If (lang\Field1 <> "") Then
        iniclearbuffer((lang\Field1 + "Data\local.ini"))
        iniclearbuffer((lang\Field1 + "Data\fonts.ini"))
        iniclearbuffer((lang\Field1 + "Data\achievements.jsonc"))
    EndIf
    lang\Field0 = arg0
    If (lang\Field0 = "en") Then
        lang\Field1 = ""
    Else
        lang\Field1 = (("Localization\" + lang\Field0) + "\")
        iniwritebuffer((lang\Field1 + "Data\local.ini"), "", $01)
        iniwritebuffer((lang\Field1 + "Data\MP_local.ini"), (lang\Field1 + "Data\local.ini"), $00)
        iniwritebuffer((lang\Field1 + "Data\fonts.ini"), "", $01)
        iniwritebuffer((lang\Field1 + "Data\achievements.jsonc"), "", $01)
    EndIf
    If (stringtoboolean(getlocalstring("global", "splitwithspace"), $00) <> 0) Then
        splitspace = " "
    Else
        splitspace = ""
    EndIf
    opt\Field55 = arg0
    initkeynames()
    If (fo\Field0[$00] <> $00) Then
        freefont(fo\Field0[$00])
    EndIf
    fo\Field0[$00] = loadfont_strict(("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Default", "File", "", $01)), (Int getfilelocalstring("Data\fonts.ini", "Default", "Size", "", $01)), $01, $00)
    If (arg1 <> 0) Then
        apptitle(getlocalstring("language", "title"), "")
    Else
        apptitle(getlocalstring("launcher", "title"), "")
    EndIf
    Return $00
End Function
