Function setattachmodelsound%(arg0%, arg1%, arg2$)
    Local local0%
    Local local1%
    Local local2.mp_attachmodel
    If ((((attachmodels[arg0] = Null) Lor (arg0 = $00)) Lor (arg1 >= $04)) <> 0) Then
        Return $00
    EndIf
    If (arg2 = "") Then
        attachmodels[arg0]\Field8[arg1] = $00
        attachmodels[arg0]\Field6 = $00
        For local0 = $00 To $03 Step $01
            If (attachmodels[arg0]\Field8[local0] <> $00) Then
                attachmodels[arg0]\Field6 = (attachmodels[arg0]\Field6 + $01)
            EndIf
        Next
        Return $00
    EndIf
    local1 = $FFFFFFFF
    For local2 = Each mp_attachmodel
        For local0 = $00 To $03 Step $01
            If (local2\Field7[local0] = arg2) Then
                local1 = local2\Field8[local0]
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
    attachmodels[arg0]\Field7[arg1] = arg2
    attachmodels[arg0]\Field8[arg1] = local1
    attachmodels[arg0]\Field6 = $00
    For local0 = $00 To $03 Step $01
        If (attachmodels[arg0]\Field8[local0] <> $00) Then
            attachmodels[arg0]\Field6 = (attachmodels[arg0]\Field6 + $01)
        EndIf
    Next
    Return $01
    Return $00
End Function
