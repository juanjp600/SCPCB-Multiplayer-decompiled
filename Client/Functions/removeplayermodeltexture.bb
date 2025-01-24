Function removeplayermodeltexture%(arg0%)
    If (playermodeltexture[arg0] = Null) Then
        Return $00
    EndIf
    Delete playermodeltexture[arg0]
    Return $00
End Function
