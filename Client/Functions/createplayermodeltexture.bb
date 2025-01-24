Function createplayermodeltexture.mp_modeltexture(arg0%, arg1$, arg2%)
    If (playermodeltexture[arg0] <> Null) Then
        Return Null
    EndIf
    playermodeltexture[arg0] = (New mp_modeltexture)
    playermodeltexture[arg0]\Field0 = arg0
    playermodeltexture[arg0]\Field3 = loadtexture_strict(arg1, $01, $01, $01)
    playermodeltexture[arg0]\Field1 = arg1
    playermodeltexture[arg0]\Field5 = arg2
    Return playermodeltexture[arg0]
    Return Null
End Function
