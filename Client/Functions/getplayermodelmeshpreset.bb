Function getplayermodelmeshpreset.mp_modelmeshpreset(arg0%)
    If (playermodels[arg0] = Null) Then
        Return Null
    EndIf
    Return playermodels[arg0]\Field4
    Return Null
End Function
