Function getplayermodelterminatedtexture%(arg0%)
    If (playermodeltexture[arg0] = Null) Then
        Return $00
    EndIf
    If (playermodeltexture[arg0]\Field4 = $00) Then
        Return playermodeltexture[arg0]\Field3
    EndIf
    Return playermodeltexture[arg0]\Field4
    Return $00
End Function
