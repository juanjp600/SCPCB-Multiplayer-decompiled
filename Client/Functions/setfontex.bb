Function setfontex%(arg0%)
    If (lastfont <> arg0) Then
        setfont(arg0)
        lastfont = arg0
    EndIf
    Return $00
End Function
