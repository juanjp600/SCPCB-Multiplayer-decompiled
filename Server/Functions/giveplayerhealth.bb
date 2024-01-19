Function giveplayerhealth%(arg0%, arg1#, arg2$)
    If (((player[arg0]\Field101 And (0.0 > arg1)) Or (server\Field57 = $00)) <> 0) Then
        Return $00
    EndIf
    If (player[arg0]\Field59 <> 0) Then
        Return $00
    EndIf
    player[arg0]\Field60 = (player[arg0]\Field60 + arg1)
    If (player[arg0]\Field60 >= (Float player[arg0]\Field96)) Then
        player[arg0]\Field96 = (Int player[arg0]\Field60)
        player[arg0]\Field61 = 0.0
    EndIf
    If (mp_isascp(player[arg0]\Field36) = $00) Then
        If ((Float player[arg0]\Field96) <= player[arg0]\Field60) Then
            player[arg0]\Field61 = 0.0
        Else
            player[arg0]\Field61 = max((((Float player[arg0]\Field96) / max(player[arg0]\Field60, 1.0)) / 1.5), 0.0)
        EndIf
    Else
        player[arg0]\Field61 = 0.0
    EndIf
    If (1.0 > player[arg0]\Field60) Then
        playerdead(arg0, arg2)
        Return $01
    EndIf
    Return $00
    Return $00
End Function
