Function setplayermodelterminatedtexture%(arg0%, arg1$)
    If (playermodeltexture[arg0] = Null) Then
        Return $00
    EndIf
    playermodeltexture[arg0]\Field4 = loadtexture_strict(arg1, $01, $01, $01)
    playermodeltexture[arg0]\Field2 = arg1
    Return $00
End Function
