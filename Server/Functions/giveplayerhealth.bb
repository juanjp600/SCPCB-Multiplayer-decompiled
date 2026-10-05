Function giveplayerhealth%(arg0%, arg1#, arg2$)
    If (((player[arg0]\Field103 And (0.0 > arg1)) Or (server\Field56 = $00)) <> 0) Then
        Return $00
    EndIf
    If (player[arg0]\Field61 <> 0) Then
        Return $00
    EndIf
    player[arg0]\Field62 = (player[arg0]\Field62 + arg1)
    If (player[arg0]\Field62 >= (Float player[arg0]\Field98)) Then
        player[arg0]\Field98 = (Int player[arg0]\Field62)
        player[arg0]\Field63 = 0.0
    EndIf
    If (mp_isascp(player[arg0]\Field36) = $00) Then
        If ((Float player[arg0]\Field98) <= player[arg0]\Field62) Then
            player[arg0]\Field63 = 0.0
        Else
            player[arg0]\Field63 = max((((Float player[arg0]\Field98) / max(player[arg0]\Field62, 1.0)) / 1.5), 0.0)
        EndIf
    Else
        player[arg0]\Field63 = 0.0
    EndIf
    If (1.0 > player[arg0]\Field62) Then
        playerdead(arg0, arg2)
        Return $01
    EndIf
    Return $00
    Return $00
End Function
