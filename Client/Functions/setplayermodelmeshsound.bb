Function setplayermodelmeshsound%(arg0%, arg1%, arg2$)
    Local local0%
    Local local1%
    Local local2.mp_modelmesh
    If ((((playermodels[arg0] = Null) Lor (arg0 = $00)) Lor (arg1 >= $04)) <> 0) Then
        Return $00
    EndIf
    If (arg2 = "") Then
        playermodels[arg0]\Field4\Field29[arg1] = $00
        playermodels[arg0]\Field4\Field27 = $00
        For local0 = $00 To $03 Step $01
            If (playermodels[arg0]\Field4\Field29[local0] <> $00) Then
                playermodels[arg0]\Field4\Field27 = (playermodels[arg0]\Field4\Field27 + $01)
            EndIf
        Next
        Return $00
    EndIf
    local1 = $FFFFFFFF
    For local2 = Each mp_modelmesh
        For local0 = $00 To $03 Step $01
            If (local2\Field4\Field28[local0] = arg2) Then
                local1 = local2\Field4\Field29[local0]
                Exit
            EndIf
        Next
        If (local1 <> $FFFFFFFF) Then
            Exit
        EndIf
    Next
    If (local1 = $FFFFFFFF) Then
        local1 = loadsound_strict(arg2)
    EndIf
    playermodels[arg0]\Field4\Field28[arg1] = arg2
    playermodels[arg0]\Field4\Field29[arg1] = local1
    playermodels[arg0]\Field4\Field27 = $00
    For local0 = $00 To $03 Step $01
        If (playermodels[arg0]\Field4\Field29[local0] <> $00) Then
            playermodels[arg0]\Field4\Field27 = (playermodels[arg0]\Field4\Field27 + $01)
        EndIf
    Next
    Return $01
    Return $00
End Function
