Function multiplayer_updateplayersize%(arg0%)
    Local local0.breachtypes
    If (player[arg0]\Field92 <> player[arg0]\Field93) Then
        local0 = getbreachtype(player[arg0]\Field51)
        If (player[arg0]\Field40 <> $00) Then
            local0 = getbreachtype(classd_model)
        EndIf
        If (player[arg0]\Field12 <> $00) Then
            scaleentity(player[arg0]\Field12, (local0\Field3 * player[arg0]\Field92), (local0\Field3 * player[arg0]\Field92), (local0\Field3 * player[arg0]\Field92), $00)
        EndIf
        scaleentity(player[arg0]\Field19, (local0\Field10 * player[arg0]\Field92), (local0\Field11 * player[arg0]\Field92), (local0\Field12 * player[arg0]\Field92), $00)
        positionentity(player[arg0]\Field19, 0.0, 0.0, 0.0, $00)
        moveentity(player[arg0]\Field19, 0.0, (-0.2 / player[arg0]\Field92), 0.0)
        If (player[arg0]\Field25 <> Null) Then
            scaleentity(player[arg0]\Field25\Field11, (player[arg0]\Field92 * 0.02), (player[arg0]\Field92 * 0.02), (player[arg0]\Field92 * 0.02), $00)
        EndIf
        If (player[arg0]\Field28 <> Null) Then
            scaleentity(player[arg0]\Field28\Field11, (player[arg0]\Field92 * 0.02), (player[arg0]\Field92 * 0.02), (player[arg0]\Field92 * 0.02), $00)
        EndIf
        If (player[arg0]\Field27 <> Null) Then
            scaleentity(player[arg0]\Field27\Field11, (player[arg0]\Field92 * 0.02), (player[arg0]\Field92 * 0.02), (player[arg0]\Field92 * 0.02), $00)
        EndIf
        If (player[arg0]\Field26 <> Null) Then
            scaleentity(player[arg0]\Field26\Field11, (player[arg0]\Field92 * 0.02), (player[arg0]\Field92 * 0.02), (player[arg0]\Field92 * 0.02), $00)
        EndIf
        player[arg0]\Field93 = player[arg0]\Field92
    EndIf
    Return $00
End Function
