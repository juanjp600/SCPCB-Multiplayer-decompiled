Function getplayermodeltexture%(arg0%)
    If (playermodeltexture[arg0] = Null) Then
        Return $00
    EndIf
    Return playermodeltexture[arg0]\Field3
    Return $00
End Function
