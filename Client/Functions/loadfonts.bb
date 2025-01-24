Function loadfonts%()
    If (opt\Field40 = $00) Then
        fo\Field0[$00] = loadfont_strict(("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Default", "File", "", $01)), (Int getfilelocalstring("Data\fonts.ini", "Default", "Size", "", $01)), $00, $00)
    EndIf
    fo\Field0[$01] = loadfont_strict(("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Default_Big", "File", "", $01)), (Int getfilelocalstring("Data\fonts.ini", "Default_Big", "Size", "", $01)), $00, $00)
    fo\Field0[$02] = loadfont_strict(("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Digital", "File", "", $01)), (Int getfilelocalstring("Data\fonts.ini", "Digital", "Size", "", $01)), $00, $00)
    fo\Field0[$03] = loadfont_strict(("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Digital_Big", "File", "", $01)), (Int getfilelocalstring("Data\fonts.ini", "Digital_Big", "Size", "", $01)), $00, $00)
    fo\Field0[$04] = loadfont_strict(("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Journal", "File", "", $01)), (Int getfilelocalstring("Data\fonts.ini", "Journal", "Size", "", $01)), $00, $00)
    fo\Field0[$05] = loadfont_strict(("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Console", "File", "", $01)), (Int getfilelocalstring("Data\fonts.ini", "Console", "Size", "", $01)), $00, $00)
    fo\Field0[$08] = loadfont_strict(("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Tahoma", "File", "", $01)), (Int getfilelocalstring("Data\fonts.ini", "Tahoma", "Size", "", $01)), $00, $00)
    fo\Field0[$09] = loadfont_strict(("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Icons", "File", "", $01)), (Int getfilelocalstring("Data\fonts.ini", "Icons", "Size", "", $01)), $00, $00)
    fo\Field0[$0A] = loadfont_strict(("GFX\Fonts\" + getfilelocalstring("Data\fonts.ini", "Default_Medium", "File", "", $01)), (Int getfilelocalstring("Data\fonts.ini", "Default_Medium", "Size", "", $01)), $00, $00)
    Return $00
End Function
