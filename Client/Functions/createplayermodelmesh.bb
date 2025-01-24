Function createplayermodelmesh.mp_modelmesh(arg0%, arg1$, arg2%)
    If (playermodels[arg0] <> Null) Then
        Return Null
    EndIf
    arg1 = lower(arg1)
    playermodels[arg0] = (New mp_modelmesh)
    playermodels[arg0]\Field4 = (New mp_modelmeshpreset)
    playermodels[arg0]\Field0 = arg0
    playermodels[arg0]\Field2 = loadanimmesh_strict(arg1, $00)
    playermodels[arg0]\Field1 = arg1
    playermodels[arg0]\Field3 = arg2
    hideentity(playermodels[arg0]\Field2)
    Return playermodels[arg0]
    Return Null
End Function
