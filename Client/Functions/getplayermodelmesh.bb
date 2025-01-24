Function getplayermodelmesh%(arg0%)
    If (playermodels[arg0] = Null) Then
        Return $00
    EndIf
    Return playermodels[arg0]\Field2
    Return $00
End Function
