Function multiplayer_updateplayersize%(arg0%)
    Local local0.breachtypes
    Local local1#
    Local local2#
    If (player[arg0]\Field90 <> player[arg0]\Field91) Then
        local0 = getbreachtype(player[arg0]\Field49)
        If (player[arg0]\Field38 <> $00) Then
            local0 = getbreachtype(classd_model)
        EndIf
        If (player[arg0]\Field12 <> $00) Then
            scaleentity(player[arg0]\Field12, (local0\Field3 * player[arg0]\Field90), (local0\Field3 * player[arg0]\Field90), (local0\Field3 * player[arg0]\Field90), $00)
        EndIf
        scaleentity(player[arg0]\Field19, (local0\Field10 * player[arg0]\Field90), (local0\Field11 * player[arg0]\Field90), (local0\Field12 * player[arg0]\Field90), $00)
        positionentity(player[arg0]\Field19, 0.0, 0.0, 0.0, $00)
        moveentity(player[arg0]\Field19, 0.0, (-0.2 / player[arg0]\Field90), 0.0)
        local1 = (player[arg0]\Field90 * 0.04)
        local2 = (player[arg0]\Field90 * 0.07)
        setfontex(fonts[$06]\Field0)
        If (entityexist(player[arg0]\Field25[$00]) <> 0) Then
            scalesprite(player[arg0]\Field25[$00], (((Float stringwidth(player[arg0]\Field24)) * 0.001) * player[arg0]\Field90), (((Float stringheight(player[arg0]\Field24)) * 0.001) * player[arg0]\Field90))
        EndIf
        If (entityexist(player[arg0]\Field25[$03]) <> 0) Then
            scalesprite(player[arg0]\Field25[$03], (((Float stringwidth(player[arg0]\Field86)) * 0.0005) * player[arg0]\Field90), (((Float stringheight(player[arg0]\Field86)) * 0.0005) * player[arg0]\Field90))
        EndIf
        If (entityexist(player[arg0]\Field25[$02]) <> 0) Then
            scalesprite(player[arg0]\Field25[$02], local1, local1)
        EndIf
        If (entityexist(player[arg0]\Field25[$01]) <> 0) Then
            scalesprite(player[arg0]\Field25[$01], local2, local2)
        EndIf
        player[arg0]\Field91 = player[arg0]\Field90
    EndIf
    Return $00
End Function
