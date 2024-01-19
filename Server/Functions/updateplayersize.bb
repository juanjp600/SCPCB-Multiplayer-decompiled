Function updateplayersize%(arg0%)
    Local local0.breachtypes
    If (player[arg0]\Field29 <> player[arg0]\Field28) Then
        For local0 = Each breachtypes
            If (local0\Field1 = player[arg0]\Field36) Then
                scaleentity(player[arg0]\Field69, (local0\Field10 * player[arg0]\Field28), (local0\Field11 * player[arg0]\Field28), (local0\Field12 * player[arg0]\Field28), $00)
                positionentity(player[arg0]\Field69, 0.0, 0.0, 0.0, $00)
                positionentity(player[arg0]\Field68, 0.0, 0.0, 0.0, $00)
                moveentity(player[arg0]\Field69, 0.0, (-0.2 / player[arg0]\Field28), 0.0)
                moveentity(player[arg0]\Field68, 0.0, (player[arg0]\Field28 * 0.6), 0.0)
                Exit
            EndIf
        Next
        player[arg0]\Field29 = player[arg0]\Field28
    EndIf
    Return $00
End Function
