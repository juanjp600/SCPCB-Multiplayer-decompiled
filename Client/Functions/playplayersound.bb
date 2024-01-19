Function playplayersound%(arg0.players, arg1$, arg2#, arg3#, arg4%)
    Local local0%
    Local local1.sound
    local0 = arg4
    If (local0 <> $01) Then
        If (instr(arg1, "SFX\General\Slash", $01) <> 0) Then
            If (multiplayer_breach_isa035(arg0\Field51) = $00) Then
                arg0\Field56 = $0F
            EndIf
        ElseIf (instr(arg1, "SFX\Guns\Knife", $01) <> 0) Then
            arg0\Field56 = $0F
            arg0\Field99 = $01
        ElseIf (instr(lower(arg1), "reload", $01) <> 0) Then
            arg0\Field100 = $01
        ElseIf (instr(lower(arg1), "deploy", $01) <> 0) Then
            arg0\Field101 = $01
        ElseIf (arg1 = "SFX\SCP\513\Bell1.ogg") Then
            If (curr5131 = Null) Then
                curr5131 = createnpc($0C, 0.0, 0.0, 0.0)
                curr5131\Field78 = $01
            EndIf
        EndIf
    Else
    EndIf
    If (arg1 <> "") Then
        For local1 = Each sound
            If (local1\Field1 = arg1) Then
                play3dsound((Handle local1), camera, arg0\Field13, arg2, arg3, "")
                arg1 = ""
                Exit
            EndIf
        Next
        If (arg1 <> "") Then
            play3dsound($00, camera, arg0\Field13, arg2, arg3, arg1)
        EndIf
    EndIf
    Return $00
End Function
