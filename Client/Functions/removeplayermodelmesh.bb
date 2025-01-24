Function removeplayermodelmesh%(arg0%)
    If (playermodels[arg0] = Null) Then
        Return $00
    EndIf
    freeentity(playermodels[arg0]\Field2)
    playermodels[arg0]\Field2 = $00
    Delete playermodels[arg0]\Field4
    Delete playermodels[arg0]
    Return $00
End Function
